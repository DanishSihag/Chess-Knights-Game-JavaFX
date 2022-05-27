package Controller;

import javafx.beans.binding.Bindings;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.tinylog.Logger;
import state.Square;
import state.BoardGameModel;
import javafx.beans.binding.ObjectBinding;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import state.TemporaryVariables;

import java.net.URISyntaxException;


public class GameController {

    @FXML
    private GridPane board;

    private BoardGameModel model = new BoardGameModel();

    private TemporaryVariables temporaryVariables = new TemporaryVariables();

    @FXML
    private TextField numberOfMovesField;

    Image black;
    Image white;

    {
        try {
            black = new Image(String.valueOf(this.getClass().getClassLoader().getResource("Images/BlackKnight.jpg").toURI()));
            Logger.debug("Loading {} image.", black);
        } catch (URISyntaxException e) {
            Logger.error("Image not found.");
            e.printStackTrace();
        }
    }

    {
        try {
            white = new Image(String.valueOf(this.getClass().getClassLoader().getResource("Images/WhiteKnight.jpg").toURI()));
            Logger.debug("Loading {} image.", white);
        } catch (URISyntaxException e) {
            Logger.error("Image not found.");
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        for (var i = 0; i < board.getRowCount(); i++) {
            for (var j = 0; j < board.getColumnCount(); j++) {
                var square = createSquare(i,j);
                board.add(square, j, i);
            }
        }
    }

    private StackPane createSquare(int i, int j) {
        var square = new StackPane();
        square.getStyleClass().add("square");

        ImageView blackKnightImage = new ImageView(black);

        blackKnightImage.visibleProperty().bind(
                new ObjectBinding<Boolean>() {
                    {
                        super.bind(model.squareProperty(i, j));
                    }
                    @Override
                    protected Boolean computeValue() {
                        return switch (model.squareProperty(i, j).get()) {
                            case EMPTY, WHITE_KNIGHT, VALID_CIRCLE -> false;
                            case BLACK_KNIGHT -> true;
                        };
                    }
                }
        );
        square.getChildren().add(blackKnightImage);

        ImageView whiteKnightImage = new ImageView(white);

        whiteKnightImage.visibleProperty().bind(
                new ObjectBinding<Boolean>() {
                    {
                        super.bind(model.squareProperty(i, j));
                    }
                    @Override
                    protected Boolean computeValue() {
                        return switch (model.squareProperty(i, j).get()) {
                            case EMPTY, BLACK_KNIGHT, VALID_CIRCLE -> false;
                            case WHITE_KNIGHT -> true;
                        };
                    }
                }
        );
        square.getChildren().add(whiteKnightImage);

        var piece = new Circle(40);
        piece.fillProperty().bind(Bindings.when(model.squareProperty(i, j).isEqualTo(Square.BLACK_KNIGHT))
                .then(javafx.scene.paint.Color.TRANSPARENT)
                .otherwise(Bindings.when(model.squareProperty(i, j).isEqualTo(Square.WHITE_KNIGHT))
                        .then(Color.TRANSPARENT)
                        .otherwise(Bindings.when(model.squareProperty(i, j).isEqualTo(Square.VALID_CIRCLE))
                                .then(Color.AQUAMARINE)
                                .otherwise(Color.TRANSPARENT)))
        );
        square.getChildren().add(piece);
        square.setOnMouseClicked(this::handleMouseClick);
        return square;
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
        var square = (StackPane) event.getSource();
        var row = GridPane.getRowIndex(square);
        var col = GridPane.getColumnIndex(square);
        Logger.debug("Clicked on square ({},{}).", row, col);

        if (model.getSquare(row, col) == Square.VALID_CIRCLE) {
            model.moveKnights(temporaryVariables.tempNewRow, temporaryVariables.tempNewCol, row, col);
            model.validCircleRemover();
            Logger.info("Number of moves made : {}.", model.numberOfMoves);
        } else if (model.getSquare(row, col) == Square.EMPTY){
            Logger.error("Click does not correspond to a valid knight move");
        }
        else if (model.getSquare(row, col) == Square.BLACK_KNIGHT || model.getSquare(row, col) == Square.WHITE_KNIGHT) {
            if (model.numberOfMoves % 2 == 0 && model.getSquare(row, col) == Square.WHITE_KNIGHT) {

                model.validCircleRemover();
                temporaryVariables.tempNewRow = row;
                temporaryVariables.tempNewCol = col;
                model.validMoves(row, col);

            } else if (model.numberOfMoves % 2 == 0 && model.getSquare(row, col) == Square.BLACK_KNIGHT) {
                Logger.error("Invalid turn for black Knight!");
                model.validCircleRemover();
            }
            else if (model.numberOfMoves % 2 != 0 && model.getSquare(row, col) == Square.BLACK_KNIGHT) {

                model.validCircleRemover();
                temporaryVariables.tempNewRow = row;
                temporaryVariables.tempNewCol = col;
                model.validMoves(row, col);

            } else if (model.numberOfMoves % 2 != 0 && model.getSquare(row, col) == Square.WHITE_KNIGHT) {
                Logger.error("Invalid turn for white Knight!");
                model.validCircleRemover();
            }
            else {
                Logger.warn("Invalid Move!");
            }

            model.goalStateReached();
            numberOfMovesField.setText("Moves Made: " + model.numberOfMoves);
        }
    }
}

package chess.com.udemy.chess;

import chess.com.udemy.boardgame.Board;
import chess.com.udemy.boardgame.Piece;

public class ChessPiece extends Piece {
    private Color color;

    public ChessPiece (Board board, Color color){
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

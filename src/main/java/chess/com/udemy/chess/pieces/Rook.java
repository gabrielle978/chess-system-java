package chess.com.udemy.chess.pieces;

import chess.com.udemy.boardgame.Board;
import chess.com.udemy.chess.ChessPiece;
import chess.com.udemy.chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        //matriz temporária
        boolean[][] matriz = new boolean[getBoard().getColumns()][getBoard().getRows()];
        return matriz;
    }
}

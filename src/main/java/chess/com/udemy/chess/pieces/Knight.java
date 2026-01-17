package chess.com.udemy.chess.pieces;

import chess.com.udemy.boardgame.Board;
import chess.com.udemy.boardgame.Position;
import chess.com.udemy.chess.ChessPiece;
import chess.com.udemy.chess.Color;

public class Knight extends ChessPiece {
    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "N" ;
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matriz = new boolean[getBoard().getColumns()][getBoard().getRows()];

        Position position1 = new Position(0,0);

        position1.setValues(position.getRow() -1, position.getColumn()-2);
        if (getBoard().positionExists(position1) && canMove(position1)){
            matriz[position1.getRow()][position1.getColumn()] = true;
        }

        position1.setValues(position.getRow() -2, position.getColumn()-1);
        if (getBoard().positionExists(position1) && canMove(position1)){
            matriz[position1.getRow()][position1.getColumn()] = true;
        }

        position1.setValues(position.getRow()-2, position.getColumn() +1);
        if (getBoard().positionExists(position1) && canMove(position1)){
            matriz[position1.getRow()][position1.getColumn()] = true;
        }

        position1.setValues(position.getRow()-1, position.getColumn() +2);
        if (getBoard().positionExists(position1) && canMove(position1)){
            matriz[position1.getRow()][position1.getColumn()] = true;
        }

        position1.setValues(position.getRow() +1, position.getColumn() +2);
        if (getBoard().positionExists(position1) && canMove(position1)){
            matriz[position1.getRow()][position1.getColumn()] = true;
        }

        position1.setValues(position.getRow() +2, position.getColumn() +1);
        if (getBoard().positionExists(position1) && canMove(position1)){
            matriz[position1.getRow()][position1.getColumn()] = true;
        }

        position1.setValues(position.getRow() +2, position.getColumn() -1);
        if (getBoard().positionExists(position1) && canMove(position1)){
            matriz[position1.getRow()][position1.getColumn()] = true;
        }

        position1.setValues(position.getRow() +1, position.getColumn() -2);
        if (getBoard().positionExists(position1) && canMove(position1)){
            matriz[position1.getRow()][position1.getColumn()] = true;
        }
        return matriz;
    }
}

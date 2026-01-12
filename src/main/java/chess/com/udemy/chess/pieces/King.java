package chess.com.udemy.chess.pieces;

import chess.com.udemy.boardgame.Board;
import chess.com.udemy.boardgame.Position;
import chess.com.udemy.chess.ChessPiece;
import chess.com.udemy.chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        //matriz temporária
        boolean[][] matriz = new boolean[getBoard().getColumns()][getBoard().getRows()];

        Position position1 = new Position(0,0);

        //above
        position1.setValues(position.getRow() -1, position.getColumn());
        if (getBoard().positionExists(position1) && canMove(position1)){
            matriz[position1.getRow()][position1.getColumn()] = true;
        }

        //below
        position1.setValues(position.getRow() +1, position.getColumn());
        if (getBoard().positionExists(position1) && canMove(position1)){
            matriz[position1.getRow()][position1.getColumn()] = true;
        }

        //left
        position1.setValues(position.getRow(), position.getColumn() -1);
        if (getBoard().positionExists(position1) && canMove(position1)){
            matriz[position1.getRow()][position1.getColumn()] = true;
        }

        //right
        position1.setValues(position.getRow(), position.getColumn() +1);
        if (getBoard().positionExists(position1) && canMove(position1)){
            matriz[position1.getRow()][position1.getColumn()] = true;
        }

        //northwest (noroeste)
        position1.setValues(position.getRow() -1, position.getColumn() -1);
        if (getBoard().positionExists(position1) && canMove(position1)){
            matriz[position1.getRow()][position1.getColumn()] = true;
        }

        //northeast (nordeste)
        position1.setValues(position.getRow() -1, position.getColumn() +1);
        if (getBoard().positionExists(position1) && canMove(position1)){
            matriz[position1.getRow()][position1.getColumn()] = true;
        }

        //southewest(sudoeste)
        position1.setValues(position.getRow() +1, position.getColumn() -1);
        if (getBoard().positionExists(position1) && canMove(position1)){
            matriz[position1.getRow()][position1.getColumn()] = true;
        }

        //southeast (sudeste)
        position1.setValues(position.getRow() +1, position.getColumn() +1);
        if (getBoard().positionExists(position1) && canMove(position1)){
            matriz[position1.getRow()][position1.getColumn()] = true;
        }





        return matriz;
    }
}

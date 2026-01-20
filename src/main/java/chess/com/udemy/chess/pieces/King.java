package chess.com.udemy.chess.pieces;

import chess.com.udemy.boardgame.Board;
import chess.com.udemy.boardgame.Position;
import chess.com.udemy.chess.ChessMatch;
import chess.com.udemy.chess.ChessPiece;
import chess.com.udemy.chess.Color;

public class King extends ChessPiece {
    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString(){
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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

        //#SpecialMoveCastling
        if (getMoveCount() == 0 && !chessMatch.getCheck()){
            //SpecialMoveCastling -> Kingside Rook
            Position positionRook1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(positionRook1)){
                Position positionRightToKingP1 = new Position(position.getRow(), position.getColumn() + 1);
                Position positionRightToKingP2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(positionRightToKingP1) == null && getBoard().piece(positionRightToKingP2)== null){
                    matriz[position.getRow()][position.getColumn() + 2] = true;
                }

            }
            //SpecialMoveCastling -> Queenside Rook
            Position positionRook2 = new Position(position.getRow(), position.getColumn() -4);
            if (testRookCastling(positionRook2)){
                Position positionRightToKingP1 = new Position(position.getRow(), position.getColumn() - 1);
                Position positionRightToKingP2 = new Position(position.getRow(), position.getColumn() - 2);
                Position positionRightToKingP3 = new Position(position.getRow(), position.getColumn() - 3);

                if (getBoard().piece(positionRightToKingP1) == null && getBoard().piece(positionRightToKingP2)== null && getBoard().piece(positionRightToKingP3)==null){
                    matriz[position.getRow()][position.getColumn() - 2] = true;
                }

            }
        }



        return matriz;
    }
}

package chess.com.udemy.chess.pieces;

import chess.com.udemy.boardgame.Board;
import chess.com.udemy.boardgame.Position;
import chess.com.udemy.chess.ChessPiece;
import chess.com.udemy.chess.Color;

public class Queen extends ChessPiece {
    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position pos = new Position(0,0);

        //above the piece
        pos.setValues(position.getRow() -1, position.getColumn());
        while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)){
            matriz[pos.getRow()][pos.getColumn()] = true; //marcou como verdadeiro a posição da matriz
            pos.setRow(pos.getRow()-1);
        }

        if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)){
            matriz[pos.getRow()][pos.getColumn()] = true;
        }

        //left to the piece
        pos.setValues(position.getRow(), position.getColumn()-1);
        while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)){
            matriz[pos.getRow()][pos.getColumn()] = true; //marcou como verdadeiro a posição da matriz
            pos.setColumn(pos.getColumn() -1);
        }

        if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)){
            matriz[pos.getRow()][pos.getColumn()] = true;
        }

        //right to the piece
        pos.setValues(position.getRow(), position.getColumn() +1);
        while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)){
            matriz[pos.getRow()][pos.getColumn()] = true; //marcou como verdadeiro a posição da matriz
            pos.setColumn(pos.getColumn() +1);
        }

        if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)){
            matriz[pos.getRow()][pos.getColumn()] = true;
        }

        //below to the piece
        pos.setValues(position.getRow() +1, position.getColumn());
        while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)){
            matriz[pos.getRow()][pos.getColumn()] = true; //marcou como verdadeiro a posição da matriz
            pos.setRow(pos.getRow()+1);
        }

        if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)){
            matriz[pos.getRow()][pos.getColumn()] = true;
        }
        //northwest -- noroeste
        pos.setValues(position.getRow() - 1, position.getColumn() - 1);
        while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
            matriz[pos.getRow()][pos.getColumn()] = true; //marcou como verdadeiro a posição da matriz
            pos.setValues(pos.getRow() - 1, pos.getColumn() - 1);
        }
        if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
            matriz[pos.getRow()][pos.getColumn()] = true;
        }

        //notheast -- nordeste
        pos.setValues(position.getRow() - 1, position.getColumn() + 1);
        while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
            matriz[pos.getRow()][pos.getColumn()] = true; //marcou como verdadeiro a posição da matriz
            pos.setValues(pos.getRow() - 1, pos.getColumn() + 1);
        }
        if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
            matriz[pos.getRow()][pos.getColumn()] = true;
        }

        //southeast -- sudeste
        pos.setValues(position.getRow() + 1, position.getColumn() + 1);
        while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
            matriz[pos.getRow()][pos.getColumn()] = true; //marcou como verdadeiro a posição da matriz
            pos.setValues(pos.getRow() + 1, pos.getColumn() + 1);
        }

        if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
            matriz[pos.getRow()][pos.getColumn()] = true;
        }

        //southwest -- sudoeste
        pos.setValues(position.getRow() + 1, position.getColumn() - 1);
        while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
            matriz[pos.getRow()][pos.getColumn()] = true; //marcou como verdadeiro a posição da matriz
            pos.setValues(pos.getRow() + 1, pos.getColumn() - 1);
        }

        if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
            matriz[pos.getRow()][pos.getColumn()] = true;
        }

        return matriz;
    }
}

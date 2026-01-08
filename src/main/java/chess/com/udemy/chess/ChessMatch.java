package chess.com.udemy.chess;

import chess.com.udemy.boardgame.Board;
import chess.com.udemy.boardgame.Piece;
import chess.com.udemy.boardgame.Position;
import chess.com.udemy.chess.pieces.King;
import chess.com.udemy.chess.pieces.Rook;

public class ChessMatch {
    private Board board;
    public int turn;

    public ChessMatch(){
        board = new Board(8,8);
        initialSetup();
    }

    public ChessPiece[][] getPieces(){
        ChessPiece [][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i< board.getRows(); i++){
            for (int j=0; j< board.getColumns(); j++){
                mat[i][j] = (ChessPiece) board.piece(i,j);
            }
        }
        return mat;
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p,target);

        return capturedPiece;
    }

    private void validateSourcePosition(Position position){
        if(!board.thereIsAPiece(position)){
            throw new ChessException("There is not a piece on source position");
        }
    }

    private void placeNewPiece(int row, char column, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(row, column).toPosition());
    }

    private void initialSetup(){
        placeNewPiece(8, 'c', new Rook(board, Color.WHITE));
        placeNewPiece(5, 'a', new King(board, Color.WHITE));
        placeNewPiece(2, 'b', new Rook(board, Color.WHITE));

        placeNewPiece(7, 'f', new Rook(board, Color.BLACK));
        placeNewPiece(4, 'e', new King(board, Color.BLACK));
        placeNewPiece(3, 'd', new Rook(board, Color.BLACK));

    }

}

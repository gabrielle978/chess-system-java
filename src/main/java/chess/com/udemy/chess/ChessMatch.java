package chess.com.udemy.chess;

import chess.com.udemy.boardgame.Board;
import chess.com.udemy.boardgame.Piece;
import chess.com.udemy.boardgame.Position;
import chess.com.udemy.chess.pieces.King;
import chess.com.udemy.chess.pieces.Rook;

import java.util.ArrayList;
import java.util.List;

public class ChessMatch {
    private Board board;
    private int turn;
    private Color currentPlayer;
    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();

    public ChessMatch(){
        board = new Board(8,8);
        initialSetup();
        turn = 1;
        currentPlayer = Color.WHITE;
    }

    public int getTurn(){
        return turn;
    }

    public Color getCurrentPlayer(){
        return currentPlayer;
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

    //Operação p/ imprimir as posições possíveis a partir de uma posição de Origem.
    public boolean [][] possibleMoves(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        nextTurn();
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p,target);

        if(capturedPiece != null){
            piecesOnTheBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }

        return capturedPiece;
    }

    private void validateSourcePosition(Position position){
        if(!board.thereIsAPiece(position)){
            throw new ChessException("There is not a piece on source position");
        }
        if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()){
            throw new ChessException("The chosen piece is not yours");
        }
        if(!board.piece(position).isThereAnyPossibleMove()){
            throw new ChessException("There is no possible moves for the chosen piece") ;
        }
    }

    private void validateTargetPosition(Position source, Position target){
        //SE para a peça de ORIGEM não é a posição de DESTINO...
        //não é possível mexer para lá.
        if (!board.piece(source).possibleMove(target)){
            throw new ChessException("The chosen piece cannot move to target position");
        }
    }

    private void nextTurn(){
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private void placeNewPiece(int row, char column, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(row, column).toPosition());
        piecesOnTheBoard.add(piece);
    }

    private void initialSetup(){
        placeNewPiece(1, 'e', new Rook(board, Color.WHITE));
        placeNewPiece(1, 'd', new King(board, Color.WHITE));
        placeNewPiece(1, 'c', new Rook(board, Color.WHITE));
        placeNewPiece(2, 'e', new Rook(board, Color.WHITE));
        placeNewPiece(2, 'd', new Rook(board, Color.WHITE));
        placeNewPiece(2, 'c', new Rook(board, Color.WHITE));

        placeNewPiece(8, 'e', new Rook(board, Color.BLACK));
        placeNewPiece(8, 'd', new King(board, Color.BLACK));
        placeNewPiece(8, 'c', new Rook(board, Color.BLACK));
        placeNewPiece(7, 'e', new Rook(board, Color.BLACK));
        placeNewPiece(7, 'd', new Rook(board, Color.BLACK));
        placeNewPiece(7, 'c', new Rook(board, Color.BLACK));

    }

}

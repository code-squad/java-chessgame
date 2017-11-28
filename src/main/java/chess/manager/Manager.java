package chess.manager;

import java.util.List;

import chess.board.Board;
import chess.board.Position;
import chess.board.Rank;
import chess.piece.Blank;
import chess.piece.Piece;

public class Manager {

	public Piece findPiece(Board board, Position position) {
		List<Rank> ranks = board.getRanks();
		return ranks.get(position.getYPosition()).getPieces().get(position.getXPosition());
	}

	public void addPiece(Board board, Position position, Piece piece) {
		List<Rank> ranks = board.getRanks();
		ranks.get(position.getYPosition()).getPieces().set(position.getXPosition(), piece);
	}

	public void makeEmpty(Board board, Position position) {
		List<Rank> ranks = board.getRanks();
		ranks.get(position.getYPosition()).getPieces().set(position.getXPosition(), Blank.create());
	}
}

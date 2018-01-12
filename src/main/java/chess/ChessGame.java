package chess;

import java.util.List;

import pieces.Blank;
import pieces.Piece;
import pieces.Position;

public class ChessGame {
	private List<Rank> ranks;
	
	ChessGame(Board board) {
		this.ranks = board.getRanks();
	}
	
	public Piece findPiece(String str) {
		Position position = new Position(str);
		Rank rank = ranks.get(position.getY());
		Piece piece = rank.getPieces().get(position.getX());
		return piece;
	}

	public void move(String position, Piece piece) {
		move(new Position(position), piece);
	}

	public void move(Position position, Piece piece) {
		ranks.get(position.getY()).setPiece(position, piece);
	}
	
	public void move(String sourcePosition, String targetPosition) {
		Piece source = findPiece(sourcePosition);
		Piece target = findPiece(targetPosition);
		Piece blank = Blank.createBlank(new Position(targetPosition));
		source.checkTargetPosition(target);
		source.setPosition(new Position(targetPosition));
		target.setPosition(new Position(sourcePosition));
		if (source.getColor() != target.getColor()) {
			move(targetPosition, source);
			move(sourcePosition, blank);
			return;
		}
		move(targetPosition, source);
		move(sourcePosition, target);
	}
}

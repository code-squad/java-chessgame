package chess.board;

import java.util.ArrayList;
import java.util.List;

import chess.exception.FreezeException;
import chess.manager.Manager;
import chess.piece.Piece;
import chess.piece.Piece.Type;
import chess.view.ChessResultView;

public class Board {

	private List<Rank> ranks;

	public Board() {
		ranks = new ArrayList<>();
	}

	public void create() {
		ranks.add(Rank.createSpecialWhitePiece());
		ranks.add(Rank.createWhitePawn());
		ranks.add(Rank.createBlank());
		ranks.add(Rank.createBlank());
		ranks.add(Rank.createBlank());
		ranks.add(Rank.createBlank());
		ranks.add(Rank.createBlackPawn());
		ranks.add(Rank.createSpecialBlackPiece());

	}

	public void emptyBoard() {
		ranks.add(Rank.createBlank());
		ranks.add(Rank.createBlank());
		ranks.add(Rank.createBlank());
		ranks.add(Rank.createBlank());
		ranks.add(Rank.createBlank());
		ranks.add(Rank.createBlank());
		ranks.add(Rank.createBlank());
		ranks.add(Rank.createBlank());
	}

	public List<Rank> getRanks() {
		return ranks;
	}

	public void move(Position sourcePosition, Position targetPosition) {
		Manager manager = new Manager();
		Piece piece = manager.findPiece(this, sourcePosition);
		Piece target = manager.findPiece(this, targetPosition);
		if (piece.getColor() == target.getColor()) {
			throw new FreezeException("아군의 위치로 움직일 수 없습니다.");
		}
		manager.addPiece(this, targetPosition, piece.move(targetPosition));
		manager.makeEmpty(this, sourcePosition);
	}

	public void moveTest(Position sourcePosition, Position targetPosition) {
		Manager manager = new Manager();
		Piece piece = manager.findPiece(this, sourcePosition);
		piece = piece.move(targetPosition);
		if ((!piece.isMove(targetPosition)) || piece.getType() == Type.BLANK) {
			throw new FreezeException("움직일수 없습니다");
		}
		manager.addPiece(this, targetPosition, piece);
		manager.makeEmpty(this, sourcePosition);
	}

	public ChessResultView result() {
		return new ChessResultView(this);
	}

}

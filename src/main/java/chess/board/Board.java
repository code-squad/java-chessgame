package chess.board;

import java.util.ArrayList;
import java.util.List;

import chess.exception.FreezeException;
import chess.manager.Manager;
import chess.piece.Piece;

public class Board {

	// private static final Logger log = LoggerFactory.getLogger(Board.class);

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

	public String show() {
		StringBuilder sb = new StringBuilder();
		for (int i = ranks.size() - 1; i >= 0; i--) {
			List<Piece> pieces = ranks.get(i).getPieces();
			for (int j = 0; j < 8; j++) {
				sb.append(pieces.get(j).toString());
			}
			sb.append("\n");
		}
		return sb.toString();
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
		manager.addPiece(this, targetPosition, piece);
		manager.makeEmpty(this, sourcePosition);
	}

	public void moveTest(Position sourcePosition, Position targetPosition) {
		Manager manager = new Manager();
		Piece piece = manager.findPiece(this, sourcePosition);
		if (!piece.isMove(targetPosition)) {
			throw new FreezeException("움직일수 없습니다");
		}
		manager.addPiece(this, targetPosition, piece);
		manager.makeEmpty(this, sourcePosition);
	}

}

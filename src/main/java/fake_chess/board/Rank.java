package fake_chess.board;

import java.util.ArrayList;
import java.util.List;

import fake_chess.piece.Piece;
import fake_chess.piece.Piece.Color;
import fake_chess.piece.Piece.Type;

public class Rank {
	static final int RANK_LINE = 8;
	private List<Piece> pieces = new ArrayList<>();

	private Rank() {

	}

	public Rank(Piece piece) {
		for (int i = 0; i < RANK_LINE; i++) {
			pieces.add(piece);
		}
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	public Rank(Piece rook1, Piece knight1, Piece bishop1, Piece queen, Piece king, Piece bishop2, Piece knight2,
			Piece rook2) {
		pieces.add(rook1);
		pieces.add(knight1);
		pieces.add(bishop1);
		pieces.add(queen);
		pieces.add(king);
		pieces.add(bishop2);
		pieces.add(knight2);
		pieces.add(rook2);
	}

	public int size() {
		return pieces.size();
	}

	public static Rank createRank() {
		return new Rank();
	}

	public static Rank createPawnRank(Piece piece) {
		return new Rank(piece);
	}

	public String print() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = pieces.size() - 1; i >= 0; i--) {
			stringBuilder.append(pieces.get(i).getRepresentation());
		}
		return stringBuilder.toString();
	}

	public static Rank createSpetialRank(Piece rook1, Piece knight1, Piece bishop1, Piece queen, Piece king,
			Piece bishop2, Piece knight2, Piece rook2) {
		return new Rank(rook1, knight1, bishop1, queen, king, bishop2, knight2, rook2);
	}

	public int checkRank(Type type, Color color) {
		int count = 0;
		for (Piece index : pieces) {
			count += index.checkPiece(type, color);
		}
		return count;
	}

	public Double checkRank(Color color) {
		Double score = 0.0;
		for (Piece index : pieces) {
			score += index.checkPiece(color);
		}
		return score;
	}

	public Piece findPiece(int index) {
		return pieces.get(index);
	}

	public Piece removePiece(int index) {
		return pieces.set(index, Piece.createBlank(Type.BLANK));
	}

	public static Rank createBlankRank(Piece piece, int number) {
		return null;
	}

	public static Rank createBlankRank(Piece piece) {
		return new Rank(piece);
	}

	public void setPiece(int index, Type type, Color color) {
		if (color == Color.BLACK) {
			pieces.set(index, Piece.createBlack(type));
		} else {
			pieces.set(index, Piece.createWhite(type));
		}
	}

	public static Rank setPiece(int index, Piece piece, Rank rank) {
		rank.pieces.set(index, piece);
		return rank;
	}

}

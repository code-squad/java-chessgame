package chess.board;

import java.util.ArrayList;
import java.util.List;

import chess.piece.Piece;
import chess.piece.Piece.Color;
import chess.piece.Piece.Type;

public class Rank {

	private List<Piece> pieces;

	private Rank(Type type) {
		pieces = new ArrayList<>();
		addBlank(type);
	}

	private void addBlank(Type type) {
		for (int i = 0; i < 8; i++) {
			pieces.add(Piece.createBlank());
		}
	}

	private Rank(Type type, Color color) {
		pieces = new ArrayList<>();
		if (Color.BLACK == color) {
			addBlackPawn(type);
			return;
		}
		addWhitePawn(type);
	}

	private Rank(Color color) {
		pieces = new ArrayList<>();
		if (color == Color.BLACK) {
			addSpecialBlackPiece();
			return;
		}
		addSpecialWhitePiece();
	}

	private void addSpecialBlackPiece() {
		pieces.add(Piece.createBlackRook(0));
		pieces.add(Piece.createBlackKnight(0));
		pieces.add(Piece.createBlackBishop(0));
		pieces.add(Piece.createBlackQueen());
		pieces.add(Piece.createBlackKing());
		pieces.add(Piece.createBlackBishop(1));
		pieces.add(Piece.createBlackKnight(1));
		pieces.add(Piece.createBlackRook(1));
	}

	private void addSpecialWhitePiece() {
		pieces.add(Piece.createWhiteRook(0));
		pieces.add(Piece.createWhiteKnight(0));
		pieces.add(Piece.createWhiteBishop(0));
		pieces.add(Piece.createWhiteQueen());
		pieces.add(Piece.createWhiteKing());
		pieces.add(Piece.createWhiteBishop(1));
		pieces.add(Piece.createWhiteKnight(1));
		pieces.add(Piece.createWhiteRook(1));
	}

	private void addWhitePawn(Type type) {
		for (int i = 0; i < 8; i++) {
			pieces.add(Piece.createWhitePawn(i));
		}
	}

	private void addBlackPawn(Type type) {
		for (int i = 0; i < 8; i++) {
			pieces.add(Piece.createBlackPawn(i));
		}
	}

	public static Rank createBlank() {
		return new Rank(Type.BLANK);
	}

	public static Rank createSpecialWhitePiece() {
		return new Rank(Color.WHITE);
	}

	public static Rank createWhitePawn() {
		return new Rank(Type.PAWN, Color.WHITE);
	}

	public static Rank createBlackPawn() {
		return new Rank(Type.PAWN, Color.BLACK);
	}

	public static Rank createSpecialBlackPiece() {
		return new Rank(Color.BLACK);
	}

	public List<Piece> getPieces() {
		return pieces;
	}

}

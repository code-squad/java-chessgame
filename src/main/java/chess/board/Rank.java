package chess.board;

import java.util.ArrayList;
import java.util.List;

import chess.piece.Bishop;
import chess.piece.Blank;
import chess.piece.King;
import chess.piece.Knight;
import chess.piece.Pawn;
import chess.piece.Piece;
import chess.piece.Piece.Color;
import chess.piece.Piece.Type;
import chess.piece.Queen;
import chess.piece.Rook;

public class Rank {

	private List<Piece> pieces;

	private Rank() {
		pieces = new ArrayList<>();
		addBlank();
	}

	private void addBlank() {
		for (int i = 0; i < 8; i++) {
			pieces.add(Blank.create());
		}
	}

	private Rank(Type pawn, Color color) {
		pieces = new ArrayList<>();
		if (Color.BLACK == color) {
			addBlackPawn();
			return;
		}
		addWhitePawn();
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
		pieces.add(Rook.createBlackRook(0));
		pieces.add(Knight.createBlackKnight(0));
		pieces.add(Bishop.createBlackBishop(0));
		pieces.add(Queen.create(Color.BLACK, Position.setup(3, 7)));
		pieces.add(King.create(Color.BLACK, Position.setup(4, 7)));
		pieces.add(Rook.createBlackRook(1));
		pieces.add(Knight.createBlackKnight(1));
		pieces.add(Bishop.createBlackBishop(1));
	}

	private void addSpecialWhitePiece() {
		pieces.add(Rook.createWhiteRook(0));
		pieces.add(Knight.createWhiteKnight(0));
		pieces.add(Bishop.createWhiteBishop(0));
		pieces.add(Queen.create(Color.WHITE, Position.setup(3, 0)));
		pieces.add(King.create(Color.WHITE, Position.setup(4, 0)));
		pieces.add(Bishop.createWhiteBishop(1));
		pieces.add(Knight.createWhiteKnight(1));
		pieces.add(Rook.createWhiteRook(1));
	}

	private void addWhitePawn() {
		for (int i = 0; i < 8; i++) {
			pieces.add(Pawn.createWhitePawn(Position.setup(i, 1)));
		}
	}

	private void addBlackPawn() {
		for (int i = 0; i < 8; i++) {
			pieces.add(Pawn.createBlackPawn(Position.setup(i, 6)));
		}
	}

	public static Rank createBlank() {
		return new Rank();
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

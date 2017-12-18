package pieces;

import chess.Color;
import chess.Name;

public class Piece {
	private final Color color;
	private final Name name;

	private Piece(Color color, Name name) {
		this.color = color;
		this.name = name;
	}

	public static Piece createWhitePawn() {
		return new Piece(Color.WHITE, Name.PAWN);
	}
	
	public static Piece createBlackPawn() {
		return new Piece(Color.BLACK, Name.PAWN);
	}
	
	public static Piece createWhiteKnight() {
		return new Piece(Color.WHITE, Name.KNIGHT);
	}
	
	public static Piece createBlackKnight() {
		return new Piece(Color.BLACK, Name.KNIGHT);
	}
	
	public static Piece createWhiteRook() {
		return new Piece(Color.WHITE, Name.ROOK);
	}
	
	public static Piece createBlackRook() {
		return new Piece(Color.BLACK, Name.ROOK);
	}
	
	public static Piece createWhiteBishop() {
		return new Piece(Color.WHITE, Name.BISHOP);
	}
	
	public static Piece createBlackBishop() {
		return new Piece(Color.BLACK, Name.BISHOP);
	}
	
	public static Piece createWhiteQueen() {
		return new Piece(Color.WHITE, Name.QUEEN);
	}
	
	public static Piece createBlackQueen() {
		return new Piece(Color.BLACK, Name.QUEEN);
	}
	
	public static Piece createWhiteKing() {
		return new Piece(Color.WHITE, Name.KING);
	}
	
	public static Piece createBlackKing() {
		return new Piece(Color.BLACK, Name.KING);
	}
	
	public Color getColor() {
		return color;
	}
	
	public char getRepresentation() {
		if(color == Color.WHITE) {
			return name.getWhiteRepresentation();
		}
		return name.getBlackRepresentation();
	}

	public boolean isWhite() {
		return color == Color.WHITE;
	}

	public boolean isBlack() {
		return color == Color.BLACK;
	}
}

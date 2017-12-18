package pieces;

import pieces.Piece.Color;
import pieces.Piece.Type;

public class Piece {
	public enum Color {
		WHITE, BLACK, NOCOLOR;
	}
	
	public enum Type {
		PAWN('P'), KNIGHT('N'), ROOK('R'), BISHOP('B'), QUEEN('Q'), KING('K'), NO_PIECE('.');
		
		private char representation;
		
		private Type(char representation) {
			this.representation = representation;
		}
		
		public char getWhiteRepresentation() {
			return Character.toLowerCase(representation);
		}
		
		public char getBlackRepresentation() {
			return representation;
		}
	}	
	private final Color color;
	private final Type type;

	private Piece(Color color, Type type) {
		this.color = color;
		this.type = type;
	}
	
	private static Piece createWhite(Type type) {
		return new Piece(Color.WHITE, type);
	}
	
	private static Piece createBlack(Type type) {
		return new Piece(Color.BLACK, type);
	}
	
	public static Piece createBlank() {
		return new Piece(Color.NOCOLOR, Type.NO_PIECE);
	}
	//이 메소드들 자체는 중복이 아니고, new Piece(color, type)이 중복. createWhite/Black()을 써서 중복을 없앨 수 있다.
	public static Piece createWhitePawn() {
		return createWhite(Type.PAWN);
	}
	
	public static Piece createBlackPawn() {
		return createBlack(Type.PAWN);
	}
	
	public static Piece createWhiteKnight() {
		return createWhite(Type.KNIGHT);
	}
	
	public static Piece createBlackKnight() {
		return createBlack(Type.KNIGHT);
	}
	
	public static Piece createWhiteRook() {
		return createWhite(Type.ROOK);
	}
	
	public static Piece createBlackRook() {
		return createBlack(Type.ROOK);
	}
	
	public static Piece createWhiteBishop() {
		return createWhite(Type.BISHOP);
	}
	
	public static Piece createBlackBishop() {
		return createBlack(Type.BISHOP);
	}
	
	public static Piece createWhiteQueen() {
		return createWhite(Type.QUEEN);
	}
	
	public static Piece createBlackQueen() {
		return createBlack(Type.QUEEN);
	}
	
	public static Piece createWhiteKing() {
		return createWhite(Type.KING);
	}
	
	public static Piece createBlackKing() {
		return createBlack(Type.KING);
	}

	public Color getColor() {
		return color;
	}
	
	public char getRepresentation() {
		if(color == Color.WHITE) {
			return type.getWhiteRepresentation();
		}
		return type.getBlackRepresentation();
	}

	public boolean isWhite() {
		return color == Color.WHITE;
	}

	public boolean isBlack() {
		return color == Color.BLACK;
	}

	public Type getType() {
		return type;
	}

	public boolean isSame(Color color, Type type) {
		return this.equals(new Piece(color, type));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (color != other.color)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Piece [color=" + color + ", type=" + type + "]";
	}
}

package pieces;

public class Piece implements Comparable<Piece> {
	public enum Color {
		WHITE, BLACK, NOCOLOR;
	}
	
	public enum Type {
		PAWN('P', 1.0),
		KNIGHT('N', 2.5), 
		ROOK('R', 5.0), 
		BISHOP('B', 3.0), 
		QUEEN('Q', 9.0), 
		KING('K', 0.0), 
		NO_PIECE('.', 0.0);
		
		private char representation;
		private double score;

		private Type(char representation, double score) {
			this.representation = representation;
			this.score = score;
		}
		
		public char getWhiteRepresentation() {
			return Character.toLowerCase(representation);
		}
		
		public char getBlackRepresentation() {
			return representation;
		}
		
		public double getScore() {
			return score;
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
	//non_color 상황도 고려하도록 바꿔야 하나? -일단 black으로 가져오면 제대로 가져옴
	public char getRepresentation() {
		if(isWhite()) {
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
	
	public double getScore() {
		return type.getScore();
	}

	public boolean isSame(Color color, Type type) {
		return this.equals(new Piece(color, type));
	}

	public boolean isSameColor(Color color) {
		return this.color == color;
	}
	
	public double calculatePoint(Color color) {
		if(isSameColor(color)) {
			return getScore();
		}
		return 0.0;
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
		return Character.toString(getRepresentation());
	}

	@Override
	public int compareTo(Piece p) {
//		int compare = Double.compare(getScore(), p.getScore()); //반대로 나옴
		int compare = Double.compare(p.getScore(), getScore());
		return compare;
	}
}
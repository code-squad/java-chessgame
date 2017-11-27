package fake_chess.piece;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fake_chess.management.Position;

public class Piece {

	private static final Logger log = LoggerFactory.getLogger(Piece.class);

	private Type type;
	private Color color;
	private String representation;
	private Double score;
	private Position position;

	public enum Color {
		WHITE, BLACK, BLANK;
	}

	public enum Type {
		PAWN("P", 1.0), ROOK("R", 5.0), KNIGHT("N", 2.5), BISHOP("B", 3.0), QUEEN("Q", 9.0), KING("K", 0.0), BLANK(".",
				0.0);

		private String representation;
		private Double score;

		private Type(String representation) {
			this.representation = representation;
		}

		private Type(String representation, Double score) {
			this.representation = representation;
			this.score = score;
		}

		public String getBlankRepresentation() {
			return representation;
		}

		public String getRepresentation(Color color) {
			if (isBlack(color)) {
				return representation;
			}
			return representation.toLowerCase();
		}

		public Double getScore() {
			return score;
		}
	}

	public enum Score {
		PAWN(1.0), ROOK(5.0), KINIGHT(2.5), BISHOP(3.0), QUEEN(9.0), KING(0.0);

		private Double score;

		private Score(Double score) {
			this.score = score;
		}

		public Double getScore() {
			return score;
		}
	}

	private Piece(Color color) {
		this.color = color;
	}

	private Piece(Color color, String representation) {
		this.color = color;
		this.representation = representation;
	}

	private Piece(Type type, Color color, String representation) {
		this.type = type;
		this.color = color;
		this.representation = representation;
		this.score = type.getScore();
	}

	public static Piece createPiece(Color color) {
		return new Piece(color);
	}

	public static Piece createPiece(Color color, String representation) {
		return new Piece(color, representation);
	}

	public static Piece createPiece(Type type, Color color, String representation) {
		return new Piece(type, color, representation);
	}

	public static boolean isWhite(Color color) {
		return color == Color.WHITE ? true : false;
	}

	public static boolean isBlack(Color color) {
		return color == Color.BLACK ? true : false;
	}

	public static Color colorCheck(Color color) {
		if (color == Color.WHITE) {
			return Color.WHITE;
		}
		return Color.BLACK;
	}

	public Color getColor() {
		return color;
	}

	public Double getScore() {
		return score;
	}

	public String getRepresentation() {
		return representation;
	}

	public static Piece createWhite(Type type) {
		return new Piece(type, Color.WHITE, type.getRepresentation(Color.WHITE));
	}

	public static Piece createBlack(Type type) {
		return new Piece(type, Color.BLACK, type.getRepresentation(Color.BLACK));
	}

	public static Piece createBlank(Type type) {
		return new Piece(type, Color.BLANK, type.getBlankRepresentation());
	}

	public boolean isWhite() {
		return this.getColor() == Color.WHITE ? true : false;
	}

	public boolean isBlack() {
		return this.getColor() == Color.BLACK ? true : false;
	}

	public Type getType() {
		return type;
	}

	public int checkPiece(Type type, Color color) {
		if ((this.type == type) && (this.color == color)) {
			return 1;
		}
		return 0;
	}

	public Double checkPiece(Color color) {
		if ((this.color == color)) {
			return score;
		}
		return 0.0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((representation == null) ? 0 : representation.hashCode());
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
		if (representation == null) {
			if (other.representation != null)
				return false;
		} else if (!representation.equals(other.representation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Piece [type=" + type + ", color=" + color + ", representation=" + representation + "]";
	}

	public static Piece createBlackPawn() {
		return new Piece(Type.PAWN, Color.BLACK, Type.PAWN.getRepresentation(Color.BLACK));
	}

	public static Piece createBlackQueen() {
		return new Piece(Type.QUEEN, Color.BLACK, Type.QUEEN.getRepresentation(Color.BLACK));
	}

	public static Piece createBlackKing() {
		return new Piece(Type.KING, Color.BLACK, Type.QUEEN.getRepresentation(Color.BLACK));
	}

	public static Piece createBlackRook() {
		return new Piece(Type.ROOK, Color.BLACK, Type.ROOK.getRepresentation(Color.BLACK));
	}

	public static Piece createWhitePawn() {
		return new Piece(Type.PAWN, Color.WHITE, Type.PAWN.getRepresentation(Color.WHITE));
	}

	public static Piece createWhiteRook() {
		return new Piece(Type.ROOK, Color.WHITE, Type.ROOK.getRepresentation(Color.WHITE));
	}

	public static Piece createWhiteKing() {
		return new Piece(Type.KING, Color.WHITE, Type.KING.getRepresentation(Color.WHITE));
	}

	public void setPosition(String position) {
		this.position = Position.create(position);
	}

	public int getXPosition() {
		log.debug("현재 piece의 x 값 : {}", position.getX());
		log.debug("현재 piece의 x 값 : {}", position.getY());
		return position.getX();
	}
}

package chess.piece;

public class Pawn {

	private final static String BLACK = "black";
	private final static String WHITE = "white";

	private String color;
	private int x;
	private int y;
	private String expression;

	public Pawn(String color) {
		this.color = color;
		if (color.equals(BLACK)) {
			expression = "P";
		} else {
			expression = "p";
		}
		x = 0;
		y = 0;
	}

	public Pawn(String color, String position) {
		this.color = color;
		expression = "P";
		String targetPosition = position.split(" ")[1];
		x = targetPosition.charAt(0) - 'a';
		y = Character.getNumericValue(targetPosition.charAt(1));
	}

	public Pawn() {
		expression = ".";
	}

	public static Pawn createBlackPawn() {
		return new Pawn(BLACK);
	}

	public static Pawn createWhitePawn() {
		return new Pawn(WHITE);
	}

	public Pawn move(String position) {
		String targetPosition = position.split(" ")[1];
		x = targetPosition.charAt(0) - 'a';
		y = Character.getNumericValue(targetPosition.charAt(1));
		return this;
	}

	public String getPiece() {
		return expression;
	}

	public static Pawn createBlackPawn(String position) {
		return new Pawn(BLACK, position);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + x;
		result = prime * result + y;
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
		Pawn other = (Pawn) obj;
		if (color == null) {
			return other.color == null;
		} else if (!color.equals(other.color))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}

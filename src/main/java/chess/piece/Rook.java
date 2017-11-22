package chess.piece;

public class Rook {
	private final static String BLACK = "black";

	private String color;
	private String expression;

	private Rook(String color) {
		this.color = color;
		if (color.equals(BLACK)) {
			expression = "R";
		} else {
			expression = "r";
		}
	}

	public static Rook create(String color) {
		return new Rook(color);
	}

	public String getExpression() {
		return expression;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((expression == null) ? 0 : expression.hashCode());
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
		Rook other = (Rook) obj;
		if (color == null) {
			return other.color == null;
		} else if (!color.equals(other.color))
			return false;
		if (expression == null) {
			return other.expression == null;
		} else if (!expression.equals(other.expression))
			return false;
		return true;
	}
}

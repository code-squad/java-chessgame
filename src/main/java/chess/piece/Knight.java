package chess.piece;

public class Knight {

	private static final Object BLACK = "black";
	private String color;
	private String expression;

	public Knight(String color) {
		this.color = color;
		if (color.equals(BLACK)) {
			expression = "K";
		} else {
			expression = "k";
		}
	}

	public static Knight create(String color) {
		return new Knight(color);
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
		Knight other = (Knight) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (expression == null) {
			if (other.expression != null)
				return false;
		} else if (!expression.equals(other.expression))
			return false;
		return true;
	}
}

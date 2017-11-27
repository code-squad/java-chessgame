package fake_chess.management;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Position {

	private static final Logger log = LoggerFactory.getLogger(Position.class);

	private int x, y;

	private Position(String position) {
		x = position.charAt(0) - 'a';
		y = 8 - Character.getNumericValue(position.charAt(1));
		log.debug("{},{}", x, y);

	}

	public static Position create(String position) {
		return new Position(position);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return x + "," + y;
	}

}

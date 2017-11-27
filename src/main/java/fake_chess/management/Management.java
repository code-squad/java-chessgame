package fake_chess.management;

import java.util.List;

import fake_chess.board.Rank;
import fake_chess.piece.Piece.Color;

public class Management {
	public static final String NEWLINE = System.getProperty("line.separator");

	public enum Command {
		START("start"), END("end");

		private String command;

		private Command(String string) {
			command = string;
		}
	}

	public static String appendNewLine(String string) {
		return string + NEWLINE;
	}

	public static Double scoreCalculator(List<Rank> ranks, Color color) {
		Double score = 0.0;
		for (Rank rank : ranks) {
			score += rank.checkRank(color);
		}
		return score;
	}
}

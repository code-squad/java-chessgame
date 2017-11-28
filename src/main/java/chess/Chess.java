package chess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chess.board.Board;
import chess.board.Position;
import chess.exception.FreezeException;
import chess.view.ChessFormView;
import chess.view.ChessResultView;

public class Chess {

	private static final Logger log = LoggerFactory.getLogger(Chess.class);

	public static void main(String[] args) {
		Board board = new Board();
		String command = "";
		ChessResultView result;
		do {
			command = ChessFormView.inputCommand();
			if (command.equals("start")) {
				board.create();
				result = board.result();
				log.debug(result.show());
			}
			try {
				if (command.startsWith("move")) {
					String[] move = command.split(" ");
					board.move(Position.create(move[1]), Position.create(move[2]));
					result = board.result();
					log.debug(result.show());
				}
			} catch (FreezeException e) {
				log.debug(e.getMessage());
			}
		} while (!command.equals("end"));
	}
}

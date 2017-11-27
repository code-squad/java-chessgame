package chess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chess.board.Board;
import chess.view.ChessFormView;
import chess.view.ChessResultView;

public class Chess {

	private static final Logger log = LoggerFactory.getLogger(Chess.class);

	public static void main(String[] args) {
		Board board = new Board();
		board.create();
		ChessResultView result = board.result();
		log.debug("{}", result.show());
		String command;
		do {
			command = ChessFormView.inputCommand();
			result = board.result();
			log.debug("{}", result.show());
		} while (!command.equals("end"));
	}
}

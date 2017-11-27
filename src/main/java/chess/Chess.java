package chess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chess.board.Board;
import chess.view.ChessFormView;

public class Chess {

	private static final Logger log = LoggerFactory.getLogger(Chess.class);

	public static void main(String[] args) {
		Board board = new Board();
		board.create();
		log.debug("{}", board.show());
		String command;
		do {
			command = ChessFormView.inputCommand();
			log.debug("{}", board.show());
		} while (!command.equals("end"));
	}
}

package fake_chess;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fake_chess.board.Board;
import fake_chess.exception.ChessException;

public class Chess {

	private static final Logger log = LoggerFactory.getLogger(Chess.class);

	public static void main(String[] args) {
		Board board = new Board();
		Scanner scanner = new Scanner(System.in);
		log.debug("시작 명령어 : start, 종료 명령러 : end");
		String command = "";
		do {
			log.debug("명령어를 입력하세요 : ");
			command = scanner.nextLine();
			if (command.equals("start")) {
				board.initialize();
				log.debug(board.show());
			}
			try {
				if (command.startsWith("move")) {
					String[] move = command.split(" ");
					board.move(move[1], move[2]);
					log.debug(board.show());
				} else {
					throw new ChessException("move [현재위치] [이동할 위치] 명령을 내려주세요.");
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
				log.debug("좌표 값이 올바르지 않습니다 a~h, 1~8 사이의 값을 입력 해주세요");
			} catch (ChessException e) {
				log.debug(e.getMessage());
			}
		} while (!command.equals("end"));
		scanner.close();
	}
}

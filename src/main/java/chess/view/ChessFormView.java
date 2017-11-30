package chess.view;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChessFormView {

	private static final Logger log = LoggerFactory.getLogger(ChessFormView.class);

	private static Scanner scanner = new Scanner(System.in);

	public static String inputCommand() {
		log.debug("명령어를 입력해주세요 : 시작(start), 종료(end), 이동{(move) [현재 말의 위치] [이동 할 위치]}");
		return scanner.nextLine();
	}

}

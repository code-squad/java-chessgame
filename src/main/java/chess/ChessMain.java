package chess;

import java.util.Scanner;

import chess.model.board.Board;
import chess.model.board.NormalInitStrategy;

public class ChessMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Board board = new Board();
		board.init(new NormalInitStrategy());
		System.out.println(board.status());
		while(true) {
			System.out.println("이동할 위치를 입력해 주세요.(move a1 b2, 종료: end)");
			String input = scanner.nextLine();
			if("end".equals(input)) {
				break;
			}
			if("move".startsWith(input)) {
				String[] positions = input.split(" ");
				board.move(positions[1], positions[2]);
				System.out.println(board.status());
				continue;
			}
			System.out.println("잘못 입력 하셨습니다.");
		}
		scanner.close();
	}
}

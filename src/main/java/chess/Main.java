package chess;

import java.util.Scanner;

import View.ChessView;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board board = new Board();
		ChessView chessView = new ChessView(board);
		ChessGame chessGame = new ChessGame(board);

		while (true) {
			System.out.print("start or end ? : ");
			String input = sc.nextLine();
			if (input.equals("start")) {
				board.initialize();
				System.out.println(chessView.showBoard());
			} else if (input.startsWith("move")) {
				String[] position = input.split(" ");
				chessGame.move(position[1], position[2]);
				System.out.println(chessView.showBoard());
			} else if (input.equals("end")) {
				break;
			} else {
				System.out.println("다시 입력해주세요");
			}
		}

		sc.close();
	}
}

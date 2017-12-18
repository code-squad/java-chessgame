package chess;

import java.util.Scanner;

public class Chess {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("명령어를 입력하세요");
		while(true) {
			String command = sc.next();
			if("start".equals(command)) {
				System.out.println("체스 시작");
				Board board = new Board();
				board.initialize();
				System.out.println(board.showBoard());
			}
			if("end".equals(command)) {
				break;
			}
		}
		System.out.println("체스 끝");
		sc.close();
	}
}
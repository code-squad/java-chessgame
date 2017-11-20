package model;

import java.util.ArrayList;

public class Board {
	private ArrayList<BoardRow> board = new ArrayList<BoardRow>();

	public void initialize() {
		board.add(new BoardRow("back","black"));
		board.add(new BoardRow("front","black"));
		for (int i = 0; i < 4; i++)
			board.add(new BoardRow());
		board.add(new BoardRow("front","white"));
		board.add(new BoardRow());
	}

	public int pieceCount() {
		return board.stream().mapToInt(BoardRow::pieceCount).sum();
	}

	public String showBoard() {
		String result = "";
		for (BoardRow boardRow : board) {
			result += boardRow.getLine() + "\n";
		}
		return result;
	}
}

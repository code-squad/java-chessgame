package model;

import java.util.ArrayList;

public class BoardRow {
	private ArrayList<Piece> row;

	public BoardRow() {
		row = new ArrayList<Piece>();
		for (int i = 0; i < 8; i++) {
			row.add(null);
		}
	}

	public BoardRow(String line, String color) {
		if (line.equals("front"))
			row = initializeFrontLine(color);
		if (line.equals("back"))
			row = initializeBackLine(color);
	}

	public String getLine() {
		if (row.size() == 0) {
			return "........";
		}
		String result = "";
		for (int i = 0; i < 8; i++) {
			result += getChar(i);
		}
		return result;
	}

	public int pieceCount() {
		int count = 0;
		for (Piece piece : row) {
			if (piece != null) {
				count++;
			}
		}
		return count;
	}

	private char getChar(int index) {
		if (row.get(index) == null)
			return '.';
		return row.get(index).getRepresentation();
	}

	private ArrayList<Piece> initializeFrontLine(String color) {
		ArrayList<Piece> inputRow = new ArrayList<Piece>();
		for (int i = 0; i < 8; i++) {
			inputRow.add(new Pawn(color));
		}
		return inputRow;
	}

	private ArrayList<Piece> initializeBackLine(String color) {
		ArrayList<Piece> inputRow = new ArrayList<Piece>();
		for (int i = 0; i < 8; i++) {
			inputRow.add(null);
		}
		inputRow.set(7, new Pawn(color));
		return inputRow;
	}
}

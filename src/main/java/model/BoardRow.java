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
	
	public void setPiece(String value, Piece piece) {
		row.set(matchingLocation(value), piece);
	}

	public Piece getLocationValue(String value) {
		return row.get(matchingLocation(value));
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

	private int matchingLocation(String locationValue) {
		Location[] values = Location.values();
		for (Location location : values) {
			if (location.getValue().equals(locationValue))
				return location.getIndex();
		}
		throw new IllegalArgumentException(locationValue + "는 유효하지 않은 값입니다.");
	}

	private enum Location {
		A(0, "A"), B(1, "B"), C(2, "C"), D(3, "D"), E(4, "E"), F(5, "F"), G(6, "G"), H(7, "H");
		private int index;
		private String value;

		Location(int index, String value) {
			this.index = index;
			this.value = value;
		}

		public int getIndex() {
			return index;
		}

		public String getValue() {
			return value;
		}
	}
}

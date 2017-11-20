package model;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exception.InvalidLocationException;
import exception.PickNullPieceException;;

public class Board {
	private ArrayList<BoardRow> board = new ArrayList<BoardRow>();

	public void initialize() {
		board.add(new BoardRow());
		board.add(new BoardRow("front", "black"));
		for (int i = 0; i < 4; i++)
			board.add(new BoardRow());
		board.add(new BoardRow("front", "white"));
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

	public void move(String currentLocation, String newLocation) {
		Piece piece = getPieceInLocation(currentLocation);
		if (piece == null) {
			throw new PickNullPieceException("해당 좌표에 말이 없습니다.");
		}
		setPieceInLocation(newLocation, piece);
		setPieceInLocation(currentLocation, null);
	}

	private void setPieceInLocation(String location, Piece piece) throws InvalidLocationException {
		checkInvalidLocationException(location);

		int rowIndex = rowIndex(location);

		BoardRow boardRow = board.get(rowIndex);
		boardRow.setPiece(columnIndex(location), piece);
		board.set(rowIndex, boardRow);
	}

	private int rowIndex(String location) {
		return Integer.parseInt(location.substring(1)) - 1;
	}

	private String columnIndex(String location) {
		return location.substring(0, 1);
	}

	private Piece getPieceInLocation(String location) {
		checkInvalidLocationException(location);
		BoardRow boardRow = board.get(rowIndex(location));
		return boardRow.getLocationValue(columnIndex(location));
	}

	private void checkInvalidLocationException(String location) {
		if (location.length() != 2)
			throw new InvalidLocationException("좌표를 잘 못 입력했습니다.");
	}
}

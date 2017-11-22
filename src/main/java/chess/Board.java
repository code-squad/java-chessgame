package chess;

import java.util.ArrayList;

import exception.InvalidLocationException;
import exception.InvalidMoveException;
import piece.Piece;

public class Board {
	private ArrayList<BoardRow> board = new ArrayList<BoardRow>();

	public void initialize() {
		board.add(new BoardRow("back", "white"));
		board.add(new BoardRow("front", "white"));
		for (int i = 0; i < 4; i++)
			board.add(new BoardRow());
		board.add(new BoardRow("front", "black"));
		board.add(new BoardRow("back", "black"));
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

	public void move(String currentValue, String newValue) {
		Location currentLocation = new Location(currentValue);
		Location newLocation = new Location(newValue);
		Piece piece = getPieceInLocation(currentLocation);
		if (!piece.isMovable(currentLocation, newLocation))
			throw new InvalidMoveException("해당 좌표로 움직일 수 없습니다.");
		setPieceInLocation(newLocation, piece);
		setPieceInLocation(currentLocation, null);
	}

	private void setPieceInLocation(Location location, Piece piece) throws InvalidLocationException {
		int rowIndex = location.getRowIndex();
		BoardRow boardRow = board.get(rowIndex);
		boardRow.setPiece(location.getColumnIndex(), piece);
		board.set(rowIndex, boardRow);
	}

	private Piece getPieceInLocation(Location location) {
		BoardRow boardRow = board.get(location.getRowIndex());
		return boardRow.findPiece(location.getColumnIndex());
	}
}
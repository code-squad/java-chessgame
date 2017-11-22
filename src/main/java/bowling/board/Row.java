package bowling.board;

import java.util.ArrayList;
import java.util.List;

import chess.piece.Pawn;

public class Row {

	private List<Pawn> pieces;

	private Row(int CHESS_SIZE) {
		pieces = new ArrayList<>();
		createPiece(CHESS_SIZE);
	}

	private void createPiece(int CHESS_SIZE) {
		for (int i = 0; i < CHESS_SIZE; i++) {
			pieces.add(new Pawn("black"));
		}
	}

	public static Row create(int CHESS_SIZE) {
		return new Row(CHESS_SIZE);
	}

	public List<Pawn> getPieces() {
		return pieces;
	}

	public String show() {
		return rowToString(pieces).toString();
	}

	public StringBuilder rowToString(List<Pawn> pieces) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Pawn index : pieces) {
			stringBuilder.append(index.getPiece());
		}
		return stringBuilder;
	}
}

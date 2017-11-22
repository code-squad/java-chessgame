package bowling.board;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private final int CHESS_SIZE = 8;
	private List<Row> rows;

	private Board() {
		rows = new ArrayList<>();
		createRow();
	}

	public static Board create() {
		return new Board();
	}

	public String show() {
		return rowsToString(rows).toString();
	}

	private StringBuilder rowsToString(List<Row> rows) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Row row : rows) {
			stringBuilder.append(row.rowToString(row.getPieces()));
			stringBuilder.append("\n");
		}
		return stringBuilder;
	}

	public List<Row> getRows() {
		return rows;
	}

	private void createRow() {
		for (int i = 0; i < CHESS_SIZE; i++) {
			rows.add(Row.create(CHESS_SIZE));
		}
	}
}

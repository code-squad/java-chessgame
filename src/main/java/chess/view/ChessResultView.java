package chess.view;

import java.util.List;

import chess.board.Board;
import chess.board.Rank;
import chess.piece.Piece;

public class ChessResultView {

	private Board board;

	public ChessResultView(Board board) {
		this.board = board;
	}

	public String show() {
		StringBuilder sb = new StringBuilder();
		List<Rank> ranks = board.getRanks();
		for (int i = ranks.size() - 1; i >= 0; i--) {
			List<Piece> pieces = ranks.get(i).getPieces();
			sb.append(i + 1);
			sb.append(" ");
			for (int j = 0; j < 8; j++) {
				sb.append(pieces.get(j).toString());
			}
			sb.append("\n");
		}
		sb.append("  abcdefgh");
		return sb.toString();
	}
}

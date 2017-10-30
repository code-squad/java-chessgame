package chess.model.board;

import java.util.ArrayList;
import java.util.List;

import chess.model.piece.Bishop;
import chess.model.piece.Blank;
import chess.model.piece.King;
import chess.model.piece.Knight;
import chess.model.piece.Pawn;
import chess.model.piece.Piece;
import chess.model.piece.Piece.Color;
import chess.model.piece.Position;
import chess.model.piece.Queen;
import chess.model.piece.Rook;

public class Rank {
	private List<Piece> pieces;

	private Rank() {
		pieces = new ArrayList<>();
	}

	public static Rank createBlackPieces() {
		return createPieces(0, Color.BLACK);
	}

	public static Rank createWhitePieces() {
		return createPieces(7, Color.WHITE);
	}

	private static Rank createPieces(int yPos, Color color) {
		Rank rank = new Rank();
		rank.pieceAdd(new Knight(new Position(0, yPos), color));
		rank.pieceAdd(new Rook(new Position(1, yPos), color));
		rank.pieceAdd(new Bishop(new Position(2, yPos), color));
		rank.pieceAdd(new Queen(new Position(3, yPos), color));
		rank.pieceAdd(new King(new Position(4, yPos), color));
		rank.pieceAdd(new Rook(new Position(5, yPos), color));
		rank.pieceAdd(new Bishop(new Position(6, yPos), color));
		rank.pieceAdd(new Knight(new Position(7, yPos), color));
		return rank;
	}

	public static Rank createBlackPawns() {
		return createPawns(1, Color.BLACK);
	}

	public static Rank createWhitePawns() {
		return createPawns(6, Color.WHITE);
	}

	private static Rank createPawns(int yPos, Color color) {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.pieceAdd(new Pawn(new Position(i, yPos), color));
		}
		return rank;
	}

	public static Rank createBlank(int yPos) {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.pieceAdd(new Blank(new Position(i, yPos)));
		}
		return rank;
	}

	private void pieceAdd(Piece piece) {
		pieces.add(piece);
	}

	public String getRepresents() {
		StringBuilder sb = new StringBuilder();
		for (Piece piece : pieces) {
			sb.append(piece.getRepresent());
		}
		return sb.toString();
	}

	public Piece findPiece(int xIndex) {
		return pieces.get(xIndex);
	}

	public void move(Piece piece) {
		pieces.set(piece.getXIndex(), piece);
	}

}

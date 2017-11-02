package chess.model.board;

import java.util.ArrayList;
import java.util.List;

import chess.model.piece.Bishop;
import chess.model.piece.Blank;
import chess.model.piece.InvalidPositionException;
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
		Rank rank = new Rank();
		rank.pieceAdd(Rook.createBlack(new Position(0, 0)));
		rank.pieceAdd(Knight.createBlack(new Position(1, 0)));
		rank.pieceAdd(Bishop.createBlack(new Position(2, 0)));
		rank.pieceAdd(Queen.createBlack(new Position(3, 0)));
		rank.pieceAdd(King.createBlack(new Position(4, 0)));
		rank.pieceAdd(Bishop.createBlack(new Position(5, 0)));
		rank.pieceAdd(Knight.createBlack(new Position(6, 0)));
		rank.pieceAdd(Rook.createBlack(new Position(7, 0)));
		return rank;
	}

	public static Rank createWhitePieces() {
		Rank rank = new Rank();
		rank.pieceAdd(Rook.createWhite(new Position(0, 7)));
		rank.pieceAdd(Knight.createWhite(new Position(1, 7)));
		rank.pieceAdd(Bishop.createWhite(new Position(2, 7)));
		rank.pieceAdd(Queen.createWhite(new Position(3, 7)));
		rank.pieceAdd(King.createWhite(new Position(4, 7)));
		rank.pieceAdd(Bishop.createWhite(new Position(5, 7)));
		rank.pieceAdd(Knight.createWhite(new Position(6, 7)));
		rank.pieceAdd(Rook.createWhite(new Position(7, 7)));
		return rank;
	}

	public static Rank createBlackPawns() {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.pieceAdd(Pawn.createBlack(new Position(i, 1)));
		}
		return rank;
	}

	public static Rank createWhitePawns() {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.pieceAdd(Pawn.createWhite(new Position(i, 6)));
		}
		return rank;
	}

	public static Rank createBlank(int yPos) {
		Rank rank = new Rank();
		for (int i = 0; i < 8; i++) {
			rank.pieceAdd(Blank.create(new Position(i, yPos)));
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
		int xIndex = piece.getXIndex();
		Piece targetPiece = pieces.get(xIndex);
		if (targetPiece.sameColor(piece.getColor())) {
			throw new InvalidPositionException("같은 색의 말이 있어서 이동이 안됩니다.");
		}
		pieces.set(xIndex, piece);
	}

	public double calScore(Color color) {
		double score = 0;
		for (Piece piece : pieces) {
			score += piece.getScore(color);
		}
		return score;
	}

	public void leave(Position position) {
		move(Blank.create(position));
	}

}

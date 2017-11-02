package chess.model.board;

import java.util.ArrayList;
import java.util.List;

import chess.model.piece.Blank;
import chess.model.piece.InvalidPositionException;
import chess.model.piece.Piece;
import chess.model.piece.Piece.Color;
import chess.model.piece.Position;

public class Board {
	private List<Rank> ranks;

	public void init() {
		ranks = new ArrayList<>();
		ranks.add(Rank.createBlackPieces());
		ranks.add(Rank.createBlackPawns());
		ranks.add(Rank.createBlank(2));
		ranks.add(Rank.createBlank(3));
		ranks.add(Rank.createBlank(4));
		ranks.add(Rank.createBlank(5));
		ranks.add(Rank.createWhitePawns());
		ranks.add(Rank.createWhitePieces());
	}

	public void initBlank() {
		ranks = new ArrayList<>();
		ranks.add(Rank.createBlank(0));
		ranks.add(Rank.createBlank(1));
		ranks.add(Rank.createBlank(2));
		ranks.add(Rank.createBlank(3));
		ranks.add(Rank.createBlank(4));
		ranks.add(Rank.createBlank(5));
		ranks.add(Rank.createBlank(6));
		ranks.add(Rank.createBlank(7));
	}

	public void addPiece(Piece piece) {
		Rank rank = ranks.get(piece.getYIndex());
		rank.move(piece);
	}

	public String status() {
		StringBuilder sb = new StringBuilder();
		for (int i = ranks.size() - 1; i >= 0; i--) {
			Rank rank = ranks.get(i);
			sb.append(rank.getRepresents()).append("\n");
		}
		return sb.toString();
	}

	public Piece findPiece(String pos) {
		Position position = new Position(pos);
		return findPiece(position);
	}

	private Piece findPiece(Position position) {
		Rank rank = ranks.get(position.getYIndex());
		return rank.findPiece(position.getXIndex());
	}

	public void move(String source, String target) {
		Piece sourcePiece = findPiece(source);
		Position targetPosition = new Position(target);
		List<Position> positions = sourcePiece.pathWay(targetPosition);

		for (Position position : positions) {
			isBlank(position);
		}
		move(sourcePiece, targetPosition);
	}

	private void move(Piece sourcePiece, Position targetPosition) {
		Rank sourceRank = ranks.get(sourcePiece.getYIndex());
		Rank targetRank = ranks.get(targetPosition.getYIndex());
		Piece blank = Blank.create(sourcePiece.getPosition());
		sourcePiece.move(targetPosition);
		targetRank.move(sourcePiece);
		sourceRank.move(blank);
	}

	private void isBlank(Position position) {
		Piece piece = findPiece(position);
		if (!piece.isBlank()) {
			throw new InvalidPositionException("이동 상의 경로에 다른 말이 있습니다.");
		}
	}

	public double calScore(Color color) {
		double score = 0;
		for (Rank rank : ranks) {
			score += rank.calScore(color);
		}
		return score;
	}
}

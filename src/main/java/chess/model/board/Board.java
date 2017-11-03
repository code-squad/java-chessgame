package chess.model.board;

import java.util.ArrayList;
import java.util.List;

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
		for (int i = 0; i < 8; i++) {
			ranks.add(Rank.createBlank(i));
		}
	}

	public void addPiece(Piece piece) {
		Rank rank = findRank(piece.getYIndex());
		rank.move(piece);
	}

	public String status() {
		StringBuilder sb = new StringBuilder();
		for (int i = ranks.size() - 1; i >= 0; i--) {
			Rank rank = findRank(i);
			sb = rank.status(sb).append("\n");
		}
		return sb.toString();
	}

	public Piece findPiece(String pos) {
		return findPiece(new Position(pos));
	}

	private Piece findPiece(Position position) {
		Rank rank = findRank(position.getYIndex());
		return rank.findPiece(position.getXIndex());
	}

	public void move(String source, String target) {
		Piece sourcePiece = findPiece(source);
		Position targetPosition = new Position(target);
		List<Position> routes = sourcePiece.pathWay(targetPosition);

		for (Position route : routes) {
			isBlank(route);
		}
		move(sourcePiece, targetPosition);
	}

	private void move(Piece sourcePiece, Position targetPosition) {
		Rank sourceRank = findRank(sourcePiece.getYIndex());
		Rank targetRank = findRank(targetPosition.getYIndex());
		sourceRank.leave(sourcePiece.getPosition());
		sourcePiece.move(targetPosition);
		targetRank.move(sourcePiece);
	}
	
	private Rank findRank(int yIndex) {
		return ranks.get(yIndex);
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

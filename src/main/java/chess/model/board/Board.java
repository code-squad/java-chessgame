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

	public Board() {
	}

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

	public String show() {
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
		Position sourcePosition = new Position(source);
		Position targetPosition = new Position(target);
		Piece blank = Blank.create(sourcePosition);

		Rank sourceRank = ranks.get(sourcePiece.getYIndex());
		Rank targetRank = ranks.get(targetPosition.getYIndex());

		List<Position> positions = sourcePiece.pathWay(targetPosition);

		if (positions.isEmpty()) {
			sourcePiece.move(targetPosition);
			targetRank.move(sourcePiece);
			sourceRank.move(blank);
			if (isSameColor(sourcePosition, targetPosition)) {
				throw new InvalidPositionException("같은 색의 말이 위치하고 있습니다.");
			}
			return;
		}
		for (Position position : positions) {
			isBlank(position);
		}
		sourcePiece.move(targetPosition);
		targetRank.move(sourcePiece);
		sourceRank.move(blank);
		if (isSameColor(sourcePosition, targetPosition)) {
			throw new InvalidPositionException("같은 색의 말이 위치하고 있습니다.");
		}
		return;

	}

	private void isBlank(Position position) {
		Piece piece = findPiece(position);
		if (!piece.isBlank()) {
			throw new InvalidPositionException("이동 상의 경로에 다른 말이 있습니다.");
		}
	}

	private boolean isSameColor(Position sourcePosition, Position targetPosition) {
		Piece source = findPiece(sourcePosition);
		Piece target = findPiece(targetPosition);
		return source.sameColor(target.getColor());
	}

	public double calScore(Color color) {
		double score = 0;
		for (Rank rank : ranks) {
			score += rank.calScore(color);
		}
		return score;
	}
}

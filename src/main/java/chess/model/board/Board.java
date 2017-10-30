package chess.model.board;

import java.util.ArrayList;
import java.util.List;

import chess.model.piece.Blank;
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

	public String show() {
		StringBuilder sb = new StringBuilder();
		for(int i = ranks.size() - 1; i >= 0; i--) {
			Rank rank = ranks.get(i);
			sb.append(rank.getRepresents()).append("\n");
		}
		return sb.toString();
	}

	public Piece findPiece(String pos) {
		Position position = new Position(pos);
		Rank rank = ranks.get(position.getYIndex());
		return rank.findPiece(position.getXIndex());
	}

	public boolean move(String source, String target) {
		Piece sourcePiece = findPiece(source);
		Position sourcePos = new Position(source);
		Position targetPos = new Position(target);
		Piece blank = Blank.create(sourcePos);

		Rank sourceRank = ranks.get(sourcePiece.getYIndex());
		Rank targetRank = ranks.get(targetPos.getYIndex());

		if(!sourcePiece.checkMove(targetPos)) {
			return false;
		}
		sourcePiece.move(targetPos);
		if(!targetRank.move(sourcePiece)) {
			return false;
		}
		sourceRank.move(blank);
		
		return true;
	}

	public double calScore(Color color) {
		double score = 0;
		for(Rank rank : ranks) {
			score += rank.calScore(color);
		}
		return score;
	}
}

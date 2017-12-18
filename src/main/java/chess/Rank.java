package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;

public class Rank {
	private List<Piece> rank = new ArrayList<>();
	
	public void addBlank(Piece piece) {
		rank.add(piece);
	}
	
	public void addWhitePawn(Piece pawn) {
		rank.add(pawn);
	}
	
	public void addBlackPawn(Piece pawn) {
		rank.add(pawn);
	}
	
	public void addWhitePiece(Piece piece) {
		rank.add(piece);
	}
	
	public void addBlackPiece(Piece piece) {
		rank.add(piece);
	}
	
	public Piece findWhitePawn(int index) {
		return rank.get(index);
	}

	public Piece findBlackPawn(int index) {
		return rank.get(index);
	}
	
	public Piece findWhitePiece(int index) {
		return rank.get(index);
	}
	
	public Piece findBlackPiece(int index) {
		return rank.get(index);
	}
	
	public Piece findPiece(int index) {
		System.out.println(index);
		return rank.get(index);
	}
	
	public String getRankResult() {
		StringBuilder sb = new StringBuilder();
		for(Piece piece : rank) {
			sb.append(piece.getRepresentation());
		}
		return sb.toString();
	}

	public int countPiece(Color color, Type type) {
		int count = 0;
		for(Piece piece : rank) {
			if(piece.isSame(color, type)) {
				count++;
			}
		}
		return count;
	}
}
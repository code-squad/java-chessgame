package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;

public class Rank {
	private List<Piece> rank = new ArrayList<>(Board.WIDTH);
	
	public List<Rank> initialize() {
		List<Rank> ranks = new ArrayList<>(8);
		ranks.add(initializeBlackPieceRank());
		ranks.add(initializeBlackPawnRank());
		ranks.add(initializeBlankRank());
		ranks.add(initializeBlankRank());
		ranks.add(initializeBlankRank());
		ranks.add(initializeBlankRank());
		ranks.add(initializeWhitePawnRank());
		ranks.add(initializeWhitePieceRank());
		return ranks;
	}
	
	private Rank initializeWhitePieceRank() {
		Rank rank = new Rank();
		rank.add(Piece.createWhiteRook());
		rank.add(Piece.createWhiteKnight());
		rank.add(Piece.createWhiteBishop());
		rank.add(Piece.createWhiteQueen());
		rank.add(Piece.createWhiteKing());
		rank.add(Piece.createWhiteBishop());
		rank.add(Piece.createWhiteKnight());
		rank.add(Piece.createWhiteRook());
		return rank;
	}

	private Rank initializeBlackPieceRank() {
		Rank rank = new Rank();
		rank.add(Piece.createBlackRook());
		rank.add(Piece.createBlackKnight());
		rank.add(Piece.createBlackBishop());
		rank.add(Piece.createBlackQueen());
		rank.add(Piece.createBlackKing());
		rank.add(Piece.createBlackBishop());
		rank.add(Piece.createBlackKnight());
		rank.add(Piece.createBlackRook());
		return rank;
	}

	private Rank initialize(Piece piece) {
		Rank rank = new Rank();
		for(int j = 0; j < Board.WIDTH; j++) {
			rank.add(piece);
		}
		return rank;
	}
	
	public Rank initializeBlankRank() {
		return initialize(Piece.createBlank());
	} 
	
	public Rank initializeWhitePawnRank() {
		return initialize(Piece.createWhitePawn());
	} 
	
	public Rank initializeBlackPawnRank() {
		return initialize(Piece.createBlackPawn());
	} 
	
	public void add(Piece piece) {
		rank.add(piece);
	}
	
	public Piece findPiece(int index) {
		return rank.get(index);
	}
	
	public void set(int index, Piece piece) {
		rank.set(index, piece);
	}
	
	public String getRankResult() {
		StringBuilder sb = new StringBuilder();
		for(Piece piece : rank) {
			sb.append(piece.getRepresentation());
		}
		return sb.toString();
	}

	public int countPiece(Color color, Type type) {
		return (int) rank.stream().filter(piece -> piece.isSame(color, type)).count();
	}

	public double calculatePoint(Color color) {
		return rank.stream().mapToDouble(piece -> piece.calculatePoint(color)).sum();
	}

	public List<Integer> findAllPawnsXPos(Color color) {
		List<Integer> xPos = new ArrayList<>();
		for(int i = 0; i < Board.WIDTH; i++) {
			if(rank.get(i).isSame(color, Piece.Type.PAWN)) {
				xPos.add(i);
			}
		}
		return xPos;
	}

	public List<Piece> getSurvivedPiece(Color color) {
		List<Piece> survivedPieces = new ArrayList<>();
		for(Piece piece : rank) {
			if(piece.isSameColor(color)) {
				survivedPieces.add(piece);
			}
		}
		return survivedPieces;
	}
}
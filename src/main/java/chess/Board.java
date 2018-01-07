package chess;

import static utils.StringUtils.appendNewLine;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import pieces.Position;

public class Board {
	
	List<Rank> ranks = new ArrayList<Rank>();
	
	int getMatchCountsOfPiece(Color color, Type type) {
		int matchCountsOfPiece = 0;
		for (Rank rank : ranks) {
			matchCountsOfPiece += rank.getCountsOfPiece(color, type);
		}
		return matchCountsOfPiece;
	}

	public void initialize() {
		ranks.add(Rank.initializeBlackPieces());
        ranks.add(Rank.initializeBlackPawns());
        ranks.add(Rank.initializeBlank());
        ranks.add(Rank.initializeBlank());
        ranks.add(Rank.initializeBlank());
        ranks.add(Rank.initializeBlank());
        ranks.add(Rank.initializeWhitePawns());
        ranks.add(Rank.initializeWhitePieces());
    }
	
	public void initializeEmpty() {
		for (int i = 0; i < 8; i++) {
			ranks.add(Rank.initializeBlank());
		}
	}

	private String showEachRank(Rank rank) {
		StringBuilder eachRank = new StringBuilder();
		for (Piece piece : rank.getPieces()) {
			eachRank.append(piece.getRepresentation());
		}
		return appendNewLine(eachRank.toString());
	}
	
	String showBoard() {
		StringBuilder board = new StringBuilder();
		for (Rank rank : ranks) {
			board.append(showEachRank(rank));
		}
		return board.toString();
	}

	public Piece findPiece(String str) {
		Position position = new Position(str);
		Rank rank = ranks.get(position.getY());
		Piece piece = rank.getPieces().get(position.getX());
		return piece;
	}
	
//	Piece move(Position position, Piece piece) {
//		
//	}
}

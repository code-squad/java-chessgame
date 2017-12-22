package chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import utils.StringUtils;

public class Board {
	public final static int HEIGHT = 8;
	public final static int WIDTH = 8;
	private List<Rank> ranks = new ArrayList<>(Board.HEIGHT);

	public void initialize() {
		ranks.addAll(new Rank().initialize());
	}

	public void initializeEmpty() {
		for (int i = 0; i < HEIGHT; i++) {
			ranks.add(new Rank().initializeBlankRank());
		}
	}

	private String getPieceResult(List<Piece> pieces) {
		StringBuilder sb = new StringBuilder();
		for (Piece piece : pieces) {
			sb.append(piece.getRepresentation());
		}
		return sb.toString();
	}

	public String showBoard() {
		StringBuilder sb = new StringBuilder();
		for (Rank rank : ranks) {
			sb.append(rank.getRankResult());
			StringUtils.appendNewLine(sb);
		}
		return sb.toString();
	}

	public int countPiece(Color color, Type type) {
		return ranks.stream().mapToInt(rank -> rank.countPiece(color, type)).sum();
	}

	public Piece findPiece(String position) {
		return getRankByPos(position).findPiece(Position.getXPos(position));
	}

	public void move(String position, Piece piece) {
		getRankByPos(position).set(Position.getXPos(position), piece);
	}

	private Rank getRankByPos(String position) {
		return ranks.get(Position.getYPos(position));
	}

	public double caculcatePoint(Color color) {
		List<Integer> pawnsXPos = new ArrayList<>();
		double score = 0.0;
		for (Rank rank : ranks) {
			score += rank.calculatePoint(color);
			pawnsXPos.addAll(rank.findAllPawnsXPos(color));
		}
		Collections.sort(pawnsXPos);
		return score - (0.5 * countDuplicatedPawn(pawnsXPos));
	}
	
	private int countDuplicatedPawn(List<Integer> pawnsXPos) {
		int duplicatedCount = pawnsXPos.size();
		for (int x : pawnsXPos) {
			if (pawnsXPos.indexOf(x) == pawnsXPos.lastIndexOf(x)) {
				duplicatedCount--;
			}
		}
		return duplicatedCount;
	}

	private List<Piece> getSurvivedPiece(Color color) {
		List<Piece> survivedPieces = new ArrayList<>();
		for(Rank rank : ranks) {
			survivedPieces.addAll(rank.getSurvivedPiece(color));
		}
		return survivedPieces;
	}
	
	public String sortAsc(Color color) {
		List<Piece> survivedPieces = getSurvivedPiece(color);
		Collections.sort(survivedPieces);
		return getPieceResult(survivedPieces); 
	}
	
	public String sortDesc(Color color) {
		List<Piece> survivedPieces = getSurvivedPiece(color);
		Collections.sort(survivedPieces, Collections.reverseOrder());
		//Collections.sort(survivedPieces); //sort 안 하고 reverse만 하면 리스트에 있는 순서를 바꿔줌
		//Collections.reverse(survivedPieces);
		return getPieceResult(survivedPieces);
	}
}
package fake_chess.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fake_chess.management.Management;
import fake_chess.management.Position;
import fake_chess.piece.Piece;
import fake_chess.piece.Piece.Color;
import fake_chess.piece.Piece.Type;

public class Board {

	private static final Logger log = LoggerFactory.getLogger(Board.class);

	private List<Rank> ranks = new ArrayList<>();

	public void add(Rank rank) {
		ranks.add(rank);
	}

	public void initialize() {
		add(Rank.createSpetialRank(Piece.createWhite(Type.ROOK), Piece.createWhite(Type.KNIGHT),
				Piece.createWhite(Type.BISHOP), Piece.createWhite(Type.QUEEN), Piece.createWhite(Type.KING),
				Piece.createWhite(Type.BISHOP), Piece.createWhite(Type.KNIGHT), Piece.createWhite(Type.ROOK)));
		add(Rank.createPawnRank(Piece.createWhite(Type.PAWN)));
		add(Rank.createPawnRank(Piece.createBlack(Type.BLANK)));
		add(Rank.createPawnRank(Piece.createBlack(Type.BLANK)));
		add(Rank.createPawnRank(Piece.createBlack(Type.BLANK)));
		add(Rank.createPawnRank(Piece.createBlack(Type.BLANK)));
		add(Rank.createSpetialRank(Piece.createBlack(Type.ROOK), Piece.createBlack(Type.KNIGHT),
				Piece.createBlack(Type.BISHOP), Piece.createBlack(Type.QUEEN), Piece.createBlack(Type.KING),
				Piece.createBlack(Type.BISHOP), Piece.createBlack(Type.KNIGHT), Piece.createBlack(Type.ROOK)));
		add(Rank.createPawnRank(Piece.createBlack(Type.PAWN)));
	}

	public List<Rank> getRank() {
		return ranks;
	}

	public int getSize() {
		return ranks.size();
	}

	public String show() {
		return print();
	}

	private String print() {
		StringBuilder sb = new StringBuilder();
		for (int i = ranks.size() - 1; i >= 0; i--) {
			sb.append(ranks.get(i).print() + Management.NEWLINE);
		}
		return sb.toString();
	}

	public int pieceOnBoard(Type type, Color color) {
		int count = 0;
		for (Rank index : ranks) {
			count += index.checkRank(type, color);
		}
		return count;
	}

	public Piece findPiece(String location) {
		Position position = Position.create(location);
		return ranks.get(position.getX()).findPiece(position.getY());
	}

	public Piece getPiece(String location) {
		Position position = Position.create(location);
		return ranks.get(position.getX()).removePiece(position.getY());
	}

	public void blankInitialize() {
		for (int i = 0; i < 8; i++) {
			add(Rank.createBlankRank(Piece.createBlank(Type.BLANK)));
		}
	}

	public void addPiece(Type type, Color color, String location) {
		Position position = Position.create(location);
		ranks.get(position.getY()).setPiece(position.getX(), type, color);
	}

	private void addPiece(Piece piece, String nowPosition) {
		Position position = Position.create(nowPosition);
		ranks.set(position.getY(), Rank.setPiece(position.getX(), piece, ranks.get(position.getY())));
	}

	public void move(String pastPosition, String nowPosition) {
		try {
			addPiece(getPiece(pastPosition), nowPosition);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("이전위치 : " + pastPosition + "\t 현재 위치 : " + nowPosition);
		}
	}

	public void move(String position, Piece piece) {
		addPiece(piece, position);
	}

	public void initializeEmpty() {
		blankInitialize();
	}

	public double caculcatePoint(Color color) {
		List<Rank> temp = this.getRank();
		int score = 0;
		for (Rank index : temp) {
			for (Piece piece : index.getPieces()) {
				if (piece.getColor() == color) {
					score += piece.getScore();
				}
			}
		}
		return score;
	}

}

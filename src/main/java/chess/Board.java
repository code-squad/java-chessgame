package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece;
import utils.StringUtils;

public class Board {
	public final String BLANK = "........";
	private List<Piece> whitePiece = new ArrayList<>();
	private List<Piece> blackPiece = new ArrayList<>();
	private List<Piece> whitePawns = new ArrayList<>();
	private List<Piece> blackPawns = new ArrayList<>();
	
	public void addWhitePawn(Piece pawn) {
		whitePawns.add(pawn);
	}
	
	public void addBlackPawn(Piece pawn) {
		blackPawns.add(pawn);
	}
	
	public void addWhitePiece(Piece piece) {
		whitePiece.add(piece);
	}
	
	public void addBlackPiece(Piece piece) {
		blackPiece.add(piece);
	}
	
	public Piece findWhitePawn(int index) {
		return whitePawns.get(index);
	}

	public Piece findBlackPawn(int index) {
		return blackPawns.get(index);
	}
	
	public Piece findWhitePiece(int index) {
		return whitePiece.get(index);
	}
	
	public Piece findBlackPiece(int index) {
		return blackPiece.get(index);
	}
	
	public void initialize() {
		for(int i = 0; i < 8; i++) {
			addWhitePawn(Piece.createWhitePawn());
			addBlackPawn(Piece.createBlackPawn());
		}
		addWhitePiece(Piece.createWhiteRook());
		addWhitePiece(Piece.createWhiteKnight());
		addWhitePiece(Piece.createWhiteBishop());
		addWhitePiece(Piece.createWhiteQueen());
		addWhitePiece(Piece.createWhiteKing());
		addWhitePiece(Piece.createWhiteBishop());
		addWhitePiece(Piece.createWhiteKnight());
		addWhitePiece(Piece.createWhiteRook());

		addBlackPiece(Piece.createBlackRook());
		addBlackPiece(Piece.createBlackKnight());
		addBlackPiece(Piece.createBlackBishop());
		addBlackPiece(Piece.createBlackQueen());
		addBlackPiece(Piece.createBlackKing());
		addBlackPiece(Piece.createBlackBishop());
		addBlackPiece(Piece.createBlackKnight());
		addBlackPiece(Piece.createBlackRook());
	}
/*	
	public String getWhitePawnsResult() {
		return getPawnResult(whitePawns);
	}
	
	public String getBlackPawnsResult() {
		return getPawnResult(blackPawns);
	}
*/	
	public String getPieceResult(List<Piece> pieces) {
		StringBuilder sb = new StringBuilder();
		for(Piece piece : pieces) {
			sb.append(piece.getRepresentation());
		}
		return sb.toString();
	}
	
	public String showBoard() {
		StringBuilder sb = new StringBuilder();
		sb.append(getPieceResult(whitePiece));
		StringUtils.appendNewLine(sb);
		sb.append(getPieceResult(whitePawns));
		//static import가 이렇게 쓰는 건가??
		StringUtils.appendNewLine(sb);
		sb.append(BLANK);
		StringUtils.appendNewLine(sb);
		sb.append(BLANK);
		StringUtils.appendNewLine(sb);
		sb.append(BLANK);
		StringUtils.appendNewLine(sb);
		sb.append(BLANK);
		StringUtils.appendNewLine(sb);
		sb.append(getPieceResult(blackPawns)); //이걸 다 메소드로 따로 만드는 게 좋은 건가???
		StringUtils.appendNewLine(sb);
		sb.append(getPieceResult(blackPiece));
		StringUtils.appendNewLine(sb);
		return sb.toString();
	}

	public int pieceCount() {
		return whitePawns.size() +whitePiece.size() + blackPawns.size() + blackPiece.size();
	}
}

package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.Type;
import utils.StringUtils;

public class Board {
	private List<Rank> ranks = new ArrayList<>();
/*	
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
*/	
	public void initialize() {
		Rank whitePawn = new Rank();
		Rank whitePiece = new Rank();
		Rank blackPawn = new Rank();
		Rank blackPiece = new Rank();
		Rank blank = new Rank();
		
		for(int i = 0; i < 8; i++) {
			whitePawn.addWhitePawn(Piece.createWhitePawn());
			blackPawn.addBlackPawn(Piece.createBlackPawn());
			blank.addBlank(Piece.createBlank());
		}
		whitePiece.addWhitePiece(Piece.createWhiteRook());
		whitePiece.addWhitePiece(Piece.createWhiteKnight());
		whitePiece.addWhitePiece(Piece.createWhiteBishop());
		whitePiece.addWhitePiece(Piece.createWhiteQueen());
		whitePiece.addWhitePiece(Piece.createWhiteKing());
		whitePiece.addWhitePiece(Piece.createWhiteBishop());
		whitePiece.addWhitePiece(Piece.createWhiteKnight());
		whitePiece.addWhitePiece(Piece.createWhiteRook());
		
		blackPiece.addBlackPiece(Piece.createBlackRook());
		blackPiece.addBlackPiece(Piece.createBlackKnight());
		blackPiece.addBlackPiece(Piece.createBlackBishop());
		blackPiece.addBlackPiece(Piece.createBlackQueen());
		blackPiece.addBlackPiece(Piece.createBlackKing());
		blackPiece.addBlackPiece(Piece.createBlackBishop());
		blackPiece.addBlackPiece(Piece.createBlackKnight());
		blackPiece.addBlackPiece(Piece.createBlackRook());

		ranks.add(blackPiece);
		ranks.add(blackPawn);
		ranks.add(blank);
		ranks.add(blank);//이거 클론?해줘야하지 않을까?
		
		ranks.add(blank);
		ranks.add(blank);
		ranks.add(whitePawn);
		ranks.add(whitePiece);
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
		for(Rank rank : ranks) {
			sb.append(rank.getRankResult());
			StringUtils.appendNewLine(sb);
		}
		return sb.toString();
	}
	public int countPiece(Color color, Type type) {
		int count = 0;
		for(Rank rank : ranks) {
			count += rank.countPiece(color, type);
		}
		return count;
	}
	public Piece findPiece(String position) {
		char x = position.charAt(0);
		int xPos = x - 'a'; //a면 0, b면 1
		char y = position.charAt(1);
		int yPos = Character.getNumericValue(y);
		//위치 xPos, 8 - yPos 
		return ranks.get(8 - yPos).findPiece(xPos);
	}

/*	public int pieceCount() {
		return whitePawns.size() +whitePiece.size() + blackPawns.size() + blackPiece.size();
	}*/
}

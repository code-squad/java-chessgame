package chess;
//enum을 static으로 import하면 Color.WHITE 라고 안 쓰고 WHITE만 써도 됨
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pieces.Piece;
import utils.StringUtils;

public class BoardTest {
	Board board;

	@Before
	public void setUp() {
		board = new Board();
	}

	//테스트에서 어떨 때 예외가 발생하나?
	@Test
	public void create() throws Exception {
		//이렇게 여러 번 써도 중복이 아님. "white"라고 하드코딩하면 수정사항이 생겼을 때 하나하나 바꿔야하고
		//안 바꾸고 넘어가도 모르지만, enum을 쓰면 고치지 않은 부분에서 에러가 나기 때문에 모를 수 없음. 
		board.initialize();
		//assertEquals(32, board.pieceCount());
		String blankRank = appendNewLine("........");
		assertEquals(
				appendNewLine("RNBQKBNR") + 
				appendNewLine("PPPPPPPP") +
				blankRank + blankRank + blankRank + blankRank +
				appendNewLine("pppppppp") +
				appendNewLine("rnbqkbnr"),
				board.showBoard());
	}
	
	public String appendNewLine(String text) {
		return text + "\n";
	}
	
	@Test
	public void countPiece() {
		board.initialize();
		assertEquals(8, board.countPiece(Piece.Color.BLACK, Piece.Type.PAWN));
		assertEquals(2, board.countPiece(Piece.Color.BLACK, Piece.Type.KNIGHT));
	}

	@Test
	public void findPiece() throws Exception {
		board.initialize();
		assertEquals(Piece.createBlackRook(), board.findPiece("a8"));
		assertEquals(Piece.createBlackRook(), board.findPiece("h8"));
		assertEquals(Piece.createWhiteRook(), board.findPiece("a1"));
		assertEquals(Piece.createWhiteRook(), board.findPiece("h1"));
	}
	
	@Test
	public void move() throws Exception {
		board.initializeEmpty();
		
		String position = "b5";
		Piece piece = Piece.createBlackRook();
		board.move(position, piece);
		
		assertEquals(piece, board.findPiece(position));
		System.out.println(board.showBoard());
	}
	
    @Test
    public void caculcatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());
        addPiece("a7", Piece.createBlackPawn());
        addPiece("c7", Piece.createBlackPawn());
        addPiece("d7", Piece.createBlackBishop());
        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());

        addPiece("f4", Piece.createWhiteKnight());
        addPiece("g4", Piece.createWhiteQueen());
        addPiece("f3", Piece.createWhitePawn());
        addPiece("h3", Piece.createWhitePawn());
        addPiece("f2", Piece.createWhitePawn());
        addPiece("g2", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        assertEquals(20.0, board.caculcatePoint(Piece.Color.BLACK), 0.01);
        assertEquals(19.5, board.caculcatePoint(Piece.Color.WHITE), 0.01);
        System.out.println(board.showBoard());
    }

    @Test
    public void sort() throws Exception {
    	board.initializeEmpty();
    	
    	addPiece("b8", Piece.createBlackKing());
    	addPiece("c8", Piece.createBlackRook());
    	addPiece("d7", Piece.createBlackBishop());
    	addPiece("b6", Piece.createBlackPawn());
    	addPiece("e6", Piece.createBlackQueen());
    	
    	addPiece("f4", Piece.createWhiteKnight());
    	addPiece("g4", Piece.createWhiteQueen());
    	addPiece("f3", Piece.createWhitePawn());
    	addPiece("e1", Piece.createWhiteRook());
    	addPiece("f1", Piece.createWhiteKing());
    	
    	assertEquals("qrnpk", board.sortAsc(Piece.Color.WHITE));
    	assertEquals("QRBPK", board.sortAsc(Piece.Color.BLACK));
    	assertEquals("kpnrq", board.sortDesc(Piece.Color.WHITE));
    	assertEquals("KPBRQ", board.sortDesc(Piece.Color.BLACK));
    	System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }

}
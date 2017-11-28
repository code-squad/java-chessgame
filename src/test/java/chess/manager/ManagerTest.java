package chess.manager;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chess.board.Board;
import chess.board.Position;
import chess.piece.Bishop;
import chess.piece.King;
import chess.piece.Pawn;
import chess.piece.Piece;
import chess.piece.Piece.Color;
import chess.view.ChessResultView;

public class ManagerTest {
	private static final Logger log = LoggerFactory.getLogger(ManagerTest.class);

	@Test
	public void findPiece() {
		Board board = new Board();
		board.create();
		Manager manager = new Manager();
		Piece piece = manager.findPiece(board, Position.create("f1"));
		ChessResultView result = board.result();
		log.debug("현재 board의 모양 {}", result.show());
		assertEquals(piece, Bishop.createWhiteBishop(1));
	}

	@Test
	public void addPiece() {
		Board board = new Board();
		board.emptyBoard();
		Manager manager = new Manager();
		manager.addPiece(board, Position.create("a6"), Bishop.createWhiteBishop(1));
		manager.addPiece(board, Position.create("b2"), Pawn.createWhitePawn(Position.create("b2")));
		manager.addPiece(board, Position.create("h3"), King.create(Color.BLACK, Position.create("h3")));
		ChessResultView result = board.result();
		log.debug("현재 board의 모양 {}", result.show());
		assertEquals("........\n" + "........\n" + "b.......\n" + "........\n" + "........\n" + ".......K\n"
				+ ".p......\n" + "........\n", result.show());
	}

	@Test
	public void movePiece() {
		Board board = new Board();
		board.emptyBoard();
		Manager manager = new Manager();
		manager.addPiece(board, Position.create("b2"), Pawn.createWhitePawn(Position.create("b2")));
		Position sourcePosition = Position.create("b2");
		Position targetPosition = Position.create("b4");
		board.move(sourcePosition, targetPosition);
		ChessResultView result = board.result();
		log.debug("현재 board의 모양 {}", result.show());
		assertEquals("........\n" + "........\n" + "........\n" + "........\n" + ".p......\n" + "........\n"
				+ "........\n" + "........\n", result.show());
		assertEquals(manager.findPiece(board, targetPosition), Pawn.createWhitePawn(Position.create("b2")));
	}
}
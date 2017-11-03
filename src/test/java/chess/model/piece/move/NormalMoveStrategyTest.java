package chess.model.piece.move;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import chess.model.board.Board;
import chess.model.piece.Direction;
import chess.model.piece.InvalidPositionException;
import chess.model.piece.King;
import chess.model.piece.Pawn;
import chess.model.piece.Position;

public class NormalMoveStrategyTest {

	@Test
	public void 이동() {
		MoveStrategy move = new NormalMoveStrategy();
		List<Position> aheadPositions = move.pathWay(new Position("d4"), new Position("d5"), Direction.royaltyDirections());
		assertTrue(aheadPositions.isEmpty());
	}
	
	@Test(expected = InvalidPositionException.class)
	public void 갈수_없는_위치로_이동() {
		MoveStrategy move = new NormalMoveStrategy();
		move.pathWay(new Position("d4"), new Position("d7"), Direction.royaltyDirections());
	}
	
	@Test
	public void 다른_색의_말이_있는_곳으로_이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(King.createBlack(new Position("d4")));
		board.addPiece(Pawn.createWhite(new Position("d5")));
		board.move("d4", "d5");
	}

	@Test(expected = InvalidPositionException.class)
	public void 같은_색의_말이_있는_곳으로_이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(King.createBlack(new Position("d4")));
		board.addPiece(Pawn.createBlack(new Position("d5")));
		board.move("d4", "d5");
	}
}

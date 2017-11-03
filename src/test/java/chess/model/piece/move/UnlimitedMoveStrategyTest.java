package chess.model.piece.move;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import chess.model.board.Board;
import chess.model.piece.Direction;
import chess.model.piece.InvalidPositionException;
import chess.model.piece.Pawn;
import chess.model.piece.Position;
import chess.model.piece.Queen;

public class UnlimitedMoveStrategyTest {

	@Test
	public void 이동() {
		MoveStrategy move = new UnlimitedMoveStrategy();
		List<Position> aheadPositions = move.pathWay(new Position("d4"), new Position("a7"), Direction.royaltyDirections());
		List<Position> positions = Arrays.asList(new Position("b6"),new Position("c5"));
		assertEquals(positions, aheadPositions);
	}
	
	@Test(expected = InvalidPositionException.class)
	public void 갈수_없는_위치로_이동() {
		MoveStrategy move = new UnlimitedMoveStrategy();
		move.pathWay(new Position("d4"), new Position("c6"), Direction.royaltyDirections());
	}
	
	@Test
	public void 다른_색의_말이_있는_곳으로_이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(Queen.createBlack(new Position("d4")));
		board.addPiece(Pawn.createWhite(new Position("a7")));
		board.move("d4", "a7");
	}

	@Test(expected = InvalidPositionException.class)
	public void 같은_색의_말이_있는_곳으로_이동() {
		Board board = new Board();
		board.initBlank();
		board.addPiece(Queen.createBlack(new Position("d4")));
		board.addPiece(Pawn.createBlack(new Position("a7")));
		board.move("d4", "a7");
	}

}

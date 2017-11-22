package bowling.board;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RowTest {

	@Test
	public void 한줄생성() {
		Row row = Row.create(8);
		assertEquals("........", row.show());
	}

}

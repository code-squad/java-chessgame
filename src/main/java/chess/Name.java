package chess;

public enum Name {
	PAWN('P', 'p'), 
	KNIGHT('N', 'n'), 
	ROOK('R', 'r'), 
	BISHOP('B', 'b'), 
	QUEEN('Q', 'q'), 
	KING('K', 'k');
	
	private char whiteRepresentation;
	private char blackRepresentation;
	
	private Name(char whiteRepresentation, char blackRepresentation) {
		this.whiteRepresentation = whiteRepresentation;
		this.blackRepresentation = blackRepresentation;
	}
	
	public char getWhiteRepresentation() {
		return whiteRepresentation;
	}
	
	public char getBlackRepresentation() {
		return blackRepresentation;
	}

}

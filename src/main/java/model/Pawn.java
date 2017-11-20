package model;

public class Pawn implements Piece{
	
	String color;
	
	public Pawn(String color) {
		this.color = color;
	}
	
	@Override
	public String getColor() {
		return color;
	}

	@Override
	public char getRepresentation() {
		return 'p';
	}

}

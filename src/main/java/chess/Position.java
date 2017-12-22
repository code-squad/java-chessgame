package chess;

public class Position {
	public static int getXPos(String position) {
		char x = position.charAt(0);
		int xPos = x - 'a'; //a면 0, b면 1
		return xPos;
	}
	
	public static int getYPos(String position) {
		char y = position.charAt(1);
		int yPos = Character.getNumericValue(y);
		//위치 xPos, 8 - yPos d
		return 8 - yPos;
	}
}

package chess;

public class MoveRule {
	private String direction;
	private int moveDistance = 0;

	public MoveRule(String direction) {
		this.direction = direction;
	}

	public MoveRule(String direction, int moveDistance) {
		this.direction = direction;
		this.moveDistance = moveDistance;
	}

	public String getDirection() {
		return direction;
	}

	public boolean isMove(String moveDirection) {
		return direction.equals(moveDirection);
	}
}
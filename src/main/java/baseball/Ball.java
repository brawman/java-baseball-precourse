package baseball;

public class Ball {
	private final int number;
	private final int position;

	public Ball(int number, int position) {
		if (number < 1 || number > 9) {
			throw new IllegalArgumentException(number + "가 1 ~ 9까지의 범위를 벗어났습니다.");
		}
		if (position < 1 || position > 3) {
			throw new IllegalArgumentException(position + "가 1 ~ 3까지의 위치를 벗어났습니다.");
		}
		this.number = number;
		this.position = position;
	}

	private boolean matchValue(Ball other) {
		return this.number == other.number;
	}

	private boolean matchPosition(Ball other) {
		return this.position == other.position;
	}

	public BallCount play(Ball other) {
		return BallCount.find(this.matchValue(other), this.matchPosition(other));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ball ball = (Ball)o;
		return number == ball.number;
	}

	@Override
	public int hashCode() {
		return number;
	}
}

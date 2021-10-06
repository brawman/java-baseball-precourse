package baseball.domain;

public class Ball {
	public static final String INVALID_NUMBER_SCOPE = "가 1 ~ 9까지의 범위를 벗어났습니다.";
	public static final String INVALID_POSITION_SCOPE = "가 1 ~ 3까지의 위치를 벗어났습니다.";
	private final int number;
	private final int position;

	public Ball(int number, int position) {
		validate(number, position);
		this.number = number;
		this.position = position;
	}

	private void validate(int number, int position) {
		if (number < BaseballRule.BASEBALL_NUMBER_MIN || number > BaseballRule.BASEBALL_NUMBER_MAX) {
			throw new IllegalArgumentException(number + INVALID_NUMBER_SCOPE);
		}
		if (position < BaseballRule.BASEBALL_POSITION_MIN || position > BaseballRule.BASEBALL_POSITION_MAX) {
			throw new IllegalArgumentException(position + INVALID_POSITION_SCOPE);
		}
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

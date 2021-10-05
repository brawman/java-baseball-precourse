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

	public boolean matchValue(Ball other) {
		return other.matchValue(this.number);
	}

	public boolean matchValue(int number) {
		return this.number == number;
	}

	public boolean matchPosition(Ball other) {
		return other.matchPosition(this.position);
	}

	public boolean matchPosition(int position) {
		return this.position == position;
	}
}

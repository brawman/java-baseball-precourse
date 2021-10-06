package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.utils.BallListGenerator;

public class Balls {
	public static final String INVALID_NUMBER_COUNT = "숫자의 갯수가 3이 아닙니다.";
	public static final String DUPLICATE_NUMBER = "중복된 숫자가 있습니다.";
	private final List<Ball> balls;

	public Balls(List<Ball> balls) {
		validate(balls);
		this.balls = balls;
	}

	public Balls(int balls) {
		this(BallListGenerator.generate(balls));
	}

	private void validate(List<Ball> balls) {
		if (balls.size() != BaseballRule.BASEBALL_NUMBER_COUNT) {
			throw new IllegalArgumentException(INVALID_NUMBER_COUNT);
		}

		Set<Ball> union = new HashSet<>(balls);
		if (union.size() != BaseballRule.BASEBALL_NUMBER_COUNT) {
			throw new IllegalArgumentException(DUPLICATE_NUMBER);
		}
	}

	private InningResult play(Ball other) {
		InningResult inningResult = InningResult.of();

		for (Ball ball : this.balls) {
			inningResult.add(ball.play(other));
		}
		return inningResult;
	}

	public InningResult play(Balls other) {
		InningResult inningResult = InningResult.of();

		for (Ball ball : this.balls) {
			inningResult = inningResult.add(other.play(ball));
		}
		return inningResult;
	}
}

package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
	private final List<Ball> balls;

	public Balls(List<Ball> balls) {
		validate(balls);
		this.balls = balls;
	}

	private void validate(List<Ball> balls) {
		if (balls.size() != 3) {
			throw new IllegalArgumentException("숫자의 갯수가 3이 아닙니다.");
		}
		Set<Ball> union = new HashSet<>(balls);
		if (union.size() != 3) {
			throw new IllegalArgumentException("중독된 숫자가 있습니다.");
		}
	}

	public Balls(int balls) {
		if (balls < 100 || balls > 999) {
			throw new IllegalArgumentException(balls + "는 3자리 숫자가 아닙니다.");
		}

		ArrayList<Ball> ballList = new ArrayList<>();
		int index = 1;
		while (balls != 0) {
			ballList.add(new Ball(balls % 10, index));
			balls = balls / 10;
			index += 1;
		}
		validate(ballList);
		this.balls = ballList;
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

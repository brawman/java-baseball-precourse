package baseball.utils;

import java.util.ArrayList;
import java.util.List;

import baseball.domain.Ball;
import baseball.domain.BaseballRule;

public class BallListGenerator {
	private BallListGenerator() {
	}

	public static List<Ball> generate(int number) {
		ArrayList<Ball> ballList = new ArrayList<>();
		int index = BaseballRule.BASEBALL_POSITION_MAX;

		while (number != 0) {
			ballList.add(new Ball(number % 10, index));
			number = number / 10;
			index -= 1;
		}
		return ballList;
	}
}

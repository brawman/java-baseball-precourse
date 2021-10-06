package baseball.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import baseball.utils.BallListGenerator;
import nextstep.utils.Randoms;

public class BaseballGame {
	public static final String INVALID_INPUT_OF_END_RESTART = "종료나 재시작을 위해 올바른 입력을 넣어주세요.";
	private static Balls balls;
	private static boolean isEnd;

	private BaseballGame() {
	}

	private static List<Ball> makeBalls() {
		int i = BaseballRule.BASEBALL_POSITION_MIN;
		ArrayList<Ball> balls = new ArrayList<>();

		for (int number : makeRandomBallNumbers()) {
			balls.add(new Ball(number, i++));
		}
		return balls;
	}

	private static List<Integer> makeRandomBallNumbers() {
		Set<Integer> union = new LinkedHashSet<>();

		while (union.size() < 3) {
			union.add(Randoms.pickNumberInRange(BaseballRule.BASEBALL_NUMBER_MIN, BaseballRule.BASEBALL_NUMBER_MAX));
		}
		return new ArrayList<>(union);
	}

	public static boolean isStop(String gameContinue) {
		if (gameContinue.equals(BaseballRule.BASEBALL_STOP_CONDITION)) {
			return true;
		}

		if (gameContinue.equals(BaseballRule.BASEBALL_RESTART_CONDITION)) {
			ready();
			return false;
		}
		throw new IllegalArgumentException(INVALID_INPUT_OF_END_RESTART);
	}

	public static void ready() {
		isEnd = false;
		balls = new Balls(makeBalls());
	}

	public static InningResult play(String numbers) {
		InningResult inningResult = balls.play(new Balls(BallListGenerator.generate(Integer.parseInt(numbers))));

		if (inningResult.isThreeStrike()) {
			isEnd = true;
		}
		return inningResult;
	}

	public static boolean isEnd() {
		return isEnd;
	}
}

package baseball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import nextstep.utils.Randoms;

public class BaseBallGame {
	private static Balls balls;
	private static boolean isEnd;

	private static List<Ball> makeBalls() {
		int i = 1;
		ArrayList<Ball> balls = new ArrayList<>();

		for (int number : makeRandomBallNumbers()) {
			balls.add(new Ball(number, i++));
		}

		return balls;
	}

	private static List<Integer> makeRandomBallNumbers() {
		Set<Integer> union = new LinkedHashSet<>();
		while (union.size() < 3) {
			union.add(Randoms.pickNumberInRange(1, 9));
		}
		return new ArrayList<>(union);
	}

	public static boolean stopOrRestart(String gameContinue) {
		if (gameContinue.equals("1")) {
			ready();
			return false;
		}

		if (gameContinue.equals("2")) {
			return true;
		}

		throw new IllegalArgumentException("종료나 재시작을 위해 올바른 입력을 넣어주세요.");
	}

	public static void ready() {
		isEnd = false;

		balls = new Balls(makeBalls());
	}

	public static InningResult play(String numbers) {
		InningResult inningResult = balls.play(new Balls(Integer.parseInt(numbers)));
		if (inningResult.isThreeStrike()) {
			isEnd = true;
		}
		return inningResult;
	}

	public static boolean isEnd() {
		return isEnd;
	}
}

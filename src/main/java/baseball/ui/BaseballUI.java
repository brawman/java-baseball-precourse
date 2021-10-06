package baseball.ui;

import baseball.domain.InningResult;
import nextstep.utils.Console;

public class BaseballUI {
	public static final String QUESTION_OF_USER_NUMBER = "숫자를입력해주세요 : ";
	public static final String GAME_OVER_MESSAGE = "3개의숫자를모두맞히셨습니다!게임 끝";
	public static final String RESTART_OR_END_MESSAGE = "게임을새로시작하려면1,종료하려면2를입력하세요.";
	public static final String STRIKE = "스트라이크 ";
	public static final String BALL = "볼";
	public static final String NOTHING = "낫싱";

	private BaseballUI() {
	}

	public static String userGameStrategy() {
		System.out.print(QUESTION_OF_USER_NUMBER);
		return Console.readLine();
	}

	public static String isGameContinue() {
		System.out.println(GAME_OVER_MESSAGE);
		System.out.println(RESTART_OR_END_MESSAGE);
		return Console.readLine();
	}

	public static void drawGameResult(InningResult result) {
		StringBuilder stringBuilder = new StringBuilder();

		if (result.strike() != 0) {
			stringBuilder.append(result.strike() + STRIKE);
		}
		if (result.ball() != 0) {
			stringBuilder.append(result.ball() + BALL);
		}
		if (result.isNothing()) {
			stringBuilder.append(NOTHING);
		}
		System.out.println(stringBuilder);
	}
}

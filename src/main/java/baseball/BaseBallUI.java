package baseball;

import nextstep.utils.Console;

public class BaseBallUI {
	public static String userGameStrategy() {
		System.out.print("숫자를입력해주세요 : ");
		return Console.readLine();
	}

	public static String isGameContinue() {
		System.out.println("3개의숫자를모두맞히셨습니다!게임 끝");
		System.out.println("게임을새로시작하려면1,종료하려면2를입력하세요.");
		return Console.readLine();
	}

	public static void drawGameResult(InningResult result) {
		StringBuilder stringBuilder = new StringBuilder();
		if (result.strike() != 0) {
			stringBuilder.append(result.strike() + "스트라이크 ");
		}
		if (result.ball() != 0) {
			stringBuilder.append(result.ball() + "볼");
		}
		if (result.isNothing()) {
			stringBuilder.append("낫싱");
		}
		System.out.println(stringBuilder);
	}
}

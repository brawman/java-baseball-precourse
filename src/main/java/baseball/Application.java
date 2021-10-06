package baseball;

import baseball.domain.BaseballGame;
import baseball.domain.InningResult;
import baseball.ui.BaseballUI;

public class Application {
	private static void playGameWithExceptionHandler() {
		try {
			InningResult result = BaseballGame.play(BaseballUI.userGameStrategy());
			BaseballUI.drawGameResult(result);
		} catch(IllegalArgumentException exception) {
			System.err.println("[ERROR]" + exception.getMessage());
		}
	}

	public static void main(String[] args) {
		BaseballGame.ready();
		while (!BaseballGame.isEnd()
			|| BaseballGame.stopOrRestart(BaseballUI.isGameContinue()) == BaseballGame.RESTART) {
			playGameWithExceptionHandler();
		}
	}
}

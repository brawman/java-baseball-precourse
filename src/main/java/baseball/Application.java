package baseball;

import baseball.domain.BaseballGame;
import baseball.domain.InningResult;
import baseball.ui.BaseballUI;

public class Application {
	public static void main(String[] args) {
		BaseballGame.ready();
		while (!BaseballGame.isEnd()
			|| BaseballGame.stopOrRestart(BaseballUI.isGameContinue()) == BaseballGame.RESTART) {
			InningResult result = BaseballGame.play(BaseballUI.userGameStrategy());
			BaseballUI.drawGameResult(result);
		}
	}
}

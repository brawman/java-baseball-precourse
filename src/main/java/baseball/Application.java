package baseball;

public class Application {
	public static void main(String[] args) {
		BaseBallGame.ready();
		while (true) {
			InningResult result = BaseBallGame.play(BaseBallUI.userGameStrategy());
			BaseBallUI.drawGameResult(result);
			if (BaseBallGame.isEnd() && BaseBallGame.stopOrRestart(BaseBallUI.isGameContinue())) {
				break;
			}
		}
	}
}

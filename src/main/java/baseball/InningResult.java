package baseball;

public class InningResult {

	private int strikeCount;
	private int ballCount;

	private InningResult() {
		this.strikeCount = 0;
		this.ballCount = 0;
	}

	public InningResult(int strikeCount, int ballCount) {
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public static InningResult of() {
		return new InningResult();
	}

	public int strike() {
		return this.strikeCount;
	}

	public int ball() {
		return this.ballCount;
	}

	public boolean isNothing() {
		return this.strikeCount == 0 && this.ballCount == 0;
	}

	public InningResult add(InningResult play) {
		return new InningResult(this.strikeCount + play.strikeCount, this.ballCount + play.ballCount);
	}

	public void add(BallCount play) {
		if (play.isStrike()) {
			this.strikeCount += 1;
		}

		if (play.isBall()) {
			this.ballCount += 1;
		}
	}
}

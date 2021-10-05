package baseball;

public enum BallCount {
	STRIKE(true, true),
	BALL(true, false),
	NOTHING(false, false);

	private final boolean isSameNumber;
	private final boolean isSamePosition;

	BallCount(boolean isSameNumber, boolean isSamePosition) {
		this.isSameNumber = isSameNumber;
		this.isSamePosition = isSamePosition;
	}

	public static BallCount find(boolean isSameNumber, boolean isSamePosition) {
		for (BallCount ballCount : BallCount.values()) {
			if (ballCount.match(isSameNumber, isSamePosition)) {
				return ballCount;
			}
		}
		throw new IllegalArgumentException("적절한 볼카운트 결과를 찾지 못했습니다.");
	}

	public boolean match(boolean isSameNumber, boolean isSamePosition) {
		return this.isSameNumber == isSameNumber && this.isSamePosition == isSamePosition;
	}
}
package baseball.domain;

public enum BallCount {
	STRIKE(true, true) {
		@Override
		public boolean match(boolean isSameNumber, boolean isSamePosition) {
			return this.isSameCondition(isSameNumber, isSamePosition);
		}
	},
	BALL(true, false) {
		@Override
		public boolean match(boolean isSameNumber, boolean isSamePosition) {
			return this.isSameCondition(isSameNumber, isSamePosition);
		}
	},
	NOTHING(false, false) {
		@Override
		public boolean match(boolean isSameNumber, boolean isSamePosition) {
			return this.isSameNumber == isSameNumber;
		}
	};

	public static final String NOT_FOUND_BALL_COUNT = "적절한 볼카운트 결과를 찾지 못했습니다.";
	protected final boolean isSameNumber;
	protected final boolean isSamePosition;

	BallCount(boolean isSameNumber, boolean isSamePosition) {
		this.isSameNumber = isSameNumber;
		this.isSamePosition = isSamePosition;
	}

	public static BallCount find(boolean isSameNumber, boolean isSamePosition) {
		int index = 0;
		BallCount[] ballCounts = BallCount.values();

		while (!ballCounts[index].match(isSameNumber, isSamePosition) && index < ballCounts.length) {
			index += 1;
		}
		if (index >= ballCounts.length) {
			throw new IllegalArgumentException(NOT_FOUND_BALL_COUNT);
		}
		return ballCounts[index];
	}

	protected boolean isSameCondition(boolean isSameNumber, boolean isSamePosition) {
		return this.isSameNumber == isSameNumber && this.isSamePosition == isSamePosition;
	}

	abstract public boolean match(boolean isSameNumber, boolean isSamePosition);

	public boolean isStrike() {
		return this == STRIKE;
	}

	public boolean isBall() {
		return this == BALL;
	}
}
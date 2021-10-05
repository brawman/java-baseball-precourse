package baseball;

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

	protected final boolean isSameNumber;
	protected final boolean isSamePosition;

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
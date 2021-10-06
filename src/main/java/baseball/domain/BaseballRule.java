package baseball.domain;

public class BaseballRule {
	public final static int BASEBALL_NUMBER_MIN = 1;
	public final static int BASEBALL_NUMBER_MAX = 9;
	public final static int BASEBALL_POSITION_MIN = 1;
	public final static int BASEBALL_POSITION_MAX = 3;
	public final static int BASEBALL_NUMBER_COUNT = BASEBALL_POSITION_MAX;
	public final static String BASEBALL_RESTART_CONDITION = "1";
	public final static String BASEBALL_STOP_CONDITION = "2";

	private BaseballRule() {
	}
}

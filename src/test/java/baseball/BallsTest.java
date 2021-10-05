package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallsTest {
	@Test
	@DisplayName("숫자는 3개로 이뤄져있다.")
	void numberCount() {
		assertThatThrownBy(() -> new Balls(12)).isExactlyInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new Balls(1234)).isExactlyInstanceOf(
			IllegalArgumentException.class);
	}

	@Test
	@DisplayName("숫자의 중복이 허용되지 않는다.")
	void DoNotOverlap() {
		assertThatThrownBy(() -> new Balls(111)).isExactlyInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new Balls(112)).isExactlyInstanceOf(
			IllegalArgumentException.class);
	}

	@Test
	@DisplayName("3스트라이크")
	void inning1() {
		Balls balls = new Balls(123);
		InningResult inningResult = balls.play(new Balls(123));
		assertThat(inningResult.strike()).isEqualTo(3);
	}

	@Test
	@DisplayName("1스트라이크, 1볼")
	void inning2() {
		Balls balls = new Balls(123);
		InningResult inningResult = balls.play(new Balls(134));
		assertThat(inningResult.strike()).isEqualTo(1);
		assertThat(inningResult.ball()).isEqualTo(1);
	}

	@Test
	@DisplayName("3볼")
	void inning3() {
		Balls balls = new Balls(123);
		InningResult inningResult = balls.play(new Balls(312));
		assertThat(inningResult.strike()).isEqualTo(0);
		assertThat(inningResult.ball()).isEqualTo(3);
	}

	@Test
	@DisplayName("낫싱")
	void inning4() {
		Balls balls = new Balls(123);
		InningResult inningResult = balls.play(new Balls(456));
		assertThat(inningResult.strike()).isEqualTo(0);
		assertThat(inningResult.ball()).isEqualTo(0);
		assertThat(inningResult.isNothing()).isTrue();
	}
}

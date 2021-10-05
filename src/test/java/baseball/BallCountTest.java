package baseball;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallCountTest {
	@Test
	@DisplayName("스트라이크")
	void strike() {
		Assertions.assertThat(BallCount.find(true, true)).isEqualTo(BallCount.STRIKE);
	}

	@Test
	@DisplayName("볼")
	void ball() {
		assertThat(BallCount.find(true, false)).isEqualTo(BallCount.BALL);
	}

	@Test
	@DisplayName("낫싱")
	void nothing() {
		assertThat(BallCount.find(false, false)).isEqualTo(BallCount.NOTHING);
	}
}

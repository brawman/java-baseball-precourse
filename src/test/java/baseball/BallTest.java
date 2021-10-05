package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {
	@Test
	@DisplayName("숫자의 범위는 1 ~ 9")
	void numberScope() {
		assertThatThrownBy(() -> new Ball(0, 1)).isExactlyInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new Ball(10, 1)).isExactlyInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("위치의 범위는 1 ~ 3")
	void positionScope() {
		assertThatThrownBy(() -> new Ball(1, 0)).isExactlyInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new Ball(9, 4)).isExactlyInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("스트라이크")
	void strike() {
		Ball ball = new Ball(2, 1);
		assertThat(ball.play(new Ball(2, 1))).isEqualTo(BallCount.STRIKE);
	}

	@Test
	@DisplayName("볼")
	void ball() {
		Ball ball = new Ball(2, 1);
		assertThat(ball.play(new Ball(2, 2))).isEqualTo(BallCount.BALL);
	}

	@Test
	@DisplayName("낫싱")
	void nothing() {
		Ball ball = new Ball(2, 1);
		assertThat(ball.play(new Ball(1, 3))).isEqualTo(BallCount.NOTHING);
	}
}

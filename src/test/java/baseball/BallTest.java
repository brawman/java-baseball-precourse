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
	@DisplayName("같은 값인지 확인")
	void matchValue() {
		Ball ball = new Ball(2, 1);
		assertThat(ball.matchValue(new Ball(1, 1))).isFalse();
		assertThat(ball.matchValue(new Ball(2, 1))).isTrue();
	}

	@Test
	@DisplayName("같은 위치인지 확인")
	void matchPositon() {
		Ball ball = new Ball(2, 1);
		assertThat(ball.matchPosition(new Ball(2, 2))).isFalse();
		assertThat(ball.matchPosition(new Ball(2, 1))).isTrue();
	}
}

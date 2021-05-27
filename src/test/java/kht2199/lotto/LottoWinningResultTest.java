package kht2199.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import kht2199.lotto.data.Lotto;

class LottoWinningResultTest {

	@ParameterizedTest
	@DisplayName("당첨번호와 단일 로또의 일치 갯수")
	@MethodSource("calculateSource")
	void calculate(Lotto winningResult, Lotto lotto, int matched) {
		LottoWinningResult result = new LottoWinningResult(winningResult);
		assertThat(result.calculateMatched(winningResult, lotto))
			.isEqualTo(matched);
	}

	static Stream<Arguments> calculateSource() {
		Lotto winningResult = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		return Stream.of(
			Arguments.of(winningResult, new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6),
			Arguments.of(winningResult, new Lotto(List.of(1, 2, 3, 4, 5, 7)), 5),
			Arguments.of(winningResult, new Lotto(List.of(7, 8, 9, 10, 11, 12)), 0)
		);
	}
}
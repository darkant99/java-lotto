package lotto.domain;

import lotto.matcher.LottoMatcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatcherTest {

    @ParameterizedTest
    @MethodSource("provideMatchCount")
    @DisplayName("등수 찾기 테스트")
    void findRankingTest(int count, boolean matchBonusBall, LottoMatcher lottoMatcher) {
        LottoMatcher findLottoMatcher = LottoMatcher.findRanking(count, matchBonusBall);
        assertThat(findLottoMatcher).isEqualTo(lottoMatcher);
    }

    private static Stream<Arguments> provideMatchCount() {
        return Stream.of(
                Arguments.of(3, false, LottoMatcher.FIVE_PLACE),
                Arguments.of(4, false, LottoMatcher.FOURTH_PLACE),
                Arguments.of(5, false, LottoMatcher.THIRD_PLACE),
                Arguments.of(5, true, LottoMatcher.SECOND_PLACE),
                Arguments.of(6, false, LottoMatcher.FIRST_PLACE)
        );
    }
}
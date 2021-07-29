package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoListTest {
    @DisplayName("newAuto Test")
    @ValueSource(ints = {
            0, 10, 100
    })
    @ParameterizedTest
    void newAutoTest(int size) {
        assertThat(
                LottoList.newAuto(size).size()
        ).isEqualTo(size);
    }

    @ValueSource(ints = {
            0, 10, 100
    })
    @DisplayName("statistics Test")
    @ParameterizedTest
    void statisticsTest(int size) {
        assertThat(
                LottoList.newAuto(size)
                        .statistics(Lotto.newAuto())
                        .totalSize()
        ).isEqualTo(size);
    }
}
package lotto.view;

import lotto.domain.Money;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    @ValueSource(ints = {
            0,
            1000,
            10000
    })
    @ParameterizedTest
    public void inputMoney(int intMoney) {
        Money expertMoney = new Money(intMoney);
        assertThat(new FakeInputView(intMoney).inputMoney())
                .isEqualTo(expertMoney);
    }
}
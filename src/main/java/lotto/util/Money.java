package lotto.util;

import lotto.exception.NumberNotSupportException;
import lotto.exception.OutOfRangeException;

import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public final class Money extends Number {
    private static final int MIN_VALUE = 0;

    private final Number value;
    public Money(Number value) {
        this.value = value;

        validNumber();
    }

    private void validNumber() {
        if (longValue() < MIN_VALUE) {
            throw new OutOfRangeException("돈은 음수일 수 없습니다.");
        }
    }

    @Override
    public int intValue() {
        return value.intValue();
    }

    @Override
    public long longValue() {
        return value.longValue();
    }

    @Override
    public float floatValue() {
        return value.floatValue();
    }

    @Override
    public double doubleValue() {
        return value.doubleValue();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

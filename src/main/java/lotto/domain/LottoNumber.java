package lotto.domain;

import lotto.exception.OutOfRangeException;

import java.util.Objects;

public final class LottoNumber extends Number {
    private final Number value;

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    public LottoNumber(Number value) {
        this.value = value;

        validNumber();
    }

    private void validNumber() {
        int value = intValue();
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new OutOfRangeException();
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
    public boolean equals(Object compareValue) {
        if (this == compareValue) return true;
        if (compareValue == null || getClass() != compareValue.getClass()) return false;
        LottoNumber that = (LottoNumber) compareValue;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

package practice.hexagonal.lotto.lotto.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
public class LottoNumber {

    // 예제 로또번호는 46번부터 시작해서 90번에서 끝난다.
    private static final Integer MIN_NUMBER = 46;
    private static final Integer MAX_NUMBER = 90;

    private final Integer number;

    public boolean isValidRange() {
        return (number >= MIN_NUMBER) && (number <= MAX_NUMBER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(getNumber(), that.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}

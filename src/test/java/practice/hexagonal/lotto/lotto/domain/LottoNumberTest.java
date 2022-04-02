package practice.hexagonal.lotto.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("LottoNumber 테스트")
class LottoNumberTest {

    LottoNumber underLottoNumber = new LottoNumber(45);
    LottoNumber overLottoNumber = new LottoNumber(91);
    LottoNumber validLottoNumber = new LottoNumber(66);
    
    @Test
    @DisplayName("로또 숫자가 범위보다 작으면 false 반환")
    void under_lotto_number_range_then_return_false() {
        // when
        boolean result = underLottoNumber.isValidRange();

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("로또 숫자가 범위보다 크면 false 반환")
    void over_lotto_number_range_then_return_false() {
        // when
        boolean result = overLottoNumber.isValidRange();

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("로또 숫자가 범위 내면 true 반환")
    void valid_lotto_number_range_then_return_true() {
        // when
        boolean result = validLottoNumber.isValidRange();

        // then
        assertThat(result).isTrue();
    }
}
package practice.hexagonal.lotto.lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@DisplayName("LottoNumbers 테스트")
class LottoNumbersTest {

    // 번호가 중복되는 로또(번호 수가 부족)
    LottoNumbers duplicatedLottoNumbers = new LottoNumbers(Arrays.asList(new LottoNumber(46), new LottoNumber(46),
            new LottoNumber(60), new LottoNumber(66), new LottoNumber(78), new LottoNumber(86)));

    // 번호 수가 부족한 로또
    LottoNumbers lessLottoNumbers = new LottoNumbers(Arrays.asList(new LottoNumber(46), new LottoNumber(47)));
    
    // 번호 수가 초과된 로또
    LottoNumbers moreLottoNumbers = new LottoNumbers(Arrays.asList(new LottoNumber(46), new LottoNumber(52),
            new LottoNumber(60), new LottoNumber(66), new LottoNumber(78), new LottoNumber(86), new LottoNumber(88)));

    // 번호 수, 범위가 정상적인 로또
    LottoNumbers validLottoNumbers = new LottoNumbers(Arrays.asList(new LottoNumber(46), new LottoNumber(52),
            new LottoNumber(60), new LottoNumber(66), new LottoNumber(78), new LottoNumber(86)));

    // 로또의 범위가 정상적이지 않음(미만 포함)
    LottoNumbers underRangeLottoNumbers = new LottoNumbers(Arrays.asList(new LottoNumber(45), new LottoNumber(52),
            new LottoNumber(60), new LottoNumber(66), new LottoNumber(78), new LottoNumber(86)));

    // 로또의 범위가 정상적이지 않음(초과 포함)
    LottoNumbers overRangeLottoNumbers = new LottoNumbers(Arrays.asList(new LottoNumber(45), new LottoNumber(52),
            new LottoNumber(60), new LottoNumber(66), new LottoNumber(78), new LottoNumber(92)));

    @Test
    @DisplayName("로또 숫자 개수가 유효하지 않으면 false 반환(미만)")
    void less_lotto_count_then_return_false_1() {
        // when
        boolean result = duplicatedLottoNumbers.isValidCounts();

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("로또 숫자 개수가 유효하지 않으면 false 반환(미만)")
    void less_lotto_count_then_return_false_2() {
        // when
        boolean result = lessLottoNumbers.isValidCounts();

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("로또 숫자 개수가 유효하지 않으면 false 반환(초과)")
    void more_lotto_count_then_return_false() {
        // when
        boolean result = moreLottoNumbers.isValidCounts();

        // then
        assertThat(result).isFalse();
    }
    
    @Test
    @DisplayName("로또 숫자 개수가 유효하면 true 반환")
    void valid_lotto_count_then_return_true() {
        // when
        boolean result = validLottoNumbers.isValidCounts();

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("로또 숫자 범위가 유효하지 않으면 false 반환(미만)")
    void under_range_lotto_number_then_return_false() {
        // when
        boolean result = underRangeLottoNumbers.isValidNumbers();

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("로또 숫자 범위가 유효하지 않으면 false 반환(초과)")
    void over_range_lotto_number_then_return_false() {
        // when
        boolean result = overRangeLottoNumbers.isValidNumbers();

        // then
        assertThat(result).isFalse();
    }
    
    @Test
    @DisplayName("로또 숫자 범위가 유효하면 true 반환")
    void valid_range_lotto_number_then_return_true() {
        // when
        boolean result = validLottoNumbers.isValidNumbers();

        // then
        assertThat(result).isTrue();
    }
}
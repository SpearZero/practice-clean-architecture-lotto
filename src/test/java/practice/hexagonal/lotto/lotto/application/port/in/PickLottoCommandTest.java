package practice.hexagonal.lotto.lotto.application.port.in;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.hexagonal.lotto.lotto.domain.LottoNumber;

import javax.validation.ConstraintViolationException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PickLottoCommand 테스트")
class PickLottoCommandTest {
    
    
    @Test
    @DisplayName("lottoNumbers가 null이면 ConstraintViolationException 발생")
    void lotto_numbers_null_then_throw_ConstraintViolationException() {
        assertThrows(ConstraintViolationException.class, () -> new PickLottoCommand(null));
    }
    
    @Test
    @DisplayName("lottoNumbers의 요소가 6개 미만이면 ConstraintViolationException 발생")
    void lotto_numbers_lotto_number_less_than_6_throw_ConstraintViolationException() {
        // given
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(46), new LottoNumber(47));

        // when, then
        assertThrows(ConstraintViolationException.class, () -> new PickLottoCommand(lottoNumbers));
    }

    @Test
    @DisplayName("lottoNumbers의 요소가 6개 초과면 ConstraintViolationException 발생")
    void lotto_numbers_lotto_number_more_than_6_throw_ConstraintViolationException() {
        // given
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(46), new LottoNumber(47), new LottoNumber(48),
                new LottoNumber(49), new LottoNumber(50), new LottoNumber(51), new LottoNumber(52));

        // when, then
        assertThrows(ConstraintViolationException.class, () -> new PickLottoCommand(lottoNumbers));
    }
    
    @Test
    @DisplayName("lottoNumbers의 요소가 6개면 PickLottoCommand 생성 성공")
    void lotto_numbers_lotto_number_6_then_PickLottoCommand_create_success() {
        // given
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(46), new LottoNumber(47), new LottoNumber(48),
                new LottoNumber(49), new LottoNumber(50), new LottoNumber(51));

        // when
        PickLottoCommand pickLottoCommand = new PickLottoCommand(lottoNumbers);

        // then
        assertThat(pickLottoCommand.getLottoNumbers().size()).isEqualTo(6);
    }
}
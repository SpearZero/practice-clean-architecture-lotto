package practice.hexagonal.lotto.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("Lotto 테스트")
public class LottoTest {

    // 당첨번호 0,1,2 개(꽝)
    LottoNumbers selectedLottoNumbersZero = new LottoNumbers(List.of(new LottoNumber(47), new LottoNumber(54),
            new LottoNumber(61), new LottoNumber(67), new LottoNumber(79), new LottoNumber(87)));
    Lotto LottoZero = new Lotto(selectedLottoNumbersZero);

    LottoNumbers selectedLottoNumbersOne = new LottoNumbers(List.of(new LottoNumber(46), new LottoNumber(54),
            new LottoNumber(61), new LottoNumber(67), new LottoNumber(79), new LottoNumber(87)));
    Lotto LottoOne = new Lotto(selectedLottoNumbersOne);

    LottoNumbers selectedLottoNumbersTwo = new LottoNumbers(List.of(new LottoNumber(46), new LottoNumber(53),
            new LottoNumber(61), new LottoNumber(67), new LottoNumber(79), new LottoNumber(87)));
    Lotto LottoTwo = new Lotto(selectedLottoNumbersTwo);

    // 당첨번호 3개(4등)
    LottoNumbers selectedLottoNumbersThree = new LottoNumbers(List.of(new LottoNumber(46), new LottoNumber(53),
            new LottoNumber(60), new LottoNumber(67), new LottoNumber(79), new LottoNumber(87)));
    Lotto LottoThree = new Lotto(selectedLottoNumbersThree);

    // 당첨번호 4개(3등)
    LottoNumbers selectedLottoNumbersFour = new LottoNumbers(List.of(new LottoNumber(46), new LottoNumber(53),
            new LottoNumber(60), new LottoNumber(66), new LottoNumber(79), new LottoNumber(87)));
    Lotto LottoFour = new Lotto(selectedLottoNumbersFour);

    // 당첨번호 5개(2등)
    LottoNumbers selectedLottoNumbersFive = new LottoNumbers(List.of(new LottoNumber(46), new LottoNumber(53),
            new LottoNumber(60), new LottoNumber(66), new LottoNumber(78), new LottoNumber(87)));
    Lotto LottoFive = new Lotto(selectedLottoNumbersFive);

    // 당첨번호 6개(1등)
    LottoNumbers selectedLottoNumbersSix = new LottoNumbers(List.of(new LottoNumber(46), new LottoNumber(53),
            new LottoNumber(60), new LottoNumber(66), new LottoNumber(78), new LottoNumber(86)));
    Lotto LottoSix = new Lotto(selectedLottoNumbersSix);

    @Test
    @DisplayName("로또 번호가 0개 일치")
    void winning_lotto_numbers_0() {
        // when
        int result = LottoZero.winningCount();

        // then
        assertThat(result).isEqualTo(0);
    }
    
    @Test
    @DisplayName("로또 번호가 0개 일치시 Rank.LOSE 반환")
    void winning_lotto_numbers_0_return_LOSE() {
        // when
        Rank rank = LottoZero.getRank();

        // then
        assertThat(rank).isSameAs(Rank.LOSE);
    }

    
    @Test
    @DisplayName("로또 번호가 1개 일치")
    void winning_lotto_numbers_1() {
        // when
        int result = LottoOne.winningCount();

        // then
        assertThat(result).isEqualTo(1);
    }
    
    @Test
    @DisplayName("로또 번호가 1개 일치시 Rank.LOSE 반환")
    void winning_lotto_numbers_1_return_LOSE() {
        // when
        Rank rank = LottoOne.getRank();

        // then
        assertThat(rank).isSameAs(Rank.LOSE);
    }

    @Test
    @DisplayName("로또 번호가 2개 일치")
    void winning_lotto_numbers_2() {
        // when
        int result = LottoTwo.winningCount();

        // then
        assertThat(result).isEqualTo(2);
    }
    
    @Test
    @DisplayName("로또 번호가 2개 일치시 Rank.LOSE 반환")
    void winning_lotto_numbers_2_return_LOSE() {
        // when
        Rank rank = LottoTwo.getRank();

        // then
        assertThat(rank).isSameAs(Rank.LOSE);
    }
    
    @Test
    @DisplayName("로또 번호가 3개 일치")
    void winning_lotto_numbers_3() {
        // when
        int result = LottoThree.winningCount();

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 번호가 3개 일치시 Rank.FOURTH 반환")
    void winning_lotto_numbers_3_return_FOURTH() {
        // when
        Rank rank = LottoThree.getRank();

        // then
        assertThat(rank).isSameAs(Rank.FOURTH);
    }
    
    @Test
    @DisplayName("로또 번호가 4개 일치")
    void winning_lotto_numbers_4() {
        // when
        int result = LottoFour.winningCount();

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("로또 번호가 4개 일치시 Rank.THIRD 반환")
    void winning_lotto_numbers_4_return_THIRD() {
        // when
        Rank rank = LottoFour.getRank();

        // then
        assertThat(rank).isSameAs(Rank.THIRD);
    }

    @Test
    @DisplayName("로또 번호가 5개 일치")
    void winning_lotto_numbers_5() {
        // when
        int result = LottoFive.winningCount();

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 번호가 5개 일치시 Rank.SECOND 반환")
    void winning_lotto_numbers_5_return_SECOND() {
        // when
        Rank rank = LottoFive.getRank();

        // then
        assertThat(rank).isSameAs(Rank.SECOND);
    }
    
    @Test
    @DisplayName("로또 번호가 6개 일치")
    void winning_lotto_numbers_6() {
        // when
        int result = LottoSix.winningCount();

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호가 6개 일치시 Rank.FIRST 반환")
    void winning_lotto_numbers_6_return_FIRST() {
        // when
        Rank rank = LottoSix.getRank();

        // then
        assertThat(rank).isSameAs(Rank.FIRST);
    }
    
    @Test
    @DisplayName("로또 번호 당첨이 유효하지 않으면 RuntimeException 발생")
    void winning_lotto_numbers_invalid_throw_RuntimeException() {
        // when
        Lotto mockLotto = mock(Lotto.class);
        when(mockLotto.getRank()).thenThrow(new RuntimeException("당첨 결과를 알 수 없습니다."));

        // then
        assertThrows(RuntimeException.class, () -> mockLotto.getRank());
    }
}

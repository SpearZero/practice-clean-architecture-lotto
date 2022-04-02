package practice.hexagonal.lotto.lotto.domain;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Lotto {

    // 예제이므로 당첨 번호 고정, 범위는 46~90
    private static final LottoNumbers winningLottoNumbers = new LottoNumbers(List.of(new LottoNumber(46), new LottoNumber(53),
            new LottoNumber(60), new LottoNumber(66), new LottoNumber(78), new LottoNumber(86)));

    private final LottoNumbers selectedLottoNumbers;

    public Integer winningCount() {
        List<LottoNumber> winningNumbers = winningLottoNumbers.getLottoNumbers();

        return Math.toIntExact(selectedLottoNumbers.getLottoNumbers().stream()
                .filter(winningNumbers::contains).count());
    }

    public Rank getRank() {
        Integer count = winningCount();

        if (0 == count || 1 == count || 2 == count) {
            return Rank.LOSE;
        }

        if (3 == count) {
            return Rank.FOURTH;
        }

        if (4 == count) {
            return Rank.THIRD;
        }

        if (5 == count) {
            return Rank.SECOND;
        }

        if (6 == count) {
            return Rank.FIRST;
        }

        throw new RuntimeException("당첨 결과를 알 수 없습니다.");
    }
}

package practice.hexagonal.lotto.lotto.domain;

import lombok.Getter;
import lombok.NonNull;

import java.util.Collections;
import java.util.List;

@Getter
public class LottoNumbers {

    private static final Integer NUMBERS_COUNT = 6;

    // 보너스 번호는 없다고 가정
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(@NonNull List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean isValidCounts() {
        return NUMBERS_COUNT == Math.toIntExact(lottoNumbers.stream().distinct().count());
    }

    public boolean isValidNumbers() {
        return lottoNumbers.stream().allMatch(LottoNumber::isValidRange);
    }
}

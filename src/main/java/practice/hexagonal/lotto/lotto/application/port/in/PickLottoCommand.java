package practice.hexagonal.lotto.lotto.application.port.in;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import practice.hexagonal.lotto.common.SelfValidating;
import practice.hexagonal.lotto.lotto.domain.LottoNumber;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@EqualsAndHashCode(callSuper = false)
public class PickLottoCommand extends SelfValidating<PickLottoCommand> {

    @NotNull
    @Size(min = 6, max = 6)
    private final List<LottoNumber> lottoNumbers;

    public PickLottoCommand(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.validateSelf();
    }
}

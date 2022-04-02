package practice.hexagonal.lotto.lotto.domain;

public enum Rank {
    FIRST(1, 2_000_000_000L),
    SECOND(2, 50_000_000L),
    THIRD(3, 1_500_000L),
    FOURTH(4, 50_000L),
    LOSE(5, 0L);

    private final Integer rank;
    private final Long money;

    Rank(Integer rank, Long money) {
        this.rank = rank;
        this.money = money;
    }
}

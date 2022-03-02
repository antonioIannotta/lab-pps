package lab01.tdd;

public abstract class AbstractSelectStrategyFactory {
    public abstract SelectStrategy createSelectStrategy(String strategy);
}

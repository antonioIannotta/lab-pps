package lab01.tdd;

public class StrategyProducer {

    public static AbstractSelectStrategyFactory getFactory(){
        return new SelectStrategyFactory();
    }
}

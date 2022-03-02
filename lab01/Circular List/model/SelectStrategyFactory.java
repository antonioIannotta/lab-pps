package lab01.tdd;

public class SelectStrategyFactory extends AbstractSelectStrategyFactory{
    @Override
    public SelectStrategy createSelectStrategy(String strategy) {
        if(strategy.equalsIgnoreCase("even")){
            return new SelectWithEvenStrategy();
        }else if(strategy.equalsIgnoreCase("equals")){
            return new SelectWithEqualsStrategy();
        }else if(strategy.equalsIgnoreCase("multiple")){
            return new SelectWithStrategyOfMultipleNumber();
        }
        return null;
    }
}

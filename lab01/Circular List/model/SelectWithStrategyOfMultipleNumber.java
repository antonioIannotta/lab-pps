package lab01.tdd;

public class SelectWithStrategyOfMultipleNumber implements SelectStrategy {

    private int number;

    public SelectWithStrategyOfMultipleNumber(){}

    public void setNumber(int number){
        this.number = number;
    }
    @Override
    public boolean apply(int element) {
        return ((element % number) == 0);
    }
}

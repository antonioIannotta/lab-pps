package lab01.tdd;

public class SelectWithEqualsStrategy implements SelectStrategy {

    private int number;

    public SelectWithEqualsStrategy(){}

    public void setNumber(int number){
        this.number = number;
    }

    @Override
    public boolean apply(int element) {
        return (element == number);
    }
}

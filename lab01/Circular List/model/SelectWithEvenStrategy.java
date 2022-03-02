package lab01.tdd;

public class SelectWithEvenStrategy implements SelectStrategy{

    public SelectWithEvenStrategy(){}
    @Override
    public boolean apply(int element) {
        return ((element % 2) == 0);
    }

    @Override
    public void setNumber(int number) {}
}

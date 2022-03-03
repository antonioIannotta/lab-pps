package lab01.tdd;

import java.util.ArrayList;
import java.util.Optional;

public class CircularIntegerList implements CircularList{

    private List<Integer> circularIntegerList;
    private int next = 0;

    public CircularIntegerList(){
        this.circularIntegerList = new ArrayList<>();
    }

    @Override
    public void add(final int element){
        this.circularIntegerList.add(element);
    }

    @Override
    public int size() {
        return this.circularIntegerList.size();
    }

    @Override
    public boolean isEmpty(){
        return (this.circularIntegerList.size() == 0);
    }

    @Override
    public Optional<Integer> next() {
        Optional<Integer> result = Optional.ofNullable(circularIntegerList.get(next));
        (next == this.size() - 1) ? next = 0 : next += 1;
        return result;
    }

    @Override
    public Optional<Integer> previous() {
        Optional<Integer> result;
        if (next == 0){
            result = resultForPrevious(this.size);
        }else{
            result = resultForPrevious(next);
        }
        return result;
    }

    @Override
    public void reset() {
        next = 0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        int element = this.next().get();
        Optional<Integer> result = Optional.empty();
        for(int i=0; i<this.size(); i++){
            if(!strategy.apply(element)){
                element = this.next().get();
            }else{
                result = Optional.of(Integer.valueOf(element));
                i = this.size();
            }
        }

        return result;
    }
    
    private Optional<Integer> startingPointForPrevious(int startingPoint){
        return Optional.ofNullable(circularIntegerList.get(startingPoint - 1));
    }
}

package lab01.tdd;

import java.util.ArrayList;
import java.util.Optional;

public class CircularIntegerList implements CircularList{

    private ArrayList<Integer> circularIntegerList;
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
        next += 1;
        if (next == this.size()){
            next = 0;
        }
        return result;
    }

    @Override
    public Optional<Integer> previous() {
        Optional<Integer> result;
        if (next == 0){
            result = Optional.ofNullable(circularIntegerList.get(this.size() - 1));
        }else{
            result = Optional.ofNullable(circularIntegerList.get(next - 1));
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
}

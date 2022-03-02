import lab01.tdd.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularIntegerList circularIntegerList;

    @BeforeEach
    void beforeEach(){
        circularIntegerList = new CircularIntegerList();
    }

    @Test
    void testAdd(){
        this.circularIntegerList.add(1);
        assertFalse(circularIntegerList.isEmpty());
    }

    @Test
    void testSize(){
        this.circularIntegerList.add(1);
        assertEquals(1,circularIntegerList.size());
        this.circularIntegerList.add(2);
        assertEquals(2,circularIntegerList.size());
    }

    @Test
    void testNext(){
        this.circularIntegerList.add(1);
        this.circularIntegerList.add(2);
        assertEquals(Optional.of(Integer.valueOf(1)),this.circularIntegerList.next());
        assertEquals(Optional.of(Integer.valueOf(2)),this.circularIntegerList.next());
        assertEquals(Optional.of(Integer.valueOf(1)),this.circularIntegerList.next());
    }

    @Test
    void testPrevious(){
        this.circularIntegerList.add(1);
        this.circularIntegerList.add(2);
        this.circularIntegerList.next();
        assertEquals(Optional.of(Integer.valueOf(1)),this.circularIntegerList.previous());
        this.circularIntegerList.next();
        assertEquals(Optional.of(Integer.valueOf(2)),this.circularIntegerList.previous());
    }

    @Test
    void testReset(){
        for(int i=1; i<=5; i++){
            this.circularIntegerList.add(i);
        }
        assertEquals(Optional.of(Integer.valueOf(1)),this.circularIntegerList.next());
        assertEquals(Optional.of(Integer.valueOf(2)),this.circularIntegerList.next());
        assertEquals(Optional.of(Integer.valueOf(3)),this.circularIntegerList.next());
        this.circularIntegerList.reset();
        assertEquals(Optional.of(Integer.valueOf(1)),this.circularIntegerList.next());
    }

    @Test
    void testNextWithEvenStrategy(){
        this.circularIntegerList.add(1);
        this.circularIntegerList.add(3);
        this.circularIntegerList.add(4);

        AbstractSelectStrategyFactory strategyFactory = StrategyProducer.getFactory();
        SelectStrategy strategy = strategyFactory.createSelectStrategy("even");
        assertEquals(Optional.of(Integer.valueOf(4)),this.circularIntegerList.next(strategy));

    }

    @Test
    void testNextWithStrategyOfMultipleNumber(){
        this.circularIntegerList.add(1);
        this.circularIntegerList.add(2);
        this.circularIntegerList.add(6);

        AbstractSelectStrategyFactory strategyFactory = StrategyProducer.getFactory();
        SelectStrategy strategy = strategyFactory.createSelectStrategy("multiple");
        strategy.setNumber(3);
        assertEquals(Optional.of(Integer.valueOf(6)),this.circularIntegerList.next(strategy));

        this.circularIntegerList.add(8);
        this.circularIntegerList.add(13);

        strategy = strategyFactory.createSelectStrategy("multiple");
        strategy.setNumber(23);
        assertEquals(Optional.empty(),this.circularIntegerList.next(strategy));

    }

    @Test
    void testNextWithEqualsStrategy(){
        this.circularIntegerList.add(3);
        this.circularIntegerList.add(5);
        this.circularIntegerList.add(125);
        this.circularIntegerList.add(34);

        AbstractSelectStrategyFactory strategyFactory = StrategyProducer.getFactory();
        SelectStrategy strategy = strategyFactory.createSelectStrategy("equals");
        strategy.setNumber(34);
        assertEquals(Optional.of(Integer.valueOf(34)),this.circularIntegerList.next(strategy));
    }
}

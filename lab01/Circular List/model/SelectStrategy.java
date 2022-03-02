package lab01.tdd;

/**
 * Represent a select Strategy to be applied to determine which is the next element to chose in a CircularList
 */
public interface SelectStrategy {

    /**
     * Determines if the element satisfies the strategy
     * @param element the element to be checked
     * @return true if the element satisfies the strategy, false otherwise
     */
    boolean apply(final int element);

    /**
     * Allows to set the number in order to perform the MultipleStrategy and the EqualsStrategy
     * @param number the element to set up
     * @return void
     */

    void setNumber(int number);
}

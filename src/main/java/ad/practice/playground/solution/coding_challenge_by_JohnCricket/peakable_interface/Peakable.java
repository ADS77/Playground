package ad.practice.playground.solution.coding_challenge_by_JohnCricket.peakable_interface;

import java.util.NoSuchElementException;

public class Peakable<T> implements CustomIterator<T>{
    private final CustomIterator<T> iterator;
    private T nextElement;
    private boolean peeked;

    public Peakable(CustomIterator<T> iterator){
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return peeked || iterator.hasNext();
    }

    @Override
    public T next() {
        if(! hasNext()){
            throw new NoSuchElementException("No more Elements!");
        }
        peeked = false;
        return nextElement;
    }


    public T peek(){
        if(! peeked){
            if(iterator.hasNext()){
                nextElement = iterator.next();
                peeked = true;
            }
            else {
                throw new NoSuchElementException("No Elements!");
            }
        }
        return nextElement;
    }
}

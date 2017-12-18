// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Integer peek = null;
    
    private Iterator<Integer> iterator;

    private boolean hasNext = false;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.iterator = iterator;
	    if (this.iterator != null && this.iterator.hasNext()) {
            this.peek = iterator.next();
            this.hasNext = true;
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = peek;
        if (iterator.hasNext()) peek = iterator.next();
        else {
            hasNext = false;
            peek = null;
        }
        return res;
	}

	@Override
	public boolean hasNext() {
	    return hasNext;
	}
}

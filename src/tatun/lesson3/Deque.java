package tatun.lesson3;

public class Deque<T> {
    private int maxSize;

    private T[] deque;

    private int begin;
    private int end;

    private int size;

    public Deque(int size){
        this.maxSize = size;
        deque = (T[]) new Object[maxSize];

        size = 0;

        begin = 0;
        end = -1;
    }

    public void insertBegin(T element){
        if (isFull()) throw new RuntimeException("Deque is full.");

        if(begin == 0)
            begin = maxSize;

        deque[--begin] = element;
        size++;

        if (size == 1) end = begin;
    }

    public void insertEnd(T element) throws RuntimeException {
        if (isFull()) throw new RuntimeException("Deque is full.");

        if(end == maxSize - 1) end = -1;

        deque[++end] = element;

        size++;

        if (size == 1) begin = end;
    }

    public T removeBegin(){
        if (isEmpty()) throw new RuntimeException("Deque is empty.");

        T temp = deque[begin++];
        if(begin == maxSize)
            begin = 0;
        size--;

        if (size == 1) {
            end = begin;
        } else if (size == 0) {
            begin = 0;
            end = -1;
        }

        return temp;
    }

    public T removeEnd(){
        if (isEmpty()) throw new RuntimeException("Deque is empty.");

        T temp = deque[end--];
        if(end == 0)
            end = maxSize-1;
        size--;

        if (size == 1) {
            begin = end;
        } else if (size == 0) {
            begin = 0;
            end = -1;
        }

        return temp;
    }

    public T getBegin(){
        if (isEmpty()) throw new RuntimeException("Deque is empty.");
        return deque[begin];
    }

    public T getEnd() {
        if (isEmpty()) throw new RuntimeException("Deque is empty.");
        return deque[end];
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public boolean isFull(){
        return (size == maxSize);
    }

    public int size(){
        return size;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (int i = 0; i < size; i++) {
            T element = deque[(begin + i) % maxSize];
            if (i == size - 1)
                sb.append(element);
            else
                sb.append(element + ",");
        }
        sb.append("}");
        return sb.toString();
    }
}

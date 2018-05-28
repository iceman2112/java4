package tatun.lesson3;

public class PriorityQueue<T extends Number> {
    private int maxSize;
    private T[] items;
    private int size;

    public PriorityQueue(int size) {
        maxSize = size;
        items = (T[]) new Number[size];
        size = 0;
    }

    public void insert(T element) {
        if (isFull()) throw new RuntimeException("Queue is full");

        int i;
        if (isEmpty())
            items[size++] = element;
        else {
            for (i = size -1; i >= 0; i--) {
                if (element.doubleValue() <= items[i].doubleValue()) {
                    break;
                }
                items[i + 1] = items[i];
            }

            items[i + 1] = element;
            size++;
        }
    }

    public T remove() {
        return items[--size];
    }

    public T peek() {
        return items[size - 1];
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (int i = 0; i < size; i++) {
            T element = items[i];
            if (i == size - 1)
                sb.append(element);
            else
                sb.append(element + ",");
        }
        sb.append("}");
        return sb.toString();
    }
}

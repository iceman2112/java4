package tatun.lesson3;

public class Stack <T>{
    private int maxSize;
    private T[] stack;
    private int head;

    public Stack(int size) {
        this.maxSize = size;
        this.stack = (T[]) new Object[size];
        this.head = -1;
    }

    public boolean isEmpty() { return head == -1; }

    public boolean isFull() { return head == maxSize - 1; }

    public void push(T value) {
        stack[++head] = value;
    }

    public T pop() {
        return stack[head--];
    }

    public T peek() {
        return stack[head];
    }
}
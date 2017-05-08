package stack;

public class BoundedStack implements Stack {
    private int size;
    private int capacity;
    private int[] elements;

    public BoundedStack(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
    }

    public static Stack make(int capacity) {
        if (capacity < 0)
            throw new IllegalCapacity();
        if (capacity == 0)
            return new ZeroCapacityStack();
        return new BoundedStack(capacity);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void push(int element) {
        if (size == capacity)
            throw new Overflow();
        this.elements[size++] = element;
    }

    public int pop() {
        if (isEmpty())
            throw new Underflow();
        return elements[--size];
    }

    public int top() {
        if (isEmpty())
            throw new Empty();
        return elements[size - 1];
    }

    public Integer find(int element) {
        for (int i = size - 1; i >= 0; i--)
            if (elements[i] == element)
                return (size - 1) - i;
        return null;
    }

    private static class ZeroCapacityStack implements Stack {
        public boolean isEmpty() {
            return true;
        }

        public int getSize() {
            return 0;
        }

        public void push(int element) {
            throw new Overflow();
        }

        public int pop() {
            throw new Underflow();
        }

        public int top() {
            throw new Empty();
        }

        public Integer find(int element) {
            return null;
        }
    }
}

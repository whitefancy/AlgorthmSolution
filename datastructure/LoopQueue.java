package OJSolution.datastructure;


public class LoopQueue<T> {

    private Object[] datas;
    private int size;
    private int front = 0;
    private int rear = 0;

    public LoopQueue(int size) {
        this.size = size;
        datas = new Object[size];
    }

    public boolean push(T t) {
        if (isFull()) {
            return false;
        }
        datas[rear] = t;
        rear = (rear + 1) % size;
        return true;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T t = (T) datas[front];
        datas[front] = null;
        front = (front + 1) % size;
        return t;
    }

    public int length() {
        return (rear - front + size) % size;
    }

    public boolean isEmpty() {
        if (rear == front) {
            return true;
        }
        return false;
    }

    private boolean isFull() {
        if ((rear + 1) % size == front) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

}
package leetcode;

public class Solution622 {
    public static void main(String[] args) {
        int k = 10;
        MyCircularQueue obj = new MyCircularQueue(k);
        int value = 14;
        boolean param_1 = obj.enQueue(value);
        boolean param_2 = obj.deQueue();
        int param_3 = obj.Front();
        int param_4 = obj.Rear();
        boolean param_5 = obj.isEmpty();
        boolean param_6 = obj.isFull();
    }
}

class MyCircularQueue {
    /**
     * 队列大小，实际存储大小为maxSize-1
     */
    private int maxSize;
    /**
     * 存储队列的实际数据
     */
    private int[] data;
    /**
     * 队列头指针，指向队首元素
     */
    private int front;
    /**
     * 队列尾指针，指向队尾元素
     */
    private int rear;


    public MyCircularQueue(int k) {
        maxSize = k + 1;
        data = new int[maxSize];
        front = 0;
        rear = 0;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        data[rear] = value;
        rear = (rear + 1) % maxSize;//考虑越界
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        front = (front + 1) % maxSize;//考虑越界
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return data[front];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return data[(rear - 1 + maxSize) % maxSize];//负数取模还是会得到负数
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
}

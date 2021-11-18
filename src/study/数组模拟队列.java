package study;

import javax.xml.crypto.Data;

public class 数组模拟队列 {
}

/**
 * 使用数组模拟队列
 */
class ArrayQueue {
    /**
     * 队列最大值
     */
    private int maxSize;
    /**
     * 队列头，指向队列头元素的前一个位置
     */
    private int front;
    /**
     * 队列尾，指向队列尾元素所在位置
     */
    private int rear;
    /**
     * 存储队列数据
     */
    private int[] data;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        this.data = new int[maxSize];
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 判断队列是否为满
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 向队列中添加元素
     *
     * @param n
     */
    public void add(int n) {
        //判断队列是否满
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        rear++;//rear后移
        data[rear] = n;
    }

    /**
     * 弹出队列首的元素
     *
     * @return
     */
    public int pop() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;//front后移
        return data[front];
    }

    /**
     * 查看队列首的元素值
     *
     * @return
     */
    public int peak() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return data[front + 1];
    }

    /**
     * 显示队列中的所有元素
     */
    public void showData() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for (int i = front + 1; i <= rear; i++) {
            System.out.printf("data[%d]=%d\t", i, data[i]);
        }
        System.out.println();
    }
}
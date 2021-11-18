package study;

public class 数组模拟环形队列 {
}

/**
 * 使用数组模拟环形队列
 */
class CircleQueue {
    /**
     * 队列最大值
     */
    private int maxSize;
    /**
     * 队列头，指向队列头元素所在位置
     */
    private int front;
    /**
     * 队列尾，指向队列尾元素所在位置的后一个
     */
    private int rear;
    /**
     * 存储队列数据
     */
    private int[] data;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
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
        return (rear + 1) % maxSize == front;
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
        data[rear] = n;
        rear = (rear + 1) % maxSize;//rear后移,需要考虑取模
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
        int head = data[front];
        rear = (rear + 1) % maxSize;//front后移,需要考虑取模
        return head;
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
        return data[front];
    }

    /**
     * 显示队列中的所有元素
     */
    public void showData() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        //从front开始，直到和rear差一个位置
        for (int i = front; (i + 1) % maxSize != rear; i = (i + 1) % maxSize) {
            System.out.printf("data[%d]=%d\t", i, data[i]);
        }
        System.out.println();
    }

    /**
     * 求出队列的实际大小
     *
     * @return
     */
    public int size() {
        /**
         * maxSize=3，front=0，rear=2
         * 实际大小为(2+3-0)%maxSize
         */
        return (rear + maxSize - front) % maxSize;
    }
}
package study;

public class 单向链表 {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addNode(4, "zhangsan");
        list.addNode(3, "lisi");
        list.addNode(2, "wangwu");
        list.addNode(1, "gubin");
        list.showList();
        list.deleteNode(3);
        list.showList();
        list.updateNode(2,"ceshi");
        list.showList();
    }
}

class SingleLinkedList {
    //头节点，不存放具体数据
    private Node head = new Node(0, "");

    /**
     * 向链表添加节点,插入时按照num大小顺序插入
     *
     * @param num
     * @param name
     */
    public void addNode(int num, String name) {
        Node newNode = new Node(num, name);
        Node temp = head;
        boolean flag = false;
        //将新插入的节点和当前节点的下一个节点进行比较，如果比它小，则在这两个节点之间插入
        while (temp.next != null) {
            if (temp.next.num > newNode.num) {
                newNode.next = temp.next;
                temp.next = newNode;
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //如果没有插入，就插入到链表最后
        if (!flag)
            temp.next = newNode;
    }

    /**
     * 删除链表中的一个节点
     *
     * @param num
     */
    public void deleteNode(int num) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.num == num) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

    /**
     * 修改某个节点
     *
     * @param num
     * @param name
     */
    public void updateNode(int num, String name) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            if(temp.num==num){
                temp.name=name;
                break;
            }
        }
    }

    /**
     * 遍历输出链表
     */
    public void showList() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println("节点：num: " + temp.num + ", name: " + temp.name);
        }
        System.out.println("节点输出完毕");
    }
}

/**
 * 节点信息
 */
class Node {
    public int num;
    public String name;
    public Node next;

    public Node(int num, String name) {
        this.num = num;
        this.name = name;
    }
}
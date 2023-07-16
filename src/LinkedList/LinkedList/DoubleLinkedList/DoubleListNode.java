package LinkedList.LinkedList.DoubleLinkedList;

// 双向链表
public class DoubleListNode {
    int value;
    DoubleListNode preNode;
    DoubleListNode nextNode;

    public DoubleListNode(int value, DoubleListNode preNode, DoubleListNode nextNode) {
        this.value = value;
        this.preNode = preNode;
        this.nextNode = nextNode;
    }

    public DoubleListNode() {

    }

    public DoubleListNode(DoubleListNode preNode) {
        this.preNode = preNode;
    }

    public DoubleListNode(int value) {
        this.value = value;
    }

    public DoubleListNode(DoubleListNode preNode, DoubleListNode nextNode) {
        this.preNode = preNode;
        this.nextNode = nextNode;
    }

    /**
     * 展示数据
     */
    public void displayNode() {
        System.out.print("{" + value + "}");
    }

}

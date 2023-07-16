package LinkedList.LinkedList.DoubleLinkedList;

public class TestDoubleListNode {
    public static void main(String[] args) {
        // 初始化双向链表
        DoubleListNode doubleListNode1 = new DoubleListNode(1);
        DoubleListNode doubleListNode2 = new DoubleListNode(2);
        DoubleListNode doubleListNode3 = new DoubleListNode(3);
        DoubleListNode doubleListNode4 = new DoubleListNode(5);
        doubleListNode1.nextNode = doubleListNode2;
        doubleListNode2.preNode = doubleListNode1;
        doubleListNode2.nextNode = doubleListNode3;
        doubleListNode3.preNode = doubleListNode2;
        doubleListNode3.nextNode = doubleListNode4;
        doubleListNode4.preNode = doubleListNode3;


//        displayDoubleNodeFromHead(doubleListNode1);
//
//        displayDoubleNodeFromTail(doubleListNode4);

//        DoubleListNode doubleListNode = insetIntoNodeHead(doubleListNode1, new DoubleListNode(0));
//        displayDoubleNodeFromHead(doubleListNode);


//        DoubleListNode doubleListNode5 = insetIntoNodeTail(doubleListNode4, new DoubleListNode(6));
//        displayDoubleNodeFromHead(doubleListNode1);


//        DoubleListNode doubleListNode = insetIntoNodeByPosition(doubleListNode1, new DoubleListNode(4), 4);
//        displayDoubleNodeFromHead(doubleListNode);

//        DoubleListNode doubleListNode = deleteNodeHead(doubleListNode1);
//        displayDoubleNodeFromHead(doubleListNode);


//        DoubleListNode doubleListNode5 = deleteNodeTail(doubleListNode4);
//        displayDoubleNodeFromHead(doubleListNode1);


        DoubleListNode doubleListNode = deleteNode(doubleListNode1, 2);
        displayDoubleNodeFromHead(doubleListNode);
    }

    // 从头遍历
    public static void displayDoubleNodeFromHead(DoubleListNode head) {
        DoubleListNode current = head;
        while (current != null) {
            // 展示
            current.displayNode();
            current = current.nextNode;
        }
        System.out.println("");
    }

    // 尾部遍历
    public static void displayDoubleNodeFromTail(DoubleListNode tail) {
        DoubleListNode current = tail;
        while (current != null) {
            current.displayNode();
            current = current.preNode;
        }
    }

    /**
     * 头部插入
     *
     * @param head
     * @param newNode
     */
    public static DoubleListNode insetIntoNodeHead(DoubleListNode head, DoubleListNode newNode) {
        if (head == null) {
            return newNode;
        }
        newNode.nextNode = head;
        head.preNode = newNode;
        head = newNode;
        return head;
    }

    /**
     * 尾部插入
     *
     * @param tail
     * @param newNode
     * @return
     */
    public static DoubleListNode insetIntoNodeTail(DoubleListNode tail, DoubleListNode newNode) {
        if (tail == null) {
            return newNode;
        }
        tail.nextNode = newNode;
        newNode.preNode = tail;
        tail = newNode;
        return tail;
    }


    /**
     * 插入指定位置的节点
     *
     * @param head
     * @param newNode
     * @param position
     * @return
     */
    public static DoubleListNode insetIntoNodeByPosition(DoubleListNode head, DoubleListNode newNode, int position) {
        // 空节点
        if (head == null) {
            return newNode;
        }
        DoubleListNode current = head;

        // 头节点
        if (position == 1) {
            newNode.nextNode = head;
            head.preNode = newNode;
            return newNode;
        }


        // 计算处添加节点的前一个节点
        int count = 0;
        while (count < position - 2 && current.nextNode != null) {
            current = current.nextNode;
            count++;
        }

        DoubleListNode nextNode = current.nextNode;
        if (nextNode != null) {
            nextNode.preNode = newNode;
            newNode.nextNode = nextNode;
        }

        current.nextNode = newNode;
        newNode.preNode = current;

        return head;
    }


    /**
     * 删除头节点
     *
     * @param head
     * @return
     */
    public static DoubleListNode deleteNodeHead(DoubleListNode head) {
        DoubleListNode current = head;
        DoubleListNode nextNode = current.nextNode;
        nextNode.preNode = null;
        head = nextNode;
        return head;
    }

    /**
     * 删除尾节点
     *
     * @param tail
     * @return
     */
    public static DoubleListNode deleteNodeTail(DoubleListNode tail) {
        DoubleListNode current = tail;
        DoubleListNode preNode = current.preNode;
        preNode.nextNode = null;
        tail = preNode;
        return tail;
    }

    /**
     * 删除指定元素
     *
     * @param head
     * @param position
     * @return
     */
    public static DoubleListNode deleteNode(DoubleListNode head, int position) {
        // 头节点不存在
        if (head == null) {
            return null;
        }

        DoubleListNode current = head;
        // 删除头节点
        if (position == 1) {
            DoubleListNode nextNode = current.nextNode;
            nextNode.preNode = null;
            head = nextNode;
            return head;
        }

        int count = 1;
        while (count < position && current != null) {
            current = current.nextNode;
            count++;
        }

        if (current != null) {
            DoubleListNode prevNode = current.preNode;
            DoubleListNode nextNode = current.nextNode;

            if (prevNode != null) {
                prevNode.nextNode = nextNode;
            }

            if (nextNode != null) {
                nextNode.preNode = prevNode;
            } else {
                // 当前节点是最后一个节点
                prevNode.nextNode = null;
            }
        }
        return head;
    }
}

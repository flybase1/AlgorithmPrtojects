package LinkedList.LinkedList.SingleLinkedLlist;

// 但连败哦操作
public class TraverseLinkedList {
    public static void main(String[] args) {
        // 初始化链表
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

//        int length = getListNodeLength(listNode1);
//        System.out.println(length);
//        showNode(listNode1);
//
//        ListNode listNode = insertIntoNode(listNode1, new ListNode(0));
//        showNode(listNode);
//
//        ListNode listNode5 = insertIntoTail(listNode1, new ListNode(5));
//        showNode(listNode5);
//
//        ListNode listNode6 = insertIntoPosition(listNode1, new ListNode(10), 2);
//        showNode(listNode6);

//        System.out.println("=================");
//        ListNode listNode7 = insertIntoListNode(listNode1, new ListNode(5), 4);
//        showNode(listNode7);
//
//        ListNode listNode8 = insertIntoListNode(listNode1, new ListNode(0), 1);
//        showNode(listNode8);
//
//        ListNode listNode9 = insertIntoListNode(listNode1, new ListNode(10), 3);
//        showNode(listNode9);

//        ListNode listNode = deleteHead(listNode1);
//        showNode(listNode);
//
//
//        ListNode listNode5 = deleteTail(listNode1);
//        showNode(listNode5);

//
//        ListNode listNode6 = deleteByPosition(listNode1, 2);
//        showNode(listNode6);

        ListNode listNode = deletePosition(listNode1, 3);
        showNode(listNode);
    }


    /**
     * 链表长度
     *
     * @param head
     * @return
     */
    public static int getListNodeLength(ListNode head) {
        int length = 0;
        ListNode listNode = head;
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }
        return length;
    }

    /**
     * 展示链表
     *
     * @param head
     */
    public static void showNode(ListNode head) {
        ListNode listNode = head;
        while (listNode != null) {
            System.out.print(listNode.value + "=>");
            listNode = listNode.next;
        }
        System.out.println("null");
    }

    /**
     * 头插法
     *
     * @param head
     * @param newNode
     * @return
     */
    public static ListNode insertIntoNode(ListNode head, ListNode newNode) {
        newNode.next = head;
        head = newNode;
        return head;
    }


    public static ListNode insertIntoTail(ListNode head, ListNode newNode) {
        ListNode listNode = head;
        while (listNode.next != null) {
            listNode = listNode.next;
        }
        listNode.next = newNode;
        newNode.next = null;
        return head;
    }

    /**
     * 插入中间元素
     *
     * @param head
     * @param newNode
     * @param position
     * @return
     */
    public static ListNode insertIntoPosition(ListNode head, ListNode newNode, int position) {
        ListNode listNode = head;
        int length = 0;
        while (length < position - 1) {
            listNode = listNode.next;
            length++;
        }
        newNode.next = listNode.next;
        listNode.next = newNode;
        return head;
    }


    public static ListNode insertIntoListNode(ListNode head, ListNode newNode, int position) {
        // 当前链表为空，插入元素则为第一个节点
        if (head == null) {
            return newNode;
        }
        // 是否超过界限
        ListNode listNode = head;
        int listNodeLength = getListNodeLength(head);
        if (position < 1 || position > listNodeLength + 1) {
            System.out.println("元素越界");
            return head;
        }

        // 头节点
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return head;
        }


        // 指定位置
        int count = 0;
        ListNode node = head;
        while (count < position - 1) {
            node = node.next;
            count++;
        }
        newNode.next = node.next;
        node.next = newNode;

        return head;
    }


    /**
     * 头删法
     *
     * @param head
     * @return
     */
    public static ListNode deleteHead(ListNode head) {
        ListNode listNode = head;
        listNode = listNode.next;
        head = listNode;
        return head;
    }


    /**
     * 删尾
     *
     * @param head
     * @return
     */
    public static ListNode deleteTail(ListNode head) {
        ListNode listNode = head;
        while (listNode.next.next != null) {
            listNode = listNode.next;
        }
        listNode.next = null;
        return head;
    }

    /**
     * 删除指定元素
     *
     * @param head
     * @param position
     * @return
     */
    public static ListNode deleteByPosition(ListNode head, int position) {
        ListNode listNode = head;
        int count = 0;
        while (count < position - 1) {
            count++;
            listNode = listNode.next;
        }
        ListNode deleteNode = listNode.next;
        listNode.next = deleteNode.next;

        return head;
    }


    /**
     * 删除元素
     * @param head
     * @param position
     * @return
     */
    public static ListNode deletePosition(ListNode head, int position) {
        ListNode listNode = head;
        // 链表为空
        if (head == null) {
            return null;
        }

        // 判断界限
        int listNodeLength = getListNodeLength(head);
        // 这里不需要判断listNodeLength+1，因为下面已经记录了删除元素的前一个节点，和删除节点的下一个节点存不存在没有关系
        if (position > listNodeLength || position < 1) {
            System.out.println("超过界限");
            return head;
        }

        if (position == 1) {
            listNode = listNode.next;
            head = listNode;
            return head;
        }

        ListNode preNode = head;
        int count = 0;
        while (count < position - 1) {
            preNode = preNode.next;
            count++;
        }
        ListNode deleteNode = preNode.next;
        preNode.next = deleteNode.next;
        return head;

    }
}

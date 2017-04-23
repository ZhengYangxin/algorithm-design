### 题目

Given a linked list, remove the nth node from the end of list and return its head.

```
For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
```

Note:  
Given n will always be valid.  
Try to do this in one pass.

### 分析

基本思路是采用两个指针pa和pb，先将pa向前移动n步，然后pa和pb同时移动，等到pa到达链尾时则pb刚好在删除元素的前面位置，因为采用无头链表，所以对于第一个位置元素的删除要考虑多一些，可以用一个变量记录链表长度，来应对这种表头元素的删除。

### 实现

```java
public ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode pa = head, pb = head;
    int len = 1;  // 用一个变量表示长度，在逻辑控制上会简单很多

    int i = 0;
    while ((i++) < n) {
        pa = pa.next;
        len++;
    }

    if (null == pa) {
        // 前头指针已经移出范围，肯定是删除第一个结点
        return head.next;
    }

    while (null != pa.next) {
        pa = pa.next;
        pb = pb.next;
        len++;
    }

    if (len == n) {
        // n等于链表长度，删除第一个结点
        return head.next;
    }

    // 其余情况都是删除pb的下一个结点
    pb.next = pb.next == null ? null : pb.next.next;

    return head;
}
```
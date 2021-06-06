package demo.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        System.out.println(2/10);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for (Iterator<Integer> c = list.iterator(); c.hasNext(); ) {
            System.out.println(c.next());
        }

        ListNode[] ss = new ListNode[]{new ListNode(), new ListNode()};
        System.out.println(ss[0]);

    }
}



  class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

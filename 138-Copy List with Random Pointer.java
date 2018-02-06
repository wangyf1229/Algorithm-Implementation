/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode oldHead = head;
        while (head != null) {

            RandomListNode node;
            if (! map.containsKey(head))  {
               node = new RandomListNode(head.label);
               map.put(head, node);
            } else {
                node = map.get(head);
            }

            if (head.next != null) {
                if (map.containsKey(head.next)) {
                    node.next = map.get(head.next);
                } else {
                    node.next = new RandomListNode(head.next.label);
                    map.put(head.next, node.next);
                }
            }

            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    node.random = map.get(head.random);
                } else {
                    node.random = new RandomListNode(head.random.label);
                    map.put(head.random, node.random);
                }
            }

            head = head.next;
        }

        return map.get(oldHead);


    }
}
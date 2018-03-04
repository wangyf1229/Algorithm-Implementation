/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // //solution 1:
        // //keep the linked list node in map
        // if (head == null) return head;
        // Map<RandomListNode, RandomListNode> hashmap = new HashMap<RandomListNode, RandomListNode>();
        // RandomListNode curt = head;

        // while (curt != null) {
        //     hashmap.put(curt,new RandomListNode(curt.label));
        //     curt = curt.next;
        // }

        // //link the listnode and copy the random pointer of the linked list
        // curt = head;
        // while (curt != null) {
        //     hashmap.get(curt).next = hashmap.get(curt.next);
        //     hashmap.get(curt).random = hashmap.get(curt.random);
        //     curt = curt.next;
        // }
        // return hashmap.get(head);

        //solution 2:
        if(head == null) return head;
        RandomListNode curt = head;
        //add listnode to the original linked list
        //1->1'->2->2'->3->3'->4->4'
        while (curt != null) {
            RandomListNode newNode = new RandomListNode(curt.label);
            newNode.next = curt.next;
            curt.next = newNode;
            curt = curt.next.next;
        }

        //add random pointer to the newly added listnodes
        curt = head;
        while(curt != null) {
            curt.next.random = curt.random == null? null: curt.random.next;
            curt = curt.next.next;
        }

        //split two linked lists
        curt = head;
        RandomListNode newHead = curt.next;
        while (curt != null) {
            RandomListNode curt2 = curt.next;
            curt.next = curt.next.next;
            if(curt2.next != null) {
              curt2.next = curt2.next.next;
            }
            curt = curt.next;
        }

        return newHead;
    }
}
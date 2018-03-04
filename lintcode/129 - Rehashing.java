/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        int hashSize = hashTable.length * 2;
        ListNode[] newHT = new ListNode[hashSize];
        for (ListNode i : hashTable) {
            while (i != null) {
                int hashCode = 0;
                hashCode = hashCode > 0 ? i.val % hashSize : (i.val % hashSize + hashSize) % hashSize;
                ListNode j = newHT[hashCode];
                while (j != null && j.next != null) {
                    j = j.next;
                }
                //exit condition j == null || j.next == null
                if (j == null) {
                    newHT[hashCode] = new ListNode(i.val);
                } else {
                    j.next = new ListNode(i.val);
                }
                i = i.next;
            }
        }
        return newHT;
    }

};

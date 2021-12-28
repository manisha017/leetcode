/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode middleNode(ListNode head) {
    ListNode curr = head;
    
    int total = 0;
    while(curr != null){
        total++;
        curr = curr.next;
    }        
    
    //find the middle one
    total = total/2 + 1;
    
    ListNode cur = head;
    for(int i = 1; i < total; ++i){
        cur = cur.next;
    }
    
    return cur;
}
}
// 1721. Swapping Nodes in a Linked List

// You are given the head of a linked list, and an integer k.

// Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

 

// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [1,4,3,2,5]

// Example 2:
// Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
// Output: [7,9,6,6,8,7,3,0,9,5]




class Solution 
{
    public ListNode swapNodes(ListNode head, int k) 
    {
        ListNode curr = head;
        ListNode pointer1 = head;
        ListNode pointer2= head;
        int count = 1;
        
        while( curr != null )
        {
            if( count < k )
            {
                pointer1 = pointer1.next;
            }
            if( count > k )
            {
                pointer2 = pointer2.next;
            }
            curr = curr.next;
            count++;
        }
        
        int temp = pointer1.val;
        pointer1.val = pointer2.val;
        pointer2.val = temp;
        
        return head;
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {

        if(head==null) return null;

        Node cur=head;
        while(cur!=null){
            while(cur.child!=null){
                Node nextNode=cur.next;
                Node childTail=cur.child;
                while(childTail.next!=null)childTail=childTail.next;
                if(nextNode!=null){
                    childTail.next=nextNode;
                    nextNode.prev=childTail;

                }
                cur.next=cur.child;
                cur.child.prev=cur;
                cur.child=null;

            }
            cur=cur.next;
        }
        return head;
    }
}

  class ListNode {
    int val;
      ListNode next;
     
      ListNode(int x) { val = x; }
 }

public class TwoSum {
	public static void main(String args[]){
		
		ListNode l = new ListNode(1);
		l.next = null;
		//ListNode m = new ListNode(8);
		//l.next = m;
		//m.next = null;
		
		ListNode k = new ListNode(9);
		k.next = new ListNode(9);
		
		ListNode newHead = new ListNode(0);
		ListNode p3 = newHead;
		int carry = 0;
		while(l != null || k!=null){
			
			int temp = 0;
			if(l == null){
				temp = k.val;
			}
			else if(k == null){
				temp = l.val;
			}
			else{
				temp = l.val + k.val;
			}
			temp+=carry;
			int re = temp % 10;
			p3.next = new ListNode(re);
			p3 = p3.next;
			if(temp >= 10){
				carry = 1;
			}
			else {
				carry = 0;
			}

			if(l != null)
			l= l.next;
			if(k != null)
			k = k.next;
		}
		if(carry==1) 
            p3.next=new ListNode(1);
		
		while(newHead != null){
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
		
	}
	 
}

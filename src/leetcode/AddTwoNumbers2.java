package leetcode;

//  不能转成int来做。测试用例位数太多。
//  如果想简化代码，参考官方题解，将两个链表是否为空放在一起判断。如果其中一个链表为空，那么用0来作为值填充。

public class AddTwoNumbers2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        ListNode cur = new ListNode(0);
        //  存储头节点
        ListNode head = cur;
        int carry = 0;
        while(l1!=null || l2!=null){
            int num1 = l1!=null?l1.val:0;
            int num2 = l2!=null?l2.val:0;
            int sum = num1+num2+carry;
            carry = sum/10;
            sum = sum%10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        if(carry>0){
            cur.next = new ListNode(carry);
        }
        return head.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        int carry = 0;
        int temp = l1.val + l2.val;
        if(temp>9) {
            temp = temp%10;
            carry = 1;
        }
        //  事实上不需要用一个temp来作为初始值，结尾返回的时候直接返回head.next就可以了。好蠢啊我。
        ListNode cur = new ListNode(temp);
        ListNode head = cur;
        while(l1.next!=null && l2.next!=null){
            l1 = l1.next;
            l2 = l2.next;
            temp = l1.val + l2.val+carry;
            if(temp>9) {
                temp = temp%10;
                carry = 1;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(temp);
            cur = cur.next;
        }
        //  跳出循环有三种情况，三种情况都要考虑是否有carry残余
        //  1 l1未遍历完
        //  2 l2未遍历完
        //  3 都遍历完

        boolean flag = true;
        if(l1.next!=null){
            if(carry==0){
                flag = false;
                cur.next = l1.next;
            } else {
                while(l1.next!=null){
                    l1 = l1.next;
                    if(l1.val==9){
                        cur.next = new ListNode(0);
                        cur = cur.next;
                    } else {
                        cur.next = new ListNode(l1.val+1);
                        cur = cur.next;
                        cur.next = l1.next;
                        flag = false;
                        break;
                    }
                }
            }
        } else if(l2.next!=null){
            if(carry==0){
                flag = false;
                cur.next = l2.next;
            } else {
                while(l2.next!=null){
                    l2 = l2.next;
                    if(l2.val==9){
                        cur.next = new ListNode(0);
                        cur = cur.next;
                    } else {
                        cur.next = new ListNode(l2.val+1);
                        cur = cur.next;
                        cur.next = l2.next;
                        flag = false;
                        break;
                    }
                }
            }
        } else {
            flag = false;
            if(carry==1){
                cur.next = new ListNode(1);
            }
        }
        if(flag){
            cur.next = new ListNode(1);
        }
        return head;
    }
}

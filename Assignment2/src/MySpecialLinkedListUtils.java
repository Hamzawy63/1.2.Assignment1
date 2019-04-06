
public class MySpecialLinkedListUtils {
    public static double[] summary(LinkedListNode head) ///RETURN ARRAY 
    {

        double[] a = {0,0,0,head.value,head.value};
		/*
		 * Returns the sum, average, median, maximum and minimum
			of the values in the list
		 */
        LinkedListNode nodePointer;
        nodePointer = head ;
        int i =0; ///counter to know length of the linked list
        while(nodePointer != null)
        {
            i++;
            a[0]+=nodePointer.value; ///TO CALC THE SUM
            if(nodePointer.value>a[3]) ///TO DETERMINE THE MAX
            {
                a[3] = nodePointer.value;
            }
            if(nodePointer.value<a[4]) ///TO DETERMINE THE MINIMUM
            {
                a[4] = nodePointer.value;
            }
            nodePointer =nodePointer.next;
        }
        a[1] = a[0]/i; ///check it out
        nodePointer = head;
        //a[2] = i;
        LinkedListNode ref = mergeSort(head);
        for(int j=0;j<i;j++)
        {
            if(j == (i/2-1))
            {
                if(i%2 ==1)
                    a[2] = ref.next.value;
                else
                    a[2] = (ref.value + ref.getNext().value) /2 ;
                break;
            }
            ref =ref.next;

        }




        return a;
    }
    public static LinkedListNode reverse(LinkedListNode head)
    {
        LinkedListNode tail = head;
        //LinkedListNode ref = head;
        ///determine the length of linked list
        int length=0;
        while((head!=null)&&tail.next!=null)
        {
            length++;
            tail = tail.next;
        }
        ///NOTE LENGTH = LENGTH OF THE LINKEDLIST -1 SO THAT THE TAIL WILL POINT TO THE LAST ELEMENT
        int j,l;
        LinkedListNode tmpheader = new LinkedListNode(5); ///any number
        tmpheader = head;
        if(length <=0)
        {
            return head;
        }
        for(j = (length-1);j>0;j--)
        {
            LinkedListNode prev = tmpheader;
            LinkedListNode fol = tmpheader.next;

            for(l = 0 ;l<j ;l++)
            {
                prev = prev.next;
                fol = fol.next;
            }
            fol.next = prev;
        }
        head.next.next = tmpheader;
        tmpheader.next = null;
        head = tail;
        System.out.println("\n"+length+ "a**");
        return head;

    }
    public static LinkedListNode evenIndexedElements(LinkedListNode head)
    {

        LinkedListNode ref = head;
        while(ref !=null &&ref.next !=null)
        {
            ref.next = ref.next.next;
            ref = ref.next;
        }

        return head;
    }
    public static LinkedListNode insertionSort(LinkedListNode head)
    {
        LinkedListNode tmp1= head  ;
        while(tmp1!=null&&tmp1.next!=null)
        {
            boolean CorrectOrder = false;

            if(tmp1.value> tmp1.getNext().value)
            {

                ///SEARCH FOR ITS RIGHT PLACE
                LinkedListNode tmp2 = head ;
                LinkedListNode target = tmp1.next;
                while(tmp2 !=  tmp1 ||head.value>target.value)
                {
                    if(head.value>target.value)
                    {
                        //LinkedListNode newNode = new LinkedListNode(target.value);
                        ///insert of the new node
                        LinkedListNode newNode = new LinkedListNode(target.value);
                        newNode.next = head;
                        head = newNode;
                        CorrectOrder = true;
                        break;
                    }

                    if(target.value>tmp2.value && target.value<tmp2.next.value)
                    {
                        LinkedListNode newNode = new LinkedListNode(target.value);
                        ///insert of the new node
                        newNode.next = tmp2.next;
                        tmp2.next = newNode;
                        CorrectOrder =true;
                        break;
                    }
                    tmp2 = tmp2.getNext();

                }
                ///Delete the old node (target )
                tmp1.next =target.next; ///WE CAN USE CONSTRUCTORS (GETTER AND SETTER ) BUT NO NEED AS THEY ARE NOT PRIVATE

                ///ADD
                ///REMOVE

            }
            if(!CorrectOrder)
                tmp1 = tmp1.getNext();

        }


        return head;
    }
    public static LinkedListNode mergeSort(LinkedListNode head)
    {
        if(head ==null ||head.next ==null)
        {
            return head;
        }
        LinkedListNode ref = head ;
        int length=0;
        while((ref!=null))
        {
            length++;
            ref = ref.next;
        }
        LinkedListNode refAtMiddle = head ;
        for(int i=0 ;i<length/2 -1 ;i++ )
        {
            refAtMiddle = refAtMiddle.getNext();
        }

        LinkedListNode head1 = mergeSort(refAtMiddle.next);
        refAtMiddle.next = null; /// IT DOESN'T WORK IF I REMOVE .NEXT FROM BOTHS LAST STATEMENTS AS WE EDIT OBJECT NOT REFERENCE
        LinkedListNode head2 = mergeSort(head);
        return  mergeOfTwoSortedArray(head1,head2);



    }
    public static LinkedListNode mergeOfTwoSortedArray(LinkedListNode head1,LinkedListNode head2) {
        LinkedListNode newNode = new LinkedListNode();
        LinkedListNode tmp1 = head1;
        LinkedListNode tmp2 = head2;
        LinkedListNode tail = newNode;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.value < tmp2.value) {
                tail.next = new LinkedListNode();
                tail.next.value = tmp1.value;
                tail = tail.next;
                tmp1 = tmp1.next;
            } else {
                tail.next = new LinkedListNode();
                tail.next.value = tmp2.value;
                tail = tail.next;
                tmp2 = tmp2.next;

            }

            if(tmp1 ==null)
            {
                tail.next = tmp2;
            }else if(tmp2 ==null)
            {
                tail.next = tmp1;
            }


        }
        if(head1 ==null)
        {
            return head2;
        }else if (head2 ==null)
        {
            return head1;
        }
        return newNode.next; ///THE BIG BANG
    }


    public static LinkedListNode removeCentralNode(LinkedListNode head)
    {
        ///DETERMINE THE LENGTH
        LinkedListNode ref = head;
        int length=0;
        while((ref!=null))
        {
            length++;
            ref = ref.next;
        }
        ///LOOPING IN THE LINKEDLIST TO REMOVE THE CENTRAL
        ref = head;
        int i = length%2 ==0 ? (length/2)-1:(length/2);
        int j= 0;
        while(ref!=null)
        {
            if(j==i-1)  /// WE SUBTRACT 1 SO THAT THE NEXT OF THE OBJECT IS REQUIRED REF
            {
                ref.next = ref.next.next;
                ///CHANGE
                return head;
            }
            ref = ref.next;
            j++;
        }
        return head;
    }
    public static boolean palindrome(LinkedListNode head)
    {
        boolean a = true;
        LinkedListNode headcopy = new LinkedListNode(head.value);
        LinkedListNode originalRef = head;
        LinkedListNode copyRef = headcopy;

        while(originalRef != null)
        {
            copyRef.value = originalRef.value;
            copyRef.next = new LinkedListNode(0);
            copyRef = copyRef.next;
            originalRef = originalRef.next;
        }

        head = reverse(head);

        originalRef = head;
        copyRef = headcopy;

        while(originalRef!=null)
        {
            if(originalRef.value!=copyRef.value)
            {
                a = false;
                return a;
            }
            copyRef = copyRef.next;
            originalRef = originalRef.next;

        }
        return a;
    }
}
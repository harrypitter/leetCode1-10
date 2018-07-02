package leetCode;

/**
 * Created by Lidu on 18/7/2.
 */

import baseDataStructure.ListNode;
import baseDataStructure.Node;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

    public AddTwoNumbers() {
    }

    public ListNode addList(ListNode listNodeOne, ListNode listNodeTwo)
    {
        int lengthOne = listNodeOne.length();
        int lenghtTwo = listNodeTwo.length();
        int shortLenght = 0;
        int longLength = 0;
        ListNode longList = new ListNode();
        if(lengthOne<lenghtTwo)
        {
            shortLenght = lengthOne;
            longLength = lenghtTwo;
            longList = listNodeTwo;
        }
        else
        {
            shortLenght = lenghtTwo;
            longLength = lengthOne;
            longList = listNodeOne;
        }
        int offset = 0;

        ListNode resultNode = new ListNode();

        for(int i=1;i<=longLength;i++)
        {
            if(i<=shortLenght) {
                Node nodeOne = listNodeOne.getNodeByIndex(i);
                Node nodeTwo = listNodeTwo.getNodeByIndex(i);

                int value = nodeOne.getData() + nodeTwo.getData();
                if (offset == 1) {
                    value++;
                    offset = 0;
                }
                if (value >= 10) {
                    offset = 1;
                }
                Node resultNodeData = new Node();
                resultNodeData.setData(value % 10);
                resultNode.addNode(resultNodeData);
            }
            else
            {
                Node nodeTemp = longList.getNodeByIndex(i);
                int values = nodeTemp.getData();
                if(offset == 1)
                {
                    values++;
                    offset = 0;
                }
                Node resultNodeData = new Node(values);
                resultNode.addNode(resultNodeData);
            }
        }
        return  resultNode;
    }

    public static void main(String[] args) {

        Node node1=new Node(4);
        Node node2=new Node(5);
        Node node3=new Node(6);
        Node node4=new Node(7);

        Node node5=new Node(8);
        Node node6=new Node(0);
        Node node7=new Node(9);
        Node node8=new Node(4);
        Node node9=new Node(3);
        Node node10=new Node(2);
        Node node11=new Node(1);

        ListNode listNodeOne = new ListNode();
        ListNode listNodeTwo = new ListNode();
        listNodeOne.addNode(node1);
        listNodeOne.addNode(node2);
        listNodeOne.addNode(node3);
        listNodeOne.addNode(node4);

        listNodeTwo.addNode(node5);
        listNodeTwo.addNode(node6);
        listNodeTwo.addNode(node7);
        listNodeTwo.addNode(node8);
        listNodeTwo.addNode(node9);
        listNodeTwo.addNode(node10);
        listNodeTwo.addNode(node11);

        listNodeOne.showAllData();
        listNodeTwo.showAllData();

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        ListNode result = addTwoNumbers.addList(listNodeOne,listNodeTwo);
        result.showAllData();



    }
}

package baseDataStructure;

/**
 * Created by Lidu on 18/7/2.
 */

/**
 * 单链表
 */
public class ListNode {
    public Node first;

    //头结点

    public ListNode() {
        this.first = null;//初始创建 头部节点指向空
    }



    //增加一个节点
    public void addNode(Node node)
    {
        if(this.first ==null)
        {
            this.first = node;
            first.next = null;
        }
        else
        {
            Node tempNode = this.first;

            while (tempNode.getNext()!=null)
            {
                tempNode = tempNode.getNext();
            }

            tempNode.setNext(node);
            node.setNext(null);
        }
    }

    //获取链表的长度
    public int length()
    {
        int lenght = 0;
        Node tempNode = first;
        if(tempNode == null )
        {
            return 0;
        }

        while (tempNode!=null)
        {
            lenght++;
            tempNode=tempNode.getNext();
        }
        return lenght;
    }

    //删除指定位置节点
    public void delete(int index)
    {
        if(first==null)
        {
            System.out.println("链表为空链表,无法执行删除操作");
            return;
        }

        if(index>length())
        {
            System.out.println("长度位置超过链表长度！");
            return;
        }
        else
        {
            Node tempNode = first;
            for(int i=1;i<length();i++)
            {
                if(i==index)
                {
                    Node stackNode = tempNode.getNext();
                    tempNode.setNext(stackNode.getNext());
                    return;
                }
                else{
                    tempNode = tempNode.getNext();
                }
            }
        }
    }



    //增加指定位置的节点
    public void addNodeByIndex(int index,Node node)
    {
        if(index>length())
        {
            try {
                throw new Exception("位置坐标输入错误，超过链表长度");
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("捕获位置坐标异常");
            }
        }
        else if(index == 1)
        {
            Node backNode = first;
            first = node;
            node.setNext(backNode);
        }
        else
        {
            Node frontNode = getNodeByIndex(index-1);
            Node backNode = frontNode.getNext();
            frontNode.setNext(node);
            node.setNext(backNode);
        }
    }

    //显示节点的信息

    //查找指定位置的节点
    public Node getNodeByIndex(int index)
    {
        if(index>length())
        {
            try {
                throw new Exception("指定位置超过链表长度");
            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("捕获数据长度异常");
            }
            return null;
        } else
        {
            Node tempNode = first;
            for(int i = 1;i<=length();i++)
            {
                if(i<index) {
                    tempNode = tempNode.getNext();
                }
                else
                {
                    break;
                }
            }
            return tempNode;
        }
    }

    //显示链表信息
    public void showAllData()
    {
        if(length()==0)
        {
            System.out.println("链表中没有值！");
        }
        else
        {
            String dataInfo = "";
            int le = length();
            for(int i=1;i<=le;i++) {
                if (i == 1) {
                    dataInfo = this.getNodeByIndex(i).getData().toString();
                } else
                {
                    dataInfo = dataInfo + "-->" + this.getNodeByIndex(i).getData();
                }
            }
            System.out.println(dataInfo);
        }
    }



}

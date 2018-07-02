package baseDataStructure;

/**
 * Created by Lidu on 18/7/2.
 */

/**
 * 节点类
 */
public class Node {
    protected Node next;
    private Integer data;

    public Node() {
    }

    public Node(Integer data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}

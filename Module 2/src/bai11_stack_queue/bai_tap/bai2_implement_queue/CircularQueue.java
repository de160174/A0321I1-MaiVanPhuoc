package bai11_stack_queue.bai_tap.bai2_implement_queue;

public class CircularQueue {
    private static class Node{
        private int data;
        private Node link;
    }

    private static class Queue{
        private Node front;
        private Node rear;
    }
    //create
    public static void enQueue(Queue q,int value){
        Node temp=new Node();
        temp.data=value;
        if(q.front==null){
            q.front=temp;
        }else {
            q.rear.link=temp;
        }
        q.rear=temp;
        q.rear.link=q.front;
    }
    //delete
    public static int deQueue(Queue q){
        if(q.front==null){
            System.out.println("queue is empty");
            return Integer.MIN_VALUE;
        }
        // Nếu đây là nút cuối cùng bị xóa
        int value;
        if(q.front==q.rear){
            value=q.front.data;
            q.front=null;
            q.rear=null;
        }else{// Có nhiều hơn một nút
            Node temp=q.front;
            value=temp.data;
            q.front=q.front.link;
            q.rear.link=q.front;
        }
        return value;
    }

    public static void displayQueue(Queue q) {
        Node temp=q.front;
        System.out.println("Các phần tử trong Hàng đợi là:");
        while(temp.link!=q.front){
            System.out.println(temp.data);
            temp=temp.link;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        // Tạo một hàng đợi và khởi tạo front và rear
        Queue q=new Queue();
        q.front=q.rear=null;
        // Chèn các phần tử
        enQueue(q,14);
        enQueue(q,22);
        enQueue(q,6);
        //hiện phần tử
        displayQueue(q);
        //xóa phần tử
        System.out.println("delete value "+deQueue(q));
        //phần tử còn lại
        displayQueue(q);
        enQueue(q,9);
        enQueue(q,20);
        displayQueue(q);
    }
}

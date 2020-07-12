public class TestMyCircularDeque extends BaseRunner {
    
    public void run () {
        MyCircularDeque circularDeque = new MyCircularDeque(3);
        boolean isFull = false;
        boolean success = false;
        isFull = circularDeque.insertFront(1);
        isFull = circularDeque.insertFront(2);
        isFull = circularDeque.isFull();
        isFull = circularDeque.insertLast(3);
        isFull = circularDeque.isFull();
        success = circularDeque.insertFront(4);
        int gear = circularDeque.getRear();
        success = circularDeque.deleteLast();
        success = circularDeque.insertFront(4);
        int front = circularDeque.getFront();
    }

    public String getName () { 
        return "TestMyCircularDeque"; 
    }
}
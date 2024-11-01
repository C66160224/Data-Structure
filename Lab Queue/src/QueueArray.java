public class QueueArray implements Queue {
    private int count ;
    private int front ;
    private int back ;
    private Object[] Array_queue;
    private int max;

    public QueueArray(int size){
        count = 0;
        front = 0;
        back = 0;
        Array_queue = new Object[size];
        max = size;
    }

    public boolean isFull(){
        return back == max;
    }

    public void enqueue(Object value){
        if (isFull()){
            throw new ArrayIndexOutOfBoundsException("is full");
        }
        Array_queue[back] = value;
        count++;
        back++;
    }

    public Object dequeue(){
        if (isEmpty()){
            throw new ArrayIndexOutOfBoundsException("is empty");
        }

        Object queue_array_temp = new Object();
        queue_array_temp = Array_queue[front];
        Array_queue[front] = null;
        front++;
        count--;
        if (count == 0){
            front = back = 0;
        }
        return queue_array_temp;

    }

    public Object peek(){
        if (isEmpty()){
            throw new ArrayIndexOutOfBoundsException("is empty");
        }
        return Array_queue[front];
    }

    public int size(){
        return count;
    }

    public void show(){
        System.out.print("[");
        for (int i = 0; i < back; i++) {
            if(i == back - 1){
                System.out.print(i + "=>" + Array_queue[i]);
            }
            else {
                System.out.print(i + "=>" + Array_queue[i] + ", ");
            }
        }
        System.out.println("]");
    }

    public boolean isEmpty(){
        return count == 0;
    }
}

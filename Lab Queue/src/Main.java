import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int size_arr = kb.nextInt();
        QueueArray Queue_array = new QueueArray(size_arr);
        String[] check = new String[3];
        do {
            check = kb.nextLine().split(" ");
            if (check.length > 0 && !check[0].isEmpty()) {
                switch (Integer.parseInt(check[0])) {

                    case 1: // push
                        try {
                            Queue_array.enqueue(Integer.parseInt(check[1]));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2: // pop
                        try {
                            System.out.println(Queue_array.dequeue());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 3: // peek
                        try {
                            System.out.println(Queue_array.peek());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 4: // size
                        System.out.println(Queue_array.size());
                        break;

                    case 5: // show
                        Queue_array.show();
                        break;

                    case 6: // isEmpty
                        if (Queue_array.isEmpty()) {
                            System.out.println("is empty");
                        } else {
                            System.out.println("not empty");
                        }
                        break;

                    case 7: // isEmpty
                        if (Queue_array.isFull()) {
                            System.out.println("is full");
                        } else {
                            System.out.println("not full");
                        }
                        break;

                }
            }
        } while (!check[0].equals("-99"));
    }

}
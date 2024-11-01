import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        QueueLink Queue_link = new QueueLink();
        String[] check = new String[3];
        do {
            check = kb.nextLine().split(" ");
            if (check.length > 0 && !check[0].isEmpty()) {
                switch (Integer.parseInt(check[0])) {
                    case 1: // push
                        try {
                            Queue_link.enqueue(Integer.parseInt(check[1]));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2: // pop
                        try {
                            System.out.println(Queue_link.dequeue());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 3: // peek
                        try {
                            System.out.println(Queue_link.peek());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 4: // size
                        System.out.println(Queue_link.size());
                        break;

                    case 5: // show
                        Queue_link.show();
                        break;

                    case 6: // isEmpty
                        if (Queue_link.isEmpty()) {
                            System.out.println("is empty");
                        } else {

                            System.out.println("not empty");
                        }
                        break;

                }
            }
        } while (!check[0].equals("-99"));

    }
}

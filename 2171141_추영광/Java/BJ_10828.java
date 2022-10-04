import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private int[] array;
    private int index;

    Main(int i) {
        array = new int[i];
        index = 0;
    }

    public void push(int i) {
        array[index] = i;
        index += 1;
    }

    public int size() {
        return index;
    }

    public int empty() {
        if (index <= 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public int pop() {
        try {
            return array[--index];
        } catch (ArrayIndexOutOfBoundsException e) {
            index = 0;
            return -1;
        }
    }

    public int top() {
        try {
            return array[index - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int i = Integer.parseInt(bf.readLine());
            Main m = new Main(i);

            for (int n = 0; n < i; n++) {
                String order = bf.readLine();
                String[] orderArr = order.split(" ");
                switch (orderArr[0]) {
                    case "push":
                        m.push(Integer.parseInt(orderArr[1]));
                        break;

                    case "size":
                        System.out.println(m.size());
                        break;

                    case "empty":
                        System.out.println(m.empty());
                        break;

                    case "pop":
                        System.out.println(m.pop());
                        break;

                    case "top":
                        System.out.println(m.top());
                        break;
                }
            }
        } catch (IOException e) {

        }

    }
}
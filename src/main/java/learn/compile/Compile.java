package learn.compile;


import java.util.HashSet;
import java.util.Set;

public class Compile {

    int counter = 0;
    String[] program = new String[100];
    static Compile c = new Compile();


    public static void main(String[] args) {
        System.out.println(c.add(32,221));
        System.out.println(c.add(32,222));
        System.out.println(c.add(32,223));
        System.out.println(c.add(32,224));

        System.out.println(c.add(5,5));
        System.out.println(c.add(5,6));

        System.out.println(c.multi(5,6));
        System.out.println(c.multi(13,7));
        System.out.println(c.multi(12,12));
        System.out.println(c.multi(15,15));

        String input = "let x : add 5 3";
        String input1 = "let y : multi 5 x";
        System.out.println(c.execute(input));
        System.out.println(c.execute(input1));

    }

    public boolean and(boolean b1, boolean b2) {
        return b1 && b2;
    }

    public boolean or(boolean b1, boolean b2) {
        return b1 || b2;
    }

    public boolean not(boolean b) {
        return !b;
    }
//
//    public void loop(int i, int address) {
//        if (i != 0) {
//            counter = address;
//            read(counter);
//            execute();
//            i --;
//            loop(i, address);
//        }
//    }

    private int execute(String input) {
        String[] inputArray = input.split(" ");
        Set<String> builtin = new HashSet<>();
        builtin.add("add");
        builtin.add("multi");
        int res = -1;
        if (builtin.contains(inputArray[0])) {
            if (inputArray[0].equals("add")) {
                return c.add(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
            } else if (inputArray[0].equals("multi")) {
                return c.multi(Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
            }
        }
        return res;
    }

    private String read(int address) {

        return program[address];
    }



    public int and(int i, int j) {
        boolean b1 = i == 1;
        boolean b2 = j == 1;
        return and(b1, b2) ? 1 : 0;
    }

    public int or(int i, int j) {
        boolean b1 = i == 1;
        boolean b2 = j == 1;
        return or(b1, b2) ? 1 : 0;
    }

    public boolean[] add(boolean[] a, boolean[] b) {
        boolean[] c = new boolean[8];
        boolean temp = false;
        for (int i = 0; i < 8; i++) {
            //有进位
            if (temp) {
                if (and(a[i], b[i])) {
                    c[i] = true;
                    temp = true;
                } else if (or(a[i], b[i])) {
                    c[i] = false;
                    temp = true;
                } else {
                    c[i] = true;
                    temp = false;
                }
            } else {
                if (and(a[i], b[i])) {
                    c[i] = false;
                    temp = true;
                } else {
                    c[i] = or(a[i], b[i]);
                }
            }
        }
        if (temp) {
            System.out.println(("(×_×), 溢出啦!"));
        }
        return c;
    }

    public int multi(int a, int b) {
        int res = b;
        for (int i = 1; i < a; i++) {
            res = add(res, b);
        }
        return res;
    }

    public int add(int a, int b) {
        return binaryToDecimal(add(decimalToBinary(a), decimalToBinary(b)));
    }

    public boolean[] decimalToBinary(int i) {
        boolean[] a = new boolean[8];
        int p = 0;
        while (i != 0) {
            a[p] = i % 2 == 1;
            i /= 2;
            p ++;
        }
        return a;
    }

    public int binaryToDecimal(boolean[] a) {
        int res = 0;
        for (int i = 0; i < 8; i++) {
            int tem = a[i] ? 1 : 0;
            res = res + tem * pow(2, i);
        }
        return res;
    }

    public int pow(int i, int j) {
        if (j == 0) {
            return 1;
        }
        int res = i;
        for (int x = 1; x < j; x++) {
            res *= i;
        }
        return res;
    }

}

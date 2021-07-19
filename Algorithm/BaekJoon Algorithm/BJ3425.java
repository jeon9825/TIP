package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BJ3425 {

    static class Comm {
        String command;
        long parameter;

        public Comm(String command, long parameter) {
            this.command = command;
            this.parameter = parameter;
        }
    }

    private static List<Comm> comms;
    private static StringBuilder builder;
    private static final int MAX = 1000000000;

    private static boolean input(BufferedReader reader) throws IOException {
        String s = reader.readLine();

        if (s.equals("QUIT")) {
            System.out.println(builder.toString());
            return true;
        }

        while (!s.equals("END")) {
            long parameter = 0;
            String command;
            if (s.length() <= 3)
                command = s.substring(0, 3);
            else {
                command = s.substring(0, 3);
                parameter = Long.parseLong(s.substring(4));
            }
            comms.add(new Comm(command, parameter));
            s = reader.readLine();
        }
        return false;
    }

    private static boolean num(Stack<Long> stack, long parameter) {
        if (Math.abs(parameter) > Math.pow(10, 9))
            return false;

        stack.push(parameter);
        return true;
    }

    private static boolean pop(Stack<Long> stack) {
        if (stack.empty())
            return false;

        stack.pop();
        return true;
    }

    private static boolean inv(Stack<Long> stack) {
        if (stack.empty())
            return false;

        Long val = stack.pop();
        stack.push(val * -1);
        return true;
    }

    private static boolean dup(Stack<Long> stack) {
        if (stack.empty())
            return false;

        Long val = stack.peek();
        stack.push(val);
        return true;
    }

    private static boolean swp(Stack<Long> stack) {
        if (stack.size() < 2)
            return false;

        Long val1 = stack.pop();
        Long val2 = stack.pop();

        stack.add(val1);
        stack.add(val2);
        return true;
    }

    private static boolean add(Stack<Long> stack) {
        if (stack.size() < 2)
            return false;

        Long val1 = stack.pop();
        Long val2 = stack.pop();

        long sum = val1 + val2;

        if (sum > MAX || sum < MAX * -1)
            return false;

        stack.add(sum);
        return true;
    }

    private static boolean sub(Stack<Long> stack) {
        if (stack.size() < 2)
            return false;

        Long val1 = stack.pop();
        Long val2 = stack.pop();

        long sub = val2 - val1;

        if (sub > MAX || sub < MAX * -1)
            return false;

        stack.add(sub);
        return true;
    }

    private static boolean mul(Stack<Long> stack) {
        if (stack.size() < 2)
            return false;

        Long val1 = stack.pop();
        Long val2 = stack.pop();

        long mul = val1 * val2;
        if (mul > MAX || mul < MAX * -1)
            return false;

        stack.add(mul);
        return true;
    }

    private static boolean div(Stack<Long> stack) {
        if (stack.size() < 2)
            return false;

        Long val1 = stack.pop();
        Long val2 = stack.pop();

        if (val1 == 0)
            return false;

        int minusCount = 0;
        if (val1 < 0)
            minusCount++;
        if (val2 < 0)
            minusCount++;

        long div = Math.abs(val2) / Math.abs(val1);
        if (minusCount == 1)
            div *= -1;

        if (div > MAX || div < MAX * -1)
            return false;

        stack.add(div);
        return true;
    }

    private static boolean mod(Stack<Long> stack) {
        if (stack.size() < 2)
            return false;

        Long val1 = stack.pop();
        Long val2 = stack.pop();

        if (val1 == 0)
            return false;

        long mod = Math.abs(val2) % Math.abs(val1);

        if (val2 < 0)
            mod *= -1;

        if (mod > MAX || mod < MAX * -1)
            return false;

        stack.add(mod);
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        builder = new StringBuilder();

        while (true) {
            comms = new ArrayList<>();
            if (input(reader))
                break;

            int t = Integer.parseInt(reader.readLine());
            for (int i = 0; i < t; i++) {
                long value = Long.parseLong(reader.readLine());
                Stack<Long> stack = new Stack<>();
                stack.push(value);

                boolean b = true;
                for (Comm comm : comms) {
                    String command = comm.command;
                    long parameter = comm.parameter;

                    switch (command) {
                        case "NUM":
                            b = num(stack, parameter);
                            break;
                        case "POP":
                            b = pop(stack);
                            break;
                        case "INV":
                            b = inv(stack);
                            break;
                        case "DUP":
                            b = dup(stack);
                            break;
                        case "SWP":
                            b = swp(stack);
                            break;
                        case "ADD":
                            b = add(stack);
                            break;
                        case "SUB":
                            b = sub(stack);
                            break;
                        case "MUL":
                            b = mul(stack);
                            break;
                        case "DIV":
                            b = div(stack);
                            break;
                        case "MOD":
                            b = mod(stack);
                            break;
                    }
                    if (b == false) {
                        break;
                    }

                }
                if (b == false || stack.size() != 1)
                    builder.append("ERROR\n");
                else
                    builder.append(stack.pop() + "\n");
            }
            builder.append("\n");
            reader.readLine();
        }

    }

}

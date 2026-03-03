import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class UseCase13PalindromeCheckerApp {

    public static boolean stackMethod(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static boolean dequeMethod(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

    public static boolean twoPointerMethod(String input) {
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC13: Performance Comparison ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String processed = input.replaceAll("\\s+", "").toLowerCase();

        long start, end;

        start = System.nanoTime();
        boolean stackResult = stackMethod(processed);
        end = System.nanoTime();
        long stackTime = end - start;

        start = System.nanoTime();
        boolean dequeResult = dequeMethod(processed);
        end = System.nanoTime();
        long dequeTime = end - start;

        start = System.nanoTime();
        boolean twoPointerResult = twoPointerMethod(processed);
        end = System.nanoTime();
        long twoPointerTime = end - start;

        System.out.println("\nResults:");
        System.out.println("Stack Method: " + (stackResult ? "PALINDROME" : "NOT PALINDROME") + " | Time: " + stackTime + " ns");
        System.out.println("Deque Method: " + (dequeResult ? "PALINDROME" : "NOT PALINDROME") + " | Time: " + dequeTime + " ns");
        System.out.println("Two Pointer Method: " + (twoPointerResult ? "PALINDROME" : "NOT PALINDROME") + " | Time: " + twoPointerTime + " ns");

        scanner.close();
    }
}
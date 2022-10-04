import java.util.*;
import java.lang.*;

class Solution {
    /**
    * @param str: String to be tested for validity
    * @return boolean: Returns true if the string is valid else false
    */
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0 ) return true;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '}' || c == ']') stack.push(c);
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
            else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') stack.pop();
            else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') stack.pop();
            else return true;
        }
        return stack.isEmpty();    
    }
}


public class Main {  
   public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (Solution.isValid(s)) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
    }
}
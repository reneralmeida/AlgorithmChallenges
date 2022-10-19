
public class BaseBallGame {
public static void main(String[] args) {
    int[] result = new int[ops.length];
        int index = 0;
        for (String op : ops) {
            if (op.equals("+")) {
                result[index] = result[index - 1] + result[index -2];
                index++;
            }
            else if (op.equals("D")) {
                result[index] = 2 * result[index - 1];
                index++;
            }
            else if (op.equals("C")) {
                index--;
                result[index] = 0;
            }
            else {
                result[index] = Integer.parseInt(op);
                index++;
            }
        }
        int ans = 0;
        for (int resul : result) {
            ans += resul;
        }
        return ans;        
     }
  }
}
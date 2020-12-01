import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Sum {
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader (new FileReader ("Sum.txt"));
      String line = "";
      String answer = "";
      ArrayList<Integer> nums = new ArrayList<>();
      while ((line = br.readLine()) != null) {
        nums.add(Integer.parseInt(line));
      }
      for (int i = 0; i < nums.size(); i++) {
        for (int j = i+1; j < nums.size(); j++) {
          for (int k = j+1; k < nums.size(); k++) {
            if (nums.get(i) + nums.get(j) + nums.get(k) == 2020) {
              System.out.println ("2020 = " + nums.get(i) + " + " + nums.get(j) + " + " + nums.get(k) +
                ", Answer: " + (nums.get(i)*nums.get(j)*nums.get(k)));
              System.exit(0);
            }
          }
        }
      }
        System.out.println ("No answer??");
    } catch (Exception ex) {
      System.err.println ("Shit: " + ex.toString());
      ex.printStackTrace();
    }
  }
}

// 1: 2020 = 1069 + 951, Answer: 1016619
// 2: 2020 = 473 + 405 + 1142, Answer: 218767230
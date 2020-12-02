import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Passwords {
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("input.txt"));
      String line = "";
      int mode = Integer.parseInt(args[0]); // mode 0/1 for parts of today's challenge
      int valid = 0;
      
      while ((line = br.readLine()) != null) {
        String regex = "(\\d+)-(\\d+)\\s(\\w): (.+)";
        int from = 0, to = 0;
        String expected = "", password = "";
        Matcher m = Pattern.compile(regex).matcher(line);
        if (m.matches()) {
          from = Integer.parseInt(m.group(1));
          to = Integer.parseInt(m.group(2));
          expected = m.group(3);
          password = m.group(4);
          
          if (mode == 0) {
            String newPass = password.replace(expected, "");
            int length = password.length() - newPass.length();
            if (length >= from && length <= to) {
              valid++;
            }
          } else if (mode == 1) { // Reusing code I used in mode 0
            int matches = 0;
            if ((""+password.charAt(from-1)).equals(expected)) matches++;
            if ((""+password.charAt(to-1)).equals(expected)) matches++;
            if (matches == 1) {
              valid++;
            }
          }
        } else {
          System.out.println ("Malformed line, skipping: " + line);
        }
      }
      System.out.println ("valid: " + valid);
    } catch (Exception ex) {
      System.err.println("Damn: " + ex.toString());
      ex.printStackTrace();
    }
  }
}
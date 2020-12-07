import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Customs {
  static int sumAny = 0;
  static int sumAll = 0;
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("input.txt"));
      String line = "";
      String temp = "";
      int people = 0;
      while ((line = br.readLine()) != null) {
        if (line.equals("")) {
          countAny(temp);
          countAll(temp, people);
          temp = "";
          people = 0;
        } else {
          temp += line;
          people++;
        }
      }
      countAny(temp);
      countAll(temp, people);
      
      System.out.println ("sumAny: " + sumAny);
      System.out.println ("sumAll: " + sumAll);
    } catch (Exception ex) {
      System.err.println("Poop: " + ex.toString());
      ex.printStackTrace();
    }
  }
  
  static void countAny(String s) {
    int count = 0;
    while (!s.equals("")) {
      count++;
      s = s.replace(""+s.charAt(0),"");
    }
    sumAny += count;
  }
  
  static void countAll(String s, int people) {
    int count = 0;
    while (!s.equals("")) {
      int oldLength = s.length();
      s = s.replace(""+s.charAt(0),"");
      if (oldLength - s.length() == people) {
        count++;
      }
    }
    sumAll += count;
  }
}
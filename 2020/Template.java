import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Template {
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("input.txt"));
      String line = "";
      while ((line = br.readLine()) != null) {
        // TODO
      }
    } catch (Exception ex) {
      System.err.println("Expletive: " + ex.toString());
      ex.printStackTrace();
    }
  }
}
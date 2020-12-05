import java.util.HashMap;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;

public class Binary {
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("input.txt"));
      String line = "";
      int highest = 0;
      int lowest = Integer.MAX_VALUE;
      int seatId = 0;
      HashMap<Integer, Integer> seatIds = new HashMap<>();
      
      while ((line = br.readLine()) != null) {
        line = line.replace("F","0").replace("L","0")
                   .replace("B","1").replace("R","1");
        int row = Integer.parseInt(line.substring(0,7),2);
        int col = Integer.parseInt(line.substring(7,10),2);
        if ((seatId = row*8+col) > highest) {
          highest = seatId;
        }
        if (seatId < lowest) {
          lowest = seatId;
        }
        seatIds.put(seatId, 0);
      }
      
      System.out.println ("High: " + highest);
      
      for (int i = lowest; i < highest; i++) {
        try {
          if (seatIds.get(i) == 1);
        } catch (Exception ex) {
          System.out.println ("Mine: " + i);
        }
      }
    } catch (Exception ex) {
      System.err.println("Balls: " + ex.toString());
      ex.printStackTrace();
    }
  }
}
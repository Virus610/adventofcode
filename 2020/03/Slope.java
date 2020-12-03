import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Slope {
  private static Grid grid = new Grid();
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("input.txt"));
      String line = "";
      
      while ((line = br.readLine()) != null) {
        grid.parseLine(line);
      }
      
      // Part 1:
      System.out.println ("Trees A: " + countTrees(3,1));
      
      // Part 2:
      System.out.println ("Trees B: " + 
        countTrees(1,1) * countTrees(3,1) * countTrees(5,1) * countTrees(7,1) * countTrees(1,2)
      );
    } catch (Exception ex) {
      System.err.println("Hell: " + ex.toString());
      ex.printStackTrace();
    }
  }
  
  private static int countTrees(int x2, int y2) {
    int trees = 0, x = 0, y = 0;
    while (y < grid.height) {
      char c = grid.get(x%grid.width,y);
      if (c == '#') trees++;
      y+=y2;
      x+=x2;
    }
    return trees;
  }
}

class Grid {
  private ArrayList<ArrayList<Character>> tiles;
  
  public int width = 0, height = 0;
  
  public Grid() {
    tiles = new ArrayList<>();
  }
  
  public void parseLine (String line) {
    tiles.add(new ArrayList<>());
    for (char c : line.toCharArray()) {
      tiles.get(tiles.size()-1).add(c);
    }
    if (width == 0) width = line.length();
    height++;
  }
  
  public char get(int x, int y) {
    return (tiles.get(y).get(x));
  }
}
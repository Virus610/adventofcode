import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Passport {
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("input.txt"));
      String line = "";
      int count = 0;
      ArrayList<String> lines = new ArrayList<>();
      String temp = "";
      while ((line = br.readLine()) != null) {
        if (line.trim().equals("")) {
          lines.add(count, temp);
          temp = "";
          count++;
        } else {
          temp += line + " ";
        }
      }
      lines.add(count, temp);
      
      int valid = 0;
      for (String passport : lines) {
        if (isValid(passport)) {
          valid++;
        }
      }
      System.out.println ("Valid A: " + valid);
      
      int valider = 0;
      for (String passport : lines) {
        if (isValider(passport)) {
          valider++;
        }
      }
      System.out.println ("Valid B: " + valider);
    } catch (Exception ex) {
      System.err.println("Crap: " + ex.toString());
      ex.printStackTrace();
    }
  }
  
  static boolean isValid(String s) {
    // These regexes hilariously gather way more than they need to, but it gets the job done
    if (contains(s, ".*?(\\bbyr:.+\\s).*?")
     && contains(s, ".*?(\\biyr:.+\\s).*?")
     && contains(s, ".*?(\\beyr:.+\\s).*?")
     && contains(s, ".*?(\\bhgt:.+\\s).*?")
     && contains(s, ".*?(\\bhcl:.+\\s).*?")
     && contains(s, ".*?(\\becl:.+\\s).*?")
     && contains(s, ".*?(\\bpid:.+\\s).*?")
    ) {
      return true;
    }
    return false;
  }
  
  static boolean isValider(String s) {
    try {
      int byr = Integer.parseInt(get(s, ".*?(\\bbyr:\\d{4}\\s).*?"));
      if (byr < 1920 || byr > 2002) return false;
      
      int iyr = Integer.parseInt(get(s, ".*?(\\biyr:\\d{4}\\s).*?"));
      if (iyr < 2010 || iyr > 2020) return false;
      
      int eyr = Integer.parseInt(get(s, ".*?(\\beyr:\\d{4}\\s).*?"));
      if (eyr < 2020 || eyr > 2030) return false;
      
      String hgtStr = get(s, ".*?(\\bhgt:\\d{2,3}(cm|in)\\s).*?");
      int hgt = 0;
      if (hgtStr.indexOf("cm") != -1) {
        hgt = Integer.parseInt(hgtStr.replace("cm",""));
        if (hgt < 150 || hgt > 193) return false;
      } else if (hgtStr.indexOf("in") != -1) {
        hgt = Integer.parseInt(hgtStr.replace("in", ""));
        if (hgt < 59 || hgt > 76) return false;
      } else return false;
      
      String hcl = get(s, ".*?(\\bhcl:\\#[0-9a-fA-F]{6}\\s).*?");
      if (hcl == null) return false;
      
      String ecl = get(s, ".*?(\\becl:(amb|blu|brn|gry|grn|hzl|oth)\\s).*?");
      if (ecl == null) return false;
      
      String pid = get(s, ".*?(\\bpid:\\d{9}\\s).*?");
      if (pid == null) return false;
      
      return true;
    } catch (Exception ex) { 
      // Meh
    }
    return false;
  }
  
  static boolean contains(String s, String regex) {
    Matcher m = Pattern.compile(regex).matcher(s);
    if (m.matches()) {
      return true;
    }
    return false;
  }
  
  static String get(String s, String regex) {
    Matcher m = Pattern.compile(regex).matcher(s);
    if (m.matches()) {
      return m.group(1).split(":")[1].trim();
    }
    return null;
  }
}
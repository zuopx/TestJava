package percy.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MainApp
 */
public class MainApp {

  public static void main(String[] args) {
    System.out.println('\u00E9');
    System.out.println("\u0065\u0301");
    String s = String.join("\n",
      "lkdal",
      "dladl",
      "kdlad");
    System.out.println(s);

    String str = "成都市(成华区)(武侯区)(高新区)";
    Pattern p = Pattern.compile(".*?(?=\\()");
    Matcher m = p.matcher(str);
    if(m.find()) {
        System.out.println(m.group());
    }
  }
}
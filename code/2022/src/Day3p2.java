import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Day3p2 {
  public static void main(String[] args) throws Exception {
    List<Set<Character>> commonList = new ArrayList<>();
    Set<Character> set1 = new HashSet<>();
    Set<Character> set2 = new HashSet<>();
    Set<Character> set3 = new HashSet<>();
    
    try {
        File myFile = new File("../inputs/day3.txt");
        Scanner myReader = new Scanner(myFile);
        int j = 1;
        while(myReader.hasNextLine()) {
            String data = myReader.nextLine();
            for(int i=0; i<data.length(); i++) {
              if (j==1) {
                set1.add(data.charAt(i));
              } else if (j==2) {
                set2.add(data.charAt(i));
              } else if (j==3) {
                set3.add(data.charAt(i));
              }
            }
            j++;
            if(j>3) {
              j = 1;
              Set<Character> common = new HashSet<>(set1);
              common.retainAll(set2);
              common.retainAll(set3);
              commonList.add(common);
              set1.clear();
              set2.clear();
              set3.clear();
            }
        }
        myReader.close();
    } catch (Exception ex) {
        System.out.println("An error occured");
        ex.printStackTrace();
    }

    int sumPriority = 0;
    for(Set<Character> common: commonList) {
        char ch = common.iterator().next();
        int ascii = (int) ch;
        if(ascii >= 65 && ascii <= 90)
            ascii = ascii - 'A' + 27;
        else
            ascii = ascii - 'a' + 1;
        sumPriority += ascii;
    }
    System.out.println(sumPriority);
    System.out.println(commonList.size());

  }
}

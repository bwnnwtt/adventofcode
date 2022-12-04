import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Day3p1 {
    public static void main(String[] args) throws Exception {
        List<Set<Character>> commonList = new ArrayList<>();
        try {
            File myFile = new File("./code/2022/inputs/day3.txt");
            Scanner myReader = new Scanner(myFile);
            
            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Set<Character> set1 = new HashSet<>();
                Set<Character> set2 = new HashSet<>();
                for(int i=0; i<data.length(); i++) {
                    if(i<data.length()/2) {
                        set1.add(data.charAt(i));
                    } else {
                        set2.add(data.charAt(i));
                    }
                }
                Set<Character> common = new HashSet<>(set1);
                common.retainAll(set2);
                commonList.add(common);
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

    }
}

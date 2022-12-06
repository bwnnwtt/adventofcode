import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day6 {
    public static void main(String[] args) throws Exception {
        List<String> myList = new ArrayList<>();
        try {
            File myFile = new File("./code/2022/inputs/day6.txt");
            Scanner myReader = new Scanner(myFile);
            
            while(myReader.hasNextLine()) {

                myList.add(myReader.nextLine());
            }
            myReader.close();
        } catch (Exception ex) {
            System.out.println("An error occured");
            ex.printStackTrace();
        }

        // solution to part1
        System.out.println(calculatePosition(myList.get(0), 4));
        // solution to part2
        System.out.println(calculatePosition(myList.get(0), 14));
    }

    /**
     * calculates the number of characters to be processed before the first marker
     * @param myString the input string
     * @param size the number of distinct characters
     * @return the number of characters to be processed before the first marker
     */
    private static int calculatePosition(String myString, int size) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        int left = 0;
        for(int right=left; right<myString.length(); right++) {
            Character ch = myString.charAt(right);
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch,0) + 1);
            while(charFreqMap.get(ch) > 1) {
                Character leftChar = myString.charAt(left);
                charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
                if(charFreqMap.get(leftChar) == 0) {
                    charFreqMap.remove(leftChar);
                }
                left++;
            }
            if(charFreqMap.size() == size)
                return right + 1;
        }

        return -1;
    }
}

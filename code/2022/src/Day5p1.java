import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Day5p1 {
    public static void main(String[] args) throws Exception {

        // the data structure is a List of Stack<Character>
        List<Stack<Character>> myStacks = new ArrayList<>();
        // the data structure that stores the file input line by line
        List<String> myList = new ArrayList<>();

        try (Scanner myReader = 
                new Scanner(new File("./code/2022/inputs/day5.txt"))) {

            // read each line in the file and add into myList
            while(myReader.hasNextLine()) {
                myList.add(myReader.nextLine());
            }

        } catch (Exception ex) {
            System.out.println("An error occured");
            ex.printStackTrace();
        }

        // populate the list of stacks
        // i refers to the column number and j refers to the row number in each line of the file
        // i terminal value and j start value is hardcoded based on my puzzle's input
        for(int i=1; i<35; i+=4) {
            Stack<Character> newStack = new Stack<>();
            for(int j=7; j>=0; j--) {
                // checks if the character at the file position is a crate or empty
                if(Character.isAlphabetic(myList.get(j).charAt(i))) {
                    newStack.push(myList.get(j).charAt(i));
                }
            }
            myStacks.add(newStack);
        }

        // move the crates
        for(int i = 10; i<myList.size(); i++) {
            String[] splitLine = myList.get(i).split(" ", 7);
            int move = Integer.parseInt(splitLine[1]); // number of crates to move
            int from = Integer.parseInt(splitLine[3]) - 1; // stack number to move from
            int to = Integer.parseInt(splitLine[5]) - 1; // stack number to move to

            for(int j=0; j<move; j++) {
                Character crate = myStacks.get(from).pop();
                myStacks.get(to).push(crate);
            }
        }

        // output the top of each stack
        // solution for my input is LBLVVTVLP
        for(int i=0; i<myStacks.size(); i++) {
            System.out.println(myStacks.get(i).peek());
        }
    }
}

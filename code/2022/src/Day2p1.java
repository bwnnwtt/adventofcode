import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2p1 {
    public static void main(String[] args) throws Exception {
        List<String> myList = new ArrayList<>();
        try {
            File myFile = new File("../inputs/day2.txt");
            Scanner myReader = new Scanner(myFile);
            
            while(myReader.hasNextLine()) {
                // String data = myReader.nextLine();
                myList.add(myReader.nextLine());
            }
            myReader.close();
        } catch (Exception ex) {
            System.out.println("An error occured");
            ex.printStackTrace();
        }
        
        int signScore = calculateSignScore(myList);
        int roundScore = calculateRoundScore(myList);
        System.out.println(signScore + roundScore);
    }

    private static int calculateSignScore(List<String> myList) {
        int score = 0;
        for(int i=0; i<myList.size(); i++) {
            if (myList.get(i).charAt(2) == 'X') {
                score += 1;
            } else if (myList.get(i).charAt(2) == 'Y') {
                score += 2;
            } else if (myList.get(i).charAt(2) == 'Z') {
                score += 3;
            }
        }
        return score;
    }

    private static int calculateRoundScore(List<String> myList) {
        int score = 0;
        for(int i=0; i<myList.size(); i++) {
            char opponentSign = myList.get(i).charAt(0);
            char mySign = myList.get(i).charAt(2);
            if((opponentSign == 'A' && mySign == 'Y') || 
            (opponentSign == 'B' && mySign == 'Z') || 
            (opponentSign == 'C' && mySign == 'X')) {
                score += 6;
            } else if((opponentSign == 'A' && mySign == 'X') ||
            (opponentSign == 'B' && mySign == 'Y') || 
            (opponentSign == 'C' && mySign == 'Z')) {
                score += 3;
            }
        }

        return score;
    }
}

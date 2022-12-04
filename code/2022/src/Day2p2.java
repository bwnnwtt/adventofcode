import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2p2 {
  public static void main(String[] args) throws Exception {
    List<String> myList = new ArrayList<>();
    try {
        File myFile = new File("../inputs/day2.txt");
        Scanner myReader = new Scanner(myFile);
        
        while(myReader.hasNextLine()) {
            myList.add(myReader.nextLine());
        }
        myReader.close();
    } catch (Exception ex) {
        System.out.println("An error occured");
        ex.printStackTrace();
    }

    int score = calculateScore(myList);
    System.out.println(score);
  }

  private static String chooseShape(String round) {
    String shape = "";
    if(round.charAt(2) == 'X') {
      switch(round.charAt(0)) {
        case 'A':
          shape = "scissors";
          break;
        case 'B':
          shape = "rock";
          break;
        case 'C':
          shape = "paper";
          break;
      }
    } else if (round.charAt(2) == 'Y') {
      switch(round.charAt(0)) {
        case 'A':
          shape = "rock";
          break;
        case 'B':
          shape = "paper";
          break;
        case 'C':
          shape = "scissors";
          break;
      }
    } else if (round.charAt(2) == 'Z') {
      switch(round.charAt(0)) {
        case 'A':
          shape = "paper";
          break;
        case 'B':
          shape = "scissors";
          break;
        case 'C':
          shape = "rock";
          break;
      }
    }
    return shape;
  }

  private static int calculateScore(List<String> myList) {
    int score = 0;
    for(int i=0; i<myList.size(); i++) {
      String shape = chooseShape(myList.get(i));
      score += calculateShapeScore(shape);
      score += calculateOutcomeScore(myList.get(i).charAt(2));
    }

    return score;
  }

  private static int calculateShapeScore(String shape) {
    if(shape.equals("rock")) {
      return 1;
    } else if (shape.equals("paper")) {
      return 2;
    } else if (shape.equals("scissors")) {
      return 3;
    }

    return 0;
  }

  private static int calculateOutcomeScore(char outcome) {
    switch(outcome) {
      case 'X':
        return 0;
      case 'Y':
        return 3;
      case 'Z':
        return 6;
    }

    return 0;
  }
}

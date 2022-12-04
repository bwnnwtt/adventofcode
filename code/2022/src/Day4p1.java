import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4p1 {
  public static void main(String[] args) throws Exception {
    List<String[]> myList = new ArrayList<>();

    // count returns the answer
    int count = 0;
    try {
        File myFile = new File("./code/2022/inputs/day4.txt");
        Scanner myReader = new Scanner(myFile);
        
        while(myReader.hasNextLine()) {
            String[] splitLine = myReader.nextLine().split("[-,]", 5);

            myList.add(splitLine);
        }
        myReader.close();
    } catch (Exception ex) {
        System.out.println("An error occured");
        ex.printStackTrace();
    }

    for(int i=0; i<myList.size(); i++) {
        if((Integer.parseInt(myList.get(i)[0]) <=  Integer.parseInt(myList.get(i)[2])) &&
        (Integer.parseInt(myList.get(i)[1]) >=  Integer.parseInt(myList.get(i)[3]))
        ) { count++; }
        else if ((Integer.parseInt(myList.get(i)[2]) <=  Integer.parseInt(myList.get(i)[0])) &&
        (Integer.parseInt(myList.get(i)[3]) >=  Integer.parseInt(myList.get(i)[1]))
        ) { count++; }
    } 

    System.out.println(count);
}
}

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1p2 {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        try {
            File myFile = new File("./code/2022/inputs/day1.txt");
            Scanner myReader = new Scanner(myFile);
            int sum = 0;
            
            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.length() != 0) {
                    sum += Integer.parseInt(data);
                } else {
                    myList.add(sum);
                    sum = 0;
                }
            }
            myReader.close();
        } catch (Exception ex) {
            System.out.println("An error occured");
            ex.printStackTrace();
        }

        int firstMax = 0;
        int secondMax = 0;
        int thirdMax = 0;
        for(int pointer = 0; pointer < myList.size(); pointer++) {
            if(myList.get(pointer) > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = myList.get(pointer);
            } else if(myList.get(pointer) < firstMax && myList.get(pointer) > secondMax) {
                thirdMax = secondMax;
                secondMax = myList.get(pointer);
            } else if(myList.get(pointer) < secondMax && myList.get(pointer) > thirdMax) {
                thirdMax = myList.get(pointer);
            }
        }

        int threeMaxTotal = firstMax + secondMax + thirdMax;
        System.out.println(threeMaxTotal);

    }
}

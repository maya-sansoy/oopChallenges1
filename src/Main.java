import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int[][] DICEDIAL = {
                {4, 2, 2},
                {4, 4, 4},
                {5, 2, 3},
                {6, 5, 5},
                {5, 5, 6},
                {1, 1, 4},
                {3, 2, 1}
        };


        System.out.println(getProduct(DICEDIAL));
        System.out.println(DuplicateNum(DICEDIAL, 0));
        System.out.println(DuplicateNum(DICEDIAL, 1));
        System.out.println(DuplicateNum(DICEDIAL, 2));
        lowestRT(DICEDIAL);

    }
    public static int DuplicateNum (int[][] array, int row) {

        if (array[row][0] == array[row][1] || array[row][0] == array[row][2]) {
            return array[row][0];
        }
        else if (array[row][1] == array[row][2]) {
            return array[row][1];
        }
        else {
            return 0;
        }
    }
    public static int getProduct(int[][] array) {
        int product = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                product *= array[i][j];
            }
        }
        return product;
    }

    public static void lowestRT(int[][] array) {
        //find sum of each row
        //have variable for lowest sum, rows with that sum, if statement to chekc if it becomes the smallest sum print it out
        // print lowest sum


        int rowsum = 0;
        int lowestsum = getProduct(array);
        int lowestsumindex = 0;



        for (int i = 0; i < array.length; i++) {
            rowsum = 0;
            for (int j = 0; j < array[0].length; j++) {
                rowsum += array[i][j];
            }
            if (rowsum < lowestsum) {
                lowestsum = rowsum;
                lowestsumindex = i;

            }
        }
        System.out.println("the lowest sum is " + lowestsum + ", and occurs in row(s): ");
        for (int i = 0; i< array.length; i++) {
            rowsum = 0;
            for (int j = 0; j < array[0].length; j++) {
                rowsum += array[i][j];
            }
            if (rowsum == lowestsum) {
                System.out.println(i);
            }

        }



    }
}
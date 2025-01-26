public class challenge2 {
    public static void main(String[] args) {
        // One-dimensional string array
        String[] ROUTE_X_NAMES = {
                "Oppox",
                "Thamesley",
                "Brinkley",
                "Kiko",
                "Endsley",
                "Kingsley",
                "Allapay",
                "Kronos",
                "Longlines",
                "Dovely"
        };

        // Two-dimensional double array
        double[][] ROUTE_X_DISTANCES = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1.2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2.2, 1.0, 0, 0, 0, 0, 0, 0, 0, 0},
                {6.6, 3.4, 2.2, 0, 0, 0, 0, 0, 9, 0},
                {5.7, 4.5, 3.5, 1.3, 0, 0, 0, 0, 0, 0},
                {7.1, 5.9, 4.9, 2.7, 1.4, 0, 0, 0, 0, 0},
                {8.0, 6.8, 5.8, 3.6, 2.3, 0.9, 0, 0, 0, 0},
                {10.1, 9.1, 6.9, 4.7, 3.4, 2.0, 1.1, 0, 0, 0},
                {10.5, 9.3, 8.1, 5.9, 4.6, 3.2, 2.3, 1.2, 0, 0},
                {11.3, 10.1, 9.1, 6.9, 5.6, 4.2, 3.3, 2.1, 0.9, 0}
        };

        int[] ROUTE_X_TIMES = {0, 5, 6, 6, 8, 4, 7, 5, 6, 6};


        System.out.println(isValid(ROUTE_X_DISTANCES));
        getDistance("Kronos", "Kiko", ROUTE_X_NAMES, ROUTE_X_DISTANCES);
        getTime("Kronos", "Kiko", ROUTE_X_NAMES, ROUTE_X_TIMES);

    }
    public static boolean isValid(double[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j<array[i].length; j++) {
                if (array[i][j] != 0) {
                    return false;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j<i; j++) {
                if (array[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
    public static void getDistance(String town1, String town2, String[] nameArray, double[][] distanceArray) {
        int indextown1 = nameArray.length + 1;
        int indextown2 = nameArray.length + 1;

        for (int i = 0; i < nameArray.length; i++) {
            if (town1.equals(nameArray[i])) {
                indextown1 = i;
            }
            if (town2.equals(nameArray[i])) {
                indextown2 = i;
            }

        }
        if (indextown2 > nameArray.length || indextown1 > nameArray.length){
            System.out.println("those towns are not in the system");
            return;
        }


        if (indextown2 < indextown1) {
            System.out.println("the distance between the towns " + town1+ " and " +town2+ " is " + distanceArray[indextown1][indextown2] + " km");
        }
        else if (indextown1 < indextown2) {
            System.out.println("the distance between the towns " + town1+ " and " +town2+ " is " + distanceArray[indextown2][indextown1] + " km");
        }
        else {
            System.out.println("you've inputted the same town twice. the distance is 0 km");
        }

    }
    public static void getTime(String town1, String town2, String[] nameArray, int[] minutesArray) {
        int indextown1 = nameArray.length + 1;
        int indextown2 = nameArray.length + 1;
        int totaltime = 0;

        for (int i = 0; i < nameArray.length; i++) {
            if (town1.equals(nameArray[i])) {
                indextown1 = i;
            }
            if (town2.equals(nameArray[i])) {
                indextown2 = i;
            }

        }
        if (indextown2 > nameArray.length || indextown1 > nameArray.length){
            System.out.println("those towns are not in the system");
            return;
        }

        if (indextown2 < indextown1) {
            for (int i = indextown2+1; i<= indextown1; i++) {
                totaltime += minutesArray[i];
            }
            System.out.println("the total time the bus takes between the towns "+town1+" and "+town2+ " is "+totaltime+ " minutes");

        }
        else if (indextown1 < indextown2) {
            for (int i = indextown1+1; i<= indextown2; i++) {
                totaltime += minutesArray[i];
            }
            System.out.println("the total time the bus takes between the towns "+town1+" and "+town2+ " is "+totaltime+ " minutes");
        }
        else {
            System.out.println("you've inputted the same town twice. the total time is 0 m");
        }



    }
}

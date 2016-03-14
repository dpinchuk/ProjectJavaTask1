//Project_1_YAML.

import java.io.IOException;

public class Main extends Methods {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        int arrayNumbers[] = new int[SIZE_OF_ARRAY];

        writeYAMLFile(generateRandomArray(arrayNumbers)); // Write data to the file
//        System.out.println("An array of random numbers is:");
        //showArray(arrayNumbers);

        //System.out.println();
        System.out.println("Data is written to a file: '" + PATH + "'");

//        System.out.println();
//        System.out.println("Numbers from file");
        arrayNumbers = readYAMLFile(); // Read data from the file
//        showArray(arrayNumbers);

//        System.out.println();
        System.out.println("Singular number of array is '" + findSingularNumber(arrayNumbers) + "'"); // Finding singular number

//        System.out.println();
        System.out.println("The program was carried out " + (System.currentTimeMillis() - startTime) + " milliseconds.");
    }

}
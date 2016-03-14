import org.ho.yaml.YamlEncoder;
import java.io.*;
import java.util.Random;

public class Methods implements ConstAndMethodsImplements {

    public static void showArray(int[] arrayNumbers) {
        for (int numbers : arrayNumbers) {
            System.out.print(numbers + "  ");
        }
    }

    // Shuffling array.
    private static void shuffleArray(int[] array) {
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < array.length; i++) {
            int change = i + random.nextInt(array.length - i);
            swap(array, i, change);
        }
    }

    private static void swap(int[] array, int index, int change) {
        int temp = array[index];
        array[index] = array[change];
        array[change] = temp;
    }

    public static int[] generateRandomArray(int[] arrayNumbers) {
        //int[] arrayNumbers = new int[size];
        short i = 0;
        while (i < arrayNumbers.length - 1) {
            arrayNumbers[i] = (int) (Math.random() * SIZE_OF_ARRAY * 10);
            arrayNumbers[i+1] = arrayNumbers[i];
            i += 2;
        }
        arrayNumbers[arrayNumbers.length-1] = (int) (Math.random() * SIZE_OF_ARRAY * 100);
        shuffleArray(arrayNumbers);
        return arrayNumbers;
    }

    public static void writeYAMLFile(int[] arrayNumbers) throws IOException {
        File file = new File(PATH);
        if (!file.exists()) {
            file.createNewFile();
        }
        OutputStream outputStream = new FileOutputStream(file);
        YamlEncoder yamlEncoder = new YamlEncoder(outputStream);
        yamlEncoder.writeObject(arrayNumbers);
        yamlEncoder.close();
        outputStream.close();
    }

    public static int[] readYAMLFile() throws IOException {
        int[] arrayNumber = new int[SIZE_OF_ARRAY];
        try(FileInputStream fileInputStream = new FileInputStream("yaml.yml")) {
            char[] chars = new char[fileInputStream.available()];
            int i = -1;
            int j = 0;
            boolean bool = false;
            String s = "";
            while((i = fileInputStream.read())!= -1) {
                //System.out.print((char)i);
                if ((char)i >= '0' && (char)i <= '9') {
                    s += Character.toString((char) i);
                    bool = true;
                }
                else {
                    if (bool) {
                        arrayNumber[j] = Integer.valueOf(s);
                        s = "";
                        j++;
                        bool = false;
                    }
                }
            }
        }
        catch(IOException ioException) {
            System.out.println(ioException.getMessage());
        }
        return arrayNumber;
    }

    public static int findSingularNumber(int[] arrayNumbers) {
        int singularNumber = 0;
        short i = 0;
        while(i < arrayNumbers.length)
        {
            singularNumber = singularNumber ^ arrayNumbers[i];
            i++;
        }
        return singularNumber;
    }
    //System.out.println("������ �����: " + fin.available() + " ����(�)");

}
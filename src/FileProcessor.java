import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor {
    private String filename;
    private File file;
    private Scanner myScanner;

    public FileProcessor(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void connectToFile() {
        file = new File(filename);
    }

    public ArrayList<String> readFile() {
        ArrayList<String> values = new ArrayList<>();

        try {
            myScanner = new Scanner(file);
            while (myScanner.hasNextLine()) {
                values.add(myScanner.nextLine());
            }
            myScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("run time error " + e.getMessage());
        }
        finally
        {
            return values;
        }
    }

    // Parse the file, convert each row into a female object
    public ArrayList<Female> loadFemaleData() {
        ArrayList<Female> dataset = new ArrayList<>();
        ArrayList<String> lines = readFile();
        for (String line : lines) {
            String[] values = line.split(",");
            if (values.length == 5) {
                dataset.add(new Female(values[0], values[1], values[2], values[3], values[4]));
            }
        }
        return dataset;
    }
}

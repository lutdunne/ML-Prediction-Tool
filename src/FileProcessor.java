import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileProcessor {
    private String filename;
    private File file;
    private Scanner myScanner;
    private PrintWriter pwInput;

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


    public void appendRow(String[] newRow) throws IOException {
        try(FileWriter fw = new FileWriter(filename, true);
            PrintWriter pw = new PrintWriter(fw)) {
            pw.println(String.join(",", newRow));
            System.out.println("New Rows: " + Arrays.toString(newRow));
        }
    }
}

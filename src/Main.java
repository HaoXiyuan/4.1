import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) throws Exception {

        /* ONLY FOR WINDOWS MACHINES*/
        String filePath = "C:\\Users\\X\\Desktop\\Groceries.txt"; // Because '\' is an escape character
        String fileToWrite = "C:\\Users\\X\\Desktop\\GroceriesFormatted.txt";

        String [] array = new String[4];
        String id;
        String itemName;
        String quantity;
        double price;
        //String temp = "";
        String separator = ",";
        double total = 0;


        String filePathForWindows;
        FileReader fileReader = new FileReader(filePath);
        FileWriter filewriter = new FileWriter(fileToWrite);

        BufferedReader reader = new BufferedReader(fileReader);
        BufferedWriter writer = new BufferedWriter(filewriter);

        System.out.println("***************************" + "\n");
        System.out.println("ID# Item Quantity Price (€).");

        String line;

        while((line = reader.readLine()) != null){

            array = line.split(separator);

            price = Double.parseDouble(array[3]);

            total += price;

            System.out.println(line);
            writer.write(line);
            writer.newLine();
        }

        System.out.println("*****************************");
        System.out.println("\n" + "Total price of groceries: " + Math.round(total));
        writer.write("\n" + "Total price of groceries: " + Math.round(total));
        System.out.println("*****************************");

        reader.close();

        writer.flush();
        writer.close();
    }
}

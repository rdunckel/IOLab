package iolab;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOLab {

    public static void main(String[] args) {

        File data = new File("misc" + File.separatorChar + "contacts.txt");

        //Challenge 1
        ArrayList<String> text = readFile(data);
        writeListToConsole(text);

        System.out.println("");

        //Challenge 2
        writeListToConsole(text, 2);

        System.out.println("");

        //Challenge 3
        String line = "Bill,Miller,456 Crystal Avenue,Los Angelas,CA,90225,bill,miller@test.com,444-555-3549";
        appendFile(data, line);
        ArrayList<String> text2 = readFile(data);
        writeListToConsole(text2);

    }

    public static ArrayList<String> readFile(File file) {

        ArrayList<String> lines = new ArrayList();

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            while (line != null) {
                lines.add(line);
                line = in.readLine();  // strips out any carriage return chars
            }

        } catch (IOException ioe) {
            System.out.println("There was an issue reading the file");
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }
        return lines;
    }

    public static void appendFile(File file, String line) {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            out.println(line);
        } catch (IOException ex) {
            System.out.println("There was an issue writing to the file");
        } finally {
            try {
                out.close();
            } catch (Exception e) {
            }
        }

    }

    public static void writeListToConsole(List list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static void writeListToConsole(List list, int index) {
        System.out.println(list.get(index));
    }
}

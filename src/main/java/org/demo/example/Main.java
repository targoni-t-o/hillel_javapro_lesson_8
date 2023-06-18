package org.demo.example;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args)
    {
        String inputPhrase;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a phrase:");
        inputPhrase = scanner.nextLine();

        for (int i = 1; i < 9; i++) {
            String folderName = "./src/main/resources/folder" + i;
            File folder = new File(folderName);
            boolean dirExist = folder.exists();

            if (!dirExist) {
                dirExist = folder.mkdir();
            }

            if (i % 2 == 0 && dirExist) {
                String fileName = folderName + "/file" + i + ".txt";

                if (createFile(fileName)) {
                    writeToFile(fileName, inputPhrase + " " +  i);
                }
            }
        }
    }

    private static boolean createFile(String fileName){
        try {
            File newFile = new File(fileName);

            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
            } else {
                System.out.println("File " + newFile.getName() + " already exists.");
            }

            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

            return false;
        }
    }

    private static void writeToFile(String fileName, String inputPhrase){
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(inputPhrase);
            fileWriter.close();

            System.out.println("Successfully wrote to the file " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
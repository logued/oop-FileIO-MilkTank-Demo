package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Demonstrates a suggested MilkTank class which forms part of your Farm Simulator Project.
 * Demonstrates - reading MilkTank description records form a text file (where each line (record)
 * in the text file represents the details of one Milk Talk).
 * Each record is read, its values are extracted and used as input to a MilkTank constructor
 * to create MilkTank objects. Each object is added to a LIst of MilkTanks.
 */
public class MilkTankApp {

    public static void main(String[] args) {
        MilkTankApp app = new MilkTankApp();
        app.start();
    }
    public void start( ){

        ArrayList<MilkTank> tankList = new ArrayList<>();

        loadMilkTanks(tankList,"milktanks.txt");    // see text file in project pane
        displayMilkTanks(tankList);

        System.out.println("Test the MilkTank methods (best done in JUnit)");
        MilkTank tank = tankList.get(0);    // access the first MilkTank

        tank.addMilkToTank(100);
        double amountRemoved = tank.removeFromMilkTank(150);
        System.out.println("Amount removed from tank = " + amountRemoved);

        tank.addMilkToTank(100);        // should create JUnit tests for this
        System.out.println(tank.toString());
    }

    public static void displayMilkTanks(List<MilkTank> list) {
        for (MilkTank tank : list) {
            System.out.println(tank);
        }
    }

    /**
     * Read MilkTank records from a text file, create MilkTank objects
     * and populate a List of MilkTank objects.
     *
     * @param tankList a MilkTank list to populate
     * @param fileName name of text file as String
     */
    public static void loadMilkTanks(List<MilkTank> tankList, String fileName) {

        System.out.println("In loadMilkTanks() - Loading Milk Tank data records from the text file");

        File inputFile = new File(fileName);

        try (Scanner scanner = new Scanner(inputFile))  // try-with-resources style
        {
            scanner.useDelimiter("[,\r\n]+");     // set comma and newline as the delimiters

            while (scanner.hasNext())
            {
                String name = scanner.next();        // read name as a String
                int capacity = scanner.nextInt();    // read capacity as an int

                // to read a double value use scanner.nextDouble()

                MilkTank tank = new MilkTank(name, capacity);

                tankList.add(tank);
            }

        } catch (FileNotFoundException exception) {
            System.out.println("FileNotFoundException caught." + exception);
        } catch (InputMismatchException exception) {
            System.out.println("InputMismatchException caught." + exception);
        }
    }
}
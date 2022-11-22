package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MilkTankMain {
    public static void main(String[] args) {
        System.out.println("Load Milk Tank from File");
        {
            ArrayList<MilkTank> tankList = new ArrayList<>();
            loadMilkTanks(tankList);
            displayData(tankList);
        }
    }
    public static void displayData(List<MilkTank> list) {
        for (MilkTank tank : list) {
            System.out.println(tank);
        }
    }
    public static void loadMilkTanks(List<MilkTank> tankList) {

        File inputFile = new File("milktanks.txt");

        try (Scanner in = new Scanner(inputFile)) {
            in.useDelimiter("[,\r\n]+");   // set comma and newline as the delimiters

            while (in.hasNext()) {
                String name = in.next();    // read name as a String
                int capacity = in.nextInt();      // read capacity as a String
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
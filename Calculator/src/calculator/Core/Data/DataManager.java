package calculator.Core.Data;

import calculator.Core.Integral.RecIntegral;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    // Save data as text
    public static void saveDataAsText(File file, List<RecIntegral> integrals) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (RecIntegral integral : integrals) {
                writer.write(integral.getTopBorder() + ";" 
                        + integral.getBottomBorder() + ";" 
                        + integral.getStepWidth() + ";" 
                        + integral.getResult());
                writer.newLine();
            }
        }
    }

    // Load data from text
    public static ArrayList<RecIntegral> loadDataFromText(File file) throws IOException {
        ArrayList<RecIntegral> integrals = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 4) {
                    continue;
                } 
                double top = Double.parseDouble(parts[0]);
                double bottom = Double.parseDouble(parts[1]);
                double step = Double.parseDouble(parts[2]);
                double result = Double.parseDouble(parts[3]);
                RecIntegral integral = new RecIntegral(top, bottom, step, result);
                integrals.add(integral);
                
            }
        } catch (Exception e) {
            throw new IOException("Error when load data: " + e.getMessage());
        }
        return integrals;
    }

    // Save data as binary
    public static void saveDataAsBinary(File file, List<RecIntegral> integrals) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(integrals);
        }
    }

    // Load data from binary
    public static ArrayList<RecIntegral> loadDataFromBinary(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<RecIntegral>) ois.readObject();
        }
    }
}

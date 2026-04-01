import java.util.*;
import java.io.*;

public class Runner {
    public static void main(String args[]) {
        try {
            Scanner input = new Scanner(new File("EuropeData.csv"));
            input.nextLine();
            
            ArrayList<Country> countries = new ArrayList<Country>();

            while (input.hasNext()) {
                String[] data = (input.nextLine()).split(",");
                countries.add(new Country(data[1],data[2],Integer.parseInt(data[7]),Integer.parseInt(data[6]),Double.parseDouble(data[8])));
            }
            input.close();

            System.out.println("Data regarding the population of countries in Europe:");
            
            //mean
            int total = 0;
            for (int i = 0; i < countries.size(); i++) {
                total += countries.get(i).getPopulation();
            }

            double mean = total/countries.size();
            System.out.println("Mean population: " + mean);

            //Median
            ArrayList<Integer> pops = new ArrayList<Integer>();
            for (Country con : countries) {
                pops.add(con.getPopulation());
            }
            int[] ordPops = new int[pops.size()];
            
            int totalCountries = pops.size();
            while (pops.size() > 0) {
                int least = pops.get(0);
                int index = 0;
                for (int i = 0; i < pops.size();i++) {
                    if (pops.get(i) < least) {
                        least = pops.get(i);
                        index = i;
                    }
                }
                ordPops[totalCountries - pops.size()] = least;
                pops.remove(index);
            }
            
            if (pops.size() % 2 == 1) {
                System.out.println("Median: " + ordPops[ordPops.length / 2]);
            } else {
                System.out.println("Median: " + (ordPops[ordPops.length / 2] + ordPops[ordPops.length / 2 + 1]) / 2.0);
            }

            //Min
            System.out.println("Min: " + ordPops[0]);

            //Max
            System.out.println("Max: " + ordPops[ordPops.length - 1]);

            //Standard Deviation
            double stdSubtotal = 0;
            for (int pop : ordPops) {
                stdSubtotal += Math.pow(pop - mean,2);
            }
            double std = Math.pow(stdSubtotal / ordPops.length, 0.5);
            System.out.println("Standard Deviation: " + std);


        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

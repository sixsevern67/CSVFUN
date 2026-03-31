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
            
            int total = 0;
            for (int i = 0; i < countries.size(); i++) {
                total += countries.get(i).getPopulation();
            }
            System.out.println("Mean population: " + (total/countries.size()));

            ArrayList<Integer> pops = new ArrayList<Integer>();
            for (Country con : countries) {
                pops.add(con.getPopulation());
            }
            int[] ordPops = new int[pops.size()];
            
            int totalCountries = pops.size();
            while (pops.size() > 0) {
                int least = pops.get(0);
                int index = 0;
                for (int i = 0; pops.size();i++) {
                    if (pops.get(i) < least) {
                        least = pops.get(i);
                        index = i;
                    }
                }
                ordPops[totalCountries - pops.size()] = least;
            }

            System.out.println(ordPops.length);
            
            for (int pop: ordPops) {
                
                System.out.println(pop);
            }
            /*if (pops.size() % 2 == 1) {
                System.out.println("Median: " + pops.get(pops.size() / 2));
            } else {
                System.out.println("Median: " + (pops.get(pops.size() / 2) + pops.get(pops.size() / 2 + 1)) / 2.0);
            }*/


        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

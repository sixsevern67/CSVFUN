import java.util.*;
import java.io.*;

public class Runner {
    public static void main(String args[]) {
        try {
            Scanner input = new Scanner(new File("EuropeData.csv"));
            input.nextLine();
            
            ArrayList<Country> countries = new ArrayList<Country>();

            while (input.hasNext()) {
                String[] data = input.next().split(",");
                countries.add(new Country(data[1],data[2],Integer.parseInt(data[7]),Integer.parseInt(data[6]),Double.parseDouble(data[8])));
            }
            input.close();

            System.out.println("Data regarding the population of countries in Europe:");
            /* 
            int total = 0;
            for (int i = 0; i < countries.size(); i++) {
                total += countries.get(i).getPopulation();
            }
            System.out.println("Mean population: " + (total/countries.size()));*/

            /*ArrayList<Integer> pops = new ArrayList<Integer>();
            pops.add(countries.get(0).getPopulation());
            for (int i = 1; i < countries.size(); i++) {
                for (int j = 0; j < pops.size() - 1; j++) {
                    if (countries.get(i).getPopulation() < pops.get(j)) {
                        pops.set(j, countries.get(i).getPopulation());
                        break;
                    } else if (j == pops.size()) {
                        pops.add(countries.get(i).getPopulation());
                    }
                }
            }
            if (pops.size() % 2 == 1) {
                System.out.println("Median: " + pops.get(pops.size() / 2));
            } else {
                System.out.println("Median: " + (pops.get(pops.size() / 2) + pops.get(pops.size() / 2 + 1)) / 2.0);
            }*/


        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

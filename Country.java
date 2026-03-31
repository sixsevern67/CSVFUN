public class Country {
    private String name;
    private String abbreviation;
    private int population;
    private int area;
    private double latitude;

    public Country(String name, String abbreviation, int population, int area, double latitude) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.population = population;
        this.area = area;
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public int getPopulation() {
        return population;
    }

    public int getArea() {
        return area;
    }

    public int getLatitude() {
        return latitude;
    }

    

    
}
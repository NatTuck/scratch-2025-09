package lab11;

import java.util.List;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class RoadMap {
    TreeMap<String, City> cities;

    RoadMap() {
        cities = new TreeMap<String, City>();
    }

    void addCity(String name, double yy, double xx, List<String> neighbors) {
        var ns = new TreeSet<String>();
        ns.addAll(neighbors);
        var city = new City(xx, yy, ns);
        this.cities.put(name, city);
    }

    City getCity(String name) {
        return this.cities.get(name);
    }

    NavigableSet<String> getNeighbors(String name) {
        return this.getCity(name).ns();
    }

    NavigableSet<String> listCities() {
        return this.cities.navigableKeySet();
    }

    double dist(String name0, String name1) {
        return 5.0;
    }

    static RoadMap getNewHampshire() {
        var mm = new RoadMap();
        mm.addCity("Keene", 1.0, 1.0, List.of("Peterborough", "Claremont", "Hillsboro"));
        mm.addCity("Peterborough", 1.0, 2.0, List.of("Keene", "Nashua", "Hillsboro"));
        mm.addCity("Nashua", 1.0, 3.0, List.of("Peterborough", "Manchester"));
        mm.addCity("Salem", 1.0, 4.0, List.of("Londonderry"));
        mm.addCity("Londonderry", 2.0, 4.0, List.of("Manchester", "Salem"));
        mm.addCity("Manchester", 2.0, 3.0, List.of("Nashua", "Concord", "Londonderry"));
        mm.addCity("Hillsboro", 3.0, 2.0, List.of("Keene", "Peterborough", "Concord"));
        mm.addCity("Portsmouth", 3.0, 5.0, List.of("Concord", "Conway"));
        mm.addCity("Claremont", 4.0, 1.0, List.of("Keene", "Lebanon"));
        mm.addCity("Concord", 4.0, 3.0,
                   List.of("Hillsboro", "Manchester", "Portsmouth", "Tilton", "Lebanon"));
        mm.addCity("Tilton", 5.0, 3.0, List.of("Concord", "Laconia", "Plymouth"));
        mm.addCity("Lebanon", 6.0, 1.0, List.of("Claremont", "Concord"));
        mm.addCity("Laconia", 6.0, 4.0, List.of("Tilton"));
        mm.addCity("Plymouth", 7.0, 3.0, List.of("Tilton", "Lincoln"));
        mm.addCity("Lincoln", 8.0, 3.0, List.of("Plymouth", "Conway", "Gorham"));
        mm.addCity("Conway", 8.0, 5.0, List.of("Portsmouth", "Lincoln", "Gorham"));
        mm.addCity("Gorham", 9.0, 5.0, List.of("Lincoln", "Conway"));
        return mm;
    }
}

record City(double x, double y, TreeSet<String> ns) {
    // no extra methods
}

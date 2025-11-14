package lab11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static lab11.FindPath.findPath;
import java.util.List;

public class FindPathShould {
    RoadMap nh;

    FindPathShould() {
        nh = RoadMap.getNewHampshire();
    }

    @Test
    void find_trivial_path() {
        assertEquals(List.of("Plymouth"), findPath(nh, "Plymouth", "Plymouth"));
    }

    @Test
    void find_short_paths() {
        assertEquals(List.of("Nashua", "Manchester"), findPath(nh, "Nashua", "Manchester"));
        assertEquals(List.of("Lebanon", "Concord", "Hillsboro"),
                     findPath(nh, "Lebanon", "Hillsboro"));
        assertEquals(List.of("Laconia", "Tilton", "Concord", "Portsmouth"),
                     findPath(nh, "Laconia", "Portsmouth"));
    }

    @Test
    void find_longer_paths() {
        assertEquals(List.of("Claremont", "Lebanon", "Concord", "Tilton", "Plymouth"),
                     findPath(nh, "Claremont", "Plymouth"));
        assertEquals(List.of("Concord", "Tilton", "Plymouth", "Lincoln", "Conway"),
                     findPath(nh, "Concord", "Conway"));
    }
} 

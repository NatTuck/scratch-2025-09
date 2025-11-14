package lab11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class FindPath {
    static List<String> findPath(RoadMap mm,
                                 String src,
                                 String dst) {
        var seen = new TreeSet<String>();
        var queue = new MinHeap<CityInfo>((aa, bb) -> compare(aa, bb));

        return findPath(mm, seen, queue, src, src, dst);
    }

    static List<String> findPath(RoadMap mm,
                                 TreeSet<String> seen,
                                 MinHeap<CityInfo> queue,
                                 String src,
                                 String cur,
                                 String dst) {

        seen.add(cur);

        var ys = new ArrayList<String>();
        ys.add(cur);

        if (cur.equals(dst)) {
            return ys;
        }

        var ns = mm.getNeighbors(cur);
        for (var nn : ns) {
            if (seen.contains(nn)) {
                continue;
            }

            System.out.println("Trying path through " + nn);
            var zs = findPath(mm, (TreeSet<String>)(TreeSet<String>)  seen.clone(), queue, src, nn, dst);
            if (zs.size() > 0) {
                for (var zz : zs) {
                    ys.add(zz);
                }
                return ys;
            }
        }

        return List.of();
    }

    static List<String> buildPath(TreeMap<String, CityInfo> infos,
                                  String dst,
                                  String src) {
        var ys = new ArrayList<String>();

        while (!dst.equals(src)) {
            ys.add(dst);
            var di = infos.get(dst);
            dst = di.prev;
        }

        ys.add(src);
        
        Collections.reverse(ys);
        return ys;
    }

    static public int compare(CityInfo aa, CityInfo bb) {
        var ad = Double.valueOf(aa.srcDist);
        var bd = Double.valueOf(bb.srcDist);
        return ad.compareTo(bd);
    }
}

class CityInfo {
    String name;
    String prev;
    double srcDist;
    boolean done;

    CityInfo(String name, String prev, double srcDist) {
        this.name = name;
        this.prev = prev;
        this.srcDist = srcDist;
        this.done = false;
    }
}

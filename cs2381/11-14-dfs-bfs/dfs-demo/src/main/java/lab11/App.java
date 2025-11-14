package lab11;

import java.util.TreeMap;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class App {
    static RoadMap nh;

    public static void main(String[] args) {
        nh = RoadMap.getNewHampshire();

        var frame = new MapWindow(getGraph());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setVisible(true);
    }

    static mxGraph getGraph() {
        var nodes = new TreeMap<String, Object>();

        mxGraph graph = new mxGraph();
        graph.setCellsLocked(true);

        Object top = graph.getDefaultParent();
        graph.getModel().beginUpdate();
        for (var name : nh.listCities()) {
            var city = nh.getCity(name);
            var item = graph.insertVertex(top, name, name, 125 * (city.x() - 0.5),
                                          600 - (60 * city.y()), 90, 40);
            nodes.put(name, item);
        }
        for (var name : nh.listCities()) {
            var c0 = nodes.get(name);
            for (var n1 : nh.getNeighbors(name)) {
                var c1 = nodes.get(n1);
                graph.insertEdge(top, null, "", c0, c1); 
            }
        }
        graph.getModel().endUpdate();

        return graph;
    }

    static void printPath(String src, String dst) {
        System.out.println("Shortest path from " + src + " to " + dst + ":");
        try {
            var path = FindPath.findPath(nh, src, dst);
            System.out.println("  " + path);
        }
        catch (RuntimeException ee) {
            System.out.println("fail: " + ee);
        }
    }
}

class MapWindow extends JFrame {
    String pathSrc;
    mxGraph graph;

    public MapWindow(mxGraph graph) {
        super("Road Map");
        this.graph = graph;
        mxGraphComponent gcomp = new mxGraphComponent(graph);
        gcomp.setConnectable(false);
        gcomp.getGraphControl().addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent ee) {
                onMouse(gcomp, ee);
            }
        });
        getContentPane().add(gcomp);
    }

    void onMouse(mxGraphComponent gcomp, MouseEvent ee) {
        Object cell = gcomp.getCellAt(ee.getX(), ee.getY());
        if (cell == null || graph.getLabel(cell).equals("")) {
            System.out.println("Reset src");
            pathSrc = null;
        }
        else {
            if (pathSrc == null) {
                pathSrc = graph.getLabel(cell);
                System.out.println("start @ " + pathSrc);
            }
            else {
                var pathDst = graph.getLabel(cell);
                App.printPath(pathSrc, pathDst);
            }
        }
    }
}

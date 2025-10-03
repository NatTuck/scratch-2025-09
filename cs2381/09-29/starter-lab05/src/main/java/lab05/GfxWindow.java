package lab05;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GfxWindow extends JPanel implements MouseListener, KeyListener {
    private long frame;
    private Timer timer;
    private List<Shape> shapes;
    private List<Color> colors;
    private GfxApp app;

    GfxWindow(GfxApp app, int width, int height) {
        setPreferredSize(new Dimension(width, height));
        this.frame = 0;
        this.timer = new Timer(40, (ActionEvent _ev) -> tick(this.frame++));
        this.shapes = new ArrayList<>();
        this.colors = new ArrayList<>();
        this.app = app;
    }

    void putShapes(List<Shape> shapes) {
        this.shapes = new ArrayList<>(shapes);
        this.repaint();
    }

    void setColors(List<Color> colors) {
        this.colors = new ArrayList<>(colors);
    }

    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g2d = (Graphics2D) gg;

        g2d.setRenderingHints(Map.of(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON));

        setBackground(Color.WHITE);

        for (int i = 0; i < shapes.size(); i++) {
            if (i < colors.size()) {
                g2d.setColor(colors.get(i));
            } else {
                g2d.setColor(Color.BLACK);
            }
            g2d.fill(shapes.get(i));
        }
    }

    public static Color stringToColor(String name) {
        try {
            return (Color) Class.forName("java.awt.Color")
                    .getField(name)
                    .get(null);
        } 
        catch (Exception _ee) {
            return Color.BLACK;
        }
    }

    public void tick(long frame) {
        app.onTick(this, frame);
    }

    public static void launch(GfxApp app, int width, int height) {
        JFrame fr = new JFrame("GfxWindow");
        var gw = new GfxWindow(app, width, height);
        gw.addMouseListener(gw);
        fr.addKeyListener(gw);
        fr.setContentPane(gw);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
        gw.timer.start();
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // pass
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // pass
    }

    @Override
    public void keyTyped(KeyEvent ev) {
        app.onKey(this, Character.toString(ev.getKeyChar()));
    }

    @Override
    public void mouseClicked(MouseEvent ev) {
        app.onMouse(this, ev.getX(), ev.getY(), ev.getButton());
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // pass
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // pass
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // pass
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // pass
    }
}

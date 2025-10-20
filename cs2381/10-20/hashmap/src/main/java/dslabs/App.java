package dslabs;

public class App {
    public static void main(String[] args) {
        var mm = new HashMap<String, String>();
        mm.put("cow", "moo");
        mm.put("pig", "oink");
        mm.put("sheep", "baa");
        
        System.out.println("Map size = " + mm.size());
        System.out.println("A cow says = " + mm.get("cow"));
        System.out.println("A pig says = " + mm.get("pig"));
        System.out.println("A sheep says = " + mm.get("sheep"));


    }

    static int hashString(String text) {
        int yy = 37;
        for (char cc : text.toCharArray()) {
            yy = 257*yy + 5*cc;
        }
        return yy;
    }
}

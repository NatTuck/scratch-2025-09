package dslabs;

public class App {
    public static void main(String[] args) {
        var mm = new HashMap<String, String>();
        mm.put("cow", "moo");
        mm.put("pig", "oink");
        mm.put("sheep", "baa");
        mm.put("dog", "woof");
        mm.put("cat", "meow");
        
        System.out.println("Map size = " + mm.size());
        System.out.println("Map capacity = " + mm.capacity());
        System.out.println("A cow says = " + mm.get("cow"));
        System.out.println("A pig says = " + mm.get("pig"));
        System.out.println("A sheep says = " + mm.get("sheep"));
        System.out.println("A cat says = " + mm.get("cat"));
        
        mm.delete("sheep");
        mm.delete("cat");
        
        System.out.println("Map size = " + mm.size());
        System.out.println("Map capacity = " + mm.capacity());
        System.out.println("A cow says = " + mm.get("cow"));
        System.out.println("A pig says = " + mm.get("pig"));
        System.out.println("A sheep says = " + mm.get("sheep"));
        System.out.println("A cat says = " + mm.get("cat"));

        mm.put("giraffe", "idunno");
        mm.put("horse", "neigh");
        mm.put("cat", "meow");
        mm.put("monkey", "oh oh ah ah");
        mm.put("fox", "ring a ding ding ding");


        System.out.println("Map size = " + mm.size());
        System.out.println("Map capacity = " + mm.capacity());
        System.out.println("A cow says = " + mm.get("cow"));
        System.out.println("A pig says = " + mm.get("pig"));
        System.out.println("A sheep says = " + mm.get("sheep"));
        System.out.println("A cat says = " + mm.get("cat"));
        System.out.println("A horse says = " + mm.get("horse"));
        System.out.println("A fox says = " + mm.get("fox"));


    }

    static int hashString(String text) {
        int yy = 37;
        for (char cc : text.toCharArray()) {
            yy = 257*yy + 5*cc;
        }
        return yy;
    }
}

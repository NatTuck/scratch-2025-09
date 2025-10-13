package lab05;

public class App {
    public static void main(String[] args) {
        Map<String, String> aa = new ArrayMap<String, String>();

        aa.put("Dog", "Woof");
        aa.put("Cat", "Meow");
        aa.put("Cow", "Roar");
        aa.put("Giraffe", "Glarghprn");
        aa.put("Cow", "Moo");

        System.out.println("What does a cat say? " + aa.get("Cat"));
        System.out.println("What does a cow say? " + aa.get("Cow"));
    }
}

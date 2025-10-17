package lab08;

//import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        var xs = ConsList.list(1, 1, 1, 1);
        var ys = addHeightToEach(xs);
        System.out.println(ys);
    }
    
    ConsList<Integer> addHeightToEach(ConsList<Integer> xs) {
        return ahte_helper(xs);
    }
    
    AhteRet ahte_helper(ConsList<Integer> xs) {
        if (xs.isEmpty()) { // O(1)
            return new AhteRet(ConsList.list(), 0);  // O(1)
        }
        else {
            var tmp = ahte_helper(xs.rest()); // O(rest of N)
            return ConsList.cons(
                xs.first() + tmp.height, 
                tmp.ys);  // All O(1)
        }
    }
}

record AhteRet(ConsList<Integer> ys, int height) {

}

 

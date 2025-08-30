package dslabs;

public class App {
    // Program starts executing in the main method of the main class.
    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    // Design recipie, 6 steps:
    // - Javadoc
    // - Stub Method
    // - Tests
    // - Standard pattern for our data
    // - Function body
    // - More tests

    // Write a static method that, given a numerical score for this class
    // determines if it's a passing grade.
      
    /**
     * Determine if the score is a passing grade.
     *
     * @param   score   Out of 100
     * @return          True if this is a passing score
     */
    public static boolean passingGrade(double score) {
        return score > 60.0;
    }



    /**
     * Add 5 to an integer.
     *
     * @param  xx  The input.
     * @return     Five more than the input.
     */
    public static int addFive(int xx) {
        return xx + 5;
    }


    /**
     * Get the user portion of an email address.
     *
     * Examples:
     *   "alice@example.com" => "alice"
     *   "robert.jones@cs.example.edu" => "robert.jones"
     *
     * @param  addr  The email address
     * @return       The user portion
     */
    public static String emailUser(String addr) {
        var at = addr.indexOf("@");
        return addr.substring(0, at);
    }
}

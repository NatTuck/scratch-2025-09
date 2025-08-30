package dslabs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static dslabs.App.addFive;
import static dslabs.App.emailUser;
import static dslabs.App.passingGrade;

public class AppShould {
    @Test
    void passing_grade_works() {
        assertEquals(true, passingGrade(80.0));
        assertEquals(false, passingGrade(8.0));
        assertEquals(true, passingGrade(60.0));
    }
    
    @Test
    void add_five_to_integers() {
        assertEquals(8, addFive(3));
        assertEquals(22, addFive(17));
    }

    @Test
    void get_email_users() {
        assertEquals("alice", emailUser("alice@example.com"));
        assertEquals("robert.jones", emailUser("robert.jones@cs.example.edu"));
    }
}

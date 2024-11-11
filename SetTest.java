import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SetTest {

    @Test
    void toArray() {
        
    }

    @Test
    void insert() {
        // statement coverage

        Set s = new Set();
        ArrayList<Integer> expect = new ArrayList<>();
       // s.insert(1);
        expect.add(1);

        assertTrue(s.getArrayList().equals(expect));
       // s.insert(0);
        expect.add(0,0);
        assertFalse(s.getArrayList().equals(expect));

        System.out.println(Arrays.toString( s.getArrayList().toArray())  + " " + Arrays.toString(expect.toArray()));

        assertTrue(s.getArrayList().equals(expect));


        //branch coverage
    }
    @Test
    void insertBranchCoverage() {
        Set s = new Set();
        int x = 5;
        s.insert(x);
        s.insert(x);
        int[] expected = new int[1];
        expected[0] = 5;
        assertEquals(expected[0], s.toArray());
    }



    @org.junit.jupiter.api.Test
    void member() {
        //adding and then ch. if member
        Set s = new Set();
        s.insert(6);
        s.insert(4);
        s.insert(3);
        assertTrue(s.member(6));
        assertTrue(s.member(4));
        assertFalse(s.member(10));

        //looking at an empty set
        Set s1 = new Set();
        assertFalse(s1.member(2));

        //adding two elements and then extract
        Set s2 = new Set();
        s.insert(2);s.insert(2); 
        assertTrue(s2.member(2));

    }

    @org.junit.jupiter.api.Test
    void intersect() {
    }

    @org.junit.jupiter.api.Test
    void distinctClosed() {
    }
}
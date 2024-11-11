import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntBinaryOperator;

import static org.junit.jupiter.api.Assertions.*;

class SetTest {

    @Test
    void toArray() {
        Set s = new Set();
        s.insert(0);
        s.insert(1);
        s.insert(2);
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 2;
        int[] result = s.toArray();
        assertEquals(expected[0], result[0]);
    }

    @Test
    void insert() {
        // statement coverage
        Set s = new Set();
        ArrayList<Integer> expect = new ArrayList<>();
        s.insert(1);
        expect.add(1);

        assertTrue(s.getArrayList().equals(expect));
        s.insert(0);
        expect.add(0,0);
        System.out.println(Arrays.toString( s.getArrayList().toArray())  + " " + Arrays.toString(expect.toArray()));

        assertTrue(s.getArrayList().equals(expect));
        s.insert(0);
        s.insert(2);
        expect.add(2);

        assertTrue(s.getArrayList().equals(expect));
        // DONE
    }
    @Test
    void insertBranchCoverage() {
        Set s = new Set();
        int x = 5;
        s.insert(x);
        s.insert(x);
        int[] expected = new int[1];
        int[] result = s.toArray();
        expected[0] = 5;
        assertEquals(expected[0], result[0]);
    }



    @Test
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

        //adding two elements and then look for memeber.
        Set s2 = new Set();
        s2.insert(3);
        s2.insert(2);
        assertTrue(s2.member(2));
    }

    @Test
    void intersectBranch() {
        Set s1 = new Set();
        Set s2 = new Set();

        s1.insert(0);
        s1.insert(1);
        s1.insert(2);

        s2.insert(0);
        s2.insert(1);

        s1.intersect(s2);
        //Assert that 0, 1 is a member of s1
        assertTrue(s1.member(0) && s1.member(1) && !s1.member(2));

        //intersect two empty sets
        Set s3 = new Set();
        Set s4 = new Set();
        s3.intersect(s4);
        assertFalse(s3.member(0) && s4.member(0));

        //intersect without overlaping elements
        Set s5 = new Set();
        Set s6 = new Set();
        s5.insert(0);
        s5.insert(1);
        s5.insert(2);
        s6.insert(2);
        s6.insert(3);
        s6.insert(4);
        s5.intersect(s6);
        assertFalse(s5.member(0));
    }
    @Test
    void intersectStatement() {
        Set s1 = new Set();
        Set s2 = new Set();
        assertEquals(s1.member(2), s2.member(2));
        s1.intersect(s2);
        assertEquals(s1.member(2), s2.member(2));

        //Inside for loop
        s1.insert(0);
        s1.insert(1);
        s1.insert(3);

        s2.insert(0);
        s2.insert(1);
        s2.insert(4);

        s1.intersect(s2);
        assertEquals(s1.member(0), s1.member(1));
    }

    @Test
    void distinctClosed() {
        // coverage
        Set s = new Set();
        s.insert(1);
        s.insert(2);
        s.insert(3);
        s.insert(4);
        assertFalse(s.distinctClosed((a,b) -> a+b));
        s = new Set();
        s.insert(0);
        assertTrue(s.distinctClosed((a,b) -> a-b));
        s.insert(1);
        s.insert(2);
        assertTrue(s.distinctClosed((a,b) -> a*b));

    }
}
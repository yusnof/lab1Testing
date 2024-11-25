package ex1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
    void insertAndCompareToArray() {
        // statement coverage
        Set s = new Set();
        ArrayList<Integer> expect = new ArrayList<>();
        s.insert(1);
        expect.add(1);
        assertTrue(s.getArrayList().equals(expect) );}
    @Test
    void insertAndCompareToArray2() {
        // statement coverage
        Set s = new Set();
        ArrayList<Integer> expect = new ArrayList<>();
        s.insert(1);
        expect.add(1);

        s.insert(0);
        s.insert(2);
        expect.add(2);

        assertFalse(s.getArrayList().equals(expect));
    }
    @Test
    void insertAndComapareToArray(){
        Set s = new Set();
        ArrayList<Integer> expect = new ArrayList<>();
        s.insert(1);
        expect.add(1);


        s.insert(0);
        expect.add(0,0);
        System.out.println(Arrays.toString( s.getArrayList().toArray())  + " " + Arrays.toString(expect.toArray()));

        assertTrue(s.getArrayList().equals(expect));
    }
    @Test
    void insert2(){
        Set s = new Set();
        ArrayList<Integer> expect = new ArrayList<>();
        s.insert(1);
        expect.add(1);


        s.insert(0);
        s.insert(2);
        expect.add(2);

        assertFalse(s.getArrayList().equals(expect));
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
    void memberIfCorrect() {
        //adding and then ch. if member
        Set s = new Set();
        s.insert(6);
        s.insert(4);
        s.insert(3);
        assertTrue(s.member(6) && s.member(4) && !s.member(10));
    }
    @Test
    void memberIfEmpty() {
        //looking at an empty set
        Set s1 = new Set();
        assertFalse(s1.member(2));
    }
    @Test
    void memberIfsecond() {
        //adding two elements and then look for memeber.
        Set s2 = new Set();
        s2.insert(3);
        s2.insert(2);
        assertTrue(s2.member(2));
    }
    @Test
    void memeberBranch() {
        Set s = new Set();
        s.insert(5);
        s.insert(6);
        s.insert(7);
        //assertTrue(s.member(1) && s.member(2) && s.member(3) && !s.member(4));
        assertEquals(s.member(4), false);
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
        assertTrue(s2.member(0) && s2.member(1) && !s2.member(2));
/*
        //intersect two empty sets
        ex1.Set s3 = new ex1.Set();
        ex1.Set s4 = new ex1.Set();
        s3.intersect(s4);
        assertFalse(s3.member(0) && s4.member(0));

        //intersect without overlaping elements
        ex1.Set s5 = new ex1.Set();
        ex1.Set s6 = new ex1.Set();
        s5.insert(0);
        s5.insert(1);
        s5.insert(2);
        s6.insert(2);
        s6.insert(3);
        s6.insert(4);
        s5.intersect(s6);
        assertFalse(s5.member(0)); */

    }
    @Test
    void intersectBranch2(){
        //intersect with overlapping elements to enter the else statement in a.get(i) < s.a.get(j)
        Set s7 = new Set();
        Set s8 = new Set();
        s7.insert(4);
        s7.insert(6);
        s7.insert(8);

        s8.insert(2);
        s8.insert(4);
        s8.insert(9);

        s7.intersect(s8);
        assertTrue(s7.member(4));

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


//
//
//

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WorkScheduleTest {
    //Partition 1: starttime < endtime
    //Partition 2: starttime = endtime
    //Partition 3: starttime > endtime && workingEmployee.length > nemployees
    //Partition 4: starttime > endtime && workingEmployee.length < nemployees

    // border case when the nemployees == 0.

    //bug: decrementing the required number of employees will break the method
    @Test
    void setRequiredTestPartition1(){
        WorkSchedule ws = new WorkSchedule(10);
        WorkSchedule.Hour excepted = ws.readSchedule(4);
        ws.setRequiredNumber(3,3,5);
        WorkSchedule.Hour result = ws.readSchedule(4);
        assertSame(excepted, result);
    }

    @Test
    void setRequiredTestPartition2() {
        WorkSchedule ws = new WorkSchedule(10);
        WorkSchedule.Hour expected = ws.readSchedule(0);
        ws.setRequiredNumber(1,0,0);
        ws.addWorkingPeriod("je",0,0);
        //ws.addWorkingPeriod("ja",0,0);
        WorkSchedule.Hour result = ws.readSchedule(0);
        assertSame(expected, result);
    }
    @Test
    void setRequiredTestPartition3()
    {
        WorkSchedule ws = new WorkSchedule(10);
        ws.setRequiredNumber(2,0,5);
        ws.addWorkingPeriod("je",5,3);
        ws.addWorkingPeriod("ja",5,3);

        WorkSchedule.Hour hour = ws.readSchedule(4);
        //hour.workingEmployees = new String[]{"je", "ja"};
        int actual = hour.workingEmployees.length;
        int expected = 2;
        assertSame(expected, actual);
    }

    @Test
    void setRequiredpart4()
    {
        WorkSchedule ws = new WorkSchedule(10);
        ws.setRequiredNumber(5,0,5);
        ws.addWorkingPeriod("je",5,3);
        ws.addWorkingPeriod("ja",5,3);
        WorkSchedule.Hour hour = ws.readSchedule(2);

        assertSame(0,hour.workingEmployees.length);
    }

    @Test
    void setRequiredTestWithEdgeCase(){
        WorkSchedule ws = new WorkSchedule(10);
        ws.setRequiredNumber(0,1,3);
        WorkSchedule.Hour hour = ws.readSchedule(2);
        //TODO add asserting
    }

    // the bug in program is: lower the setRequiredNumber, will breake the method which wrong it should be the updated number of requiredNumber
    @Test
    void Bug1Test(){
        WorkSchedule ws = new WorkSchedule(10);
        //ws.addWorkingPeriod()
        ws.setRequiredNumber(3,0,5);
        ws.addWorkingPeriod("je",0,5);
        ws.addWorkingPeriod("je1",0,5);
        ws.addWorkingPeriod("je2",0,5);
        ws.setRequiredNumber(2,0,5);
        String[] expected = new String[]{"je", "je1"};
        //this should be wrong to show the bug in the program
        assertArrayEquals(expected,ws.workingEmployees(0,5));
    }


    @Test
    public void setRequiredNumberTest()  {
        WorkSchedule ws = new WorkSchedule(10);

        ws.readSchedule(9);
        int size = 5;


        WorkSchedule.Hour h = ws.readSchedule(0);
        int nEmployees = h.requiredNumber;
        String[] employees = h.workingEmployees;
        ws.setRequiredNumber(1,1,5);

        WorkSchedule.Hour hRes = ws.readSchedule(size);
        int EmployeeRes = hRes.requiredNumber;
        String[] employeesRes = hRes.workingEmployees;

        assertEquals(nEmployees, EmployeeRes);
    }



    @Test
    public void nextIncompletePartition1()
    {
        WorkSchedule ws = new WorkSchedule(10);
        ws.setRequiredNumber(1,0,1);

        int expected =  ws.nextIncomplete(3);

        assertEquals(expected, -1);


    }
    @Test
    public void nextIncompletePartition2()
    {
        WorkSchedule ws = new WorkSchedule(10);
        ws.readSchedule(1);
        ws.setRequiredNumber(2,0,9);
        ws.addWorkingPeriod("je",0,9);
        ws.addWorkingPeriod("ja",0,9);
        int working = ws.nextIncomplete(9);
        assertEquals(working,-1);

    }
    @Test
    public void nextIncompleteBorderCase1(){
        WorkSchedule ws = new WorkSchedule(10);
        ws.setRequiredNumber(1,0,1);

        int working = ws.nextIncomplete(0);
        assertEquals(working,1);
    }

    @Test
    public void nextIncompleteBorderCase2(){
        WorkSchedule ws = new WorkSchedule(10);
        ws.setRequiredNumber(1,0,1);
        ws.setRequiredNumber(2,0,9);
        ws.addWorkingPeriod("je",0,9);
        ws.addWorkingPeriod("ja",0,9);
        int working = ws.nextIncomplete(9);
        assertEquals(working,-1);

         ws = new WorkSchedule(10);
        ws.setRequiredNumber(1,0,1);
        ws.setRequiredNumber(2,0,9);
        ws.addWorkingPeriod("je",0,9);
        ws.addWorkingPeriod("ja",0,9);
         working = ws.nextIncomplete(0);
        assertEquals(working,-1);
    }
    // Report on test cases:
    // Input space/Partition: starttime and endtime

    // Block #1: starttime < endtime
    // - Test Case: setRequiredTestPartition1
    //   - Input: starttime = 3, endtime = 3, nemployees = 0
    //   - Expected: WorkSchedule.Hour object remains unchanged

    // Block #2: starttime = endtime
    // - Test Case: setRequiredTestPartition2
    //   - Input: starttime = 0, endtime = 0, nemployees = 0
    //   - Expected: WorkSchedule.Hour object remains unchanged

    // Block #3: starttime > endtime && workingEmployee.length > nemployees
    // - Test Case: setRequiredTestPartition3
    //   - Input: starttime = 5, endtime = 3, nemployees = 1
    //   - Expected: workingEmployees.length = 2

    // Block #4: starttime > endtime && workingEmployee.length < nemployees
    // - Test Case: setRequiredpart4
    //   - Input: starttime = 5, endtime = 3, nemployees = 5
    //   - Expected: No assertion provided

    // Border cases:
    // - Test Case: setRequiredTestWithEdgeCase
    //   - Input: nemployees = 0, starttime = 1, endtime = 3
    //   - Expected: No assertion provided

    // Additional Test Cases:
    // - Test Case: setRequiredNumberTest
    //   - Input: starttime = 1, endtime = 1, nemployees = 5
    //   - Expected: requiredNumber remains unchanged

    // Input space/Partition: currenttime

    // Block #1: there is an hour in the interval currenttime to size - 1 such that the length of workingEmployees
    // is less than requiredNumber
    // - Test Case: nextIncompletePartition1
    //   - Input: currenttime = 3
    //   - Expected: -1

    // Block #2: there is no hour in the interval currenttime to size - 1 such that the length of workingEmployees
    // is less than requiredNumber
    // - Test Case: nextIncompletePartition2
    //   - Input: currenttime = 9
    //   - Expected: -1

    // Border cases:
    // - Test Case: nextIncompleteBorderCase1
    //   - Input: currenttime = 0
    //   - Expected: 1

    // - Test Case: nextIncompleteBorderCase2
    //   - Input: currenttime = 9
    //   - Expected: -1

    // Found bugs:
    // - Test Case: setRequiredpart4 and setRequiredTestWithEdgeCase do not have assertions to verify the expected outcomes.



}

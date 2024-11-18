import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class WorkScheduleTest {
    //Partition 1: starttime < endtime
    //Partition 2: starttime = endtime
    //Partition 3: starttime > endtime && workingEmployee.length > nemployees
    //Partition 4: starttime > endtime && workingEmployee.length < nemployees

    // edge case when the nemployees == 0.
    @Test
    void setRequiredTestPartition1(){
        WorkSchedule ws = new WorkSchedule(10);
        WorkSchedule.Hour excepted = ws.readSchedule(0);
        ws.setRequiredNumber(3,3,0);
        WorkSchedule.Hour result = ws.readSchedule(0);
        assertSame(excepted, result);
    }

    @Test
    void setRequiredTestPartition2() {
        WorkSchedule ws = new WorkSchedule(10);
        WorkSchedule.Hour expected = ws.readSchedule(0);
        ws.setRequiredNumber(1,0,0);
        ws.addWorkingPeriod("je",0,0);
        ws.addWorkingPeriod("ja",0,0);
        WorkSchedule.Hour result = ws.readSchedule(0);
        assertSame(expected, result);
    }
    @Test
    void setRequiredTestPartition3()
    {
        WorkSchedule ws = new WorkSchedule(10);
        ws.setRequiredNumber(1,0,5);
        ws.addWorkingPeriod("je",5,3);
        ws.addWorkingPeriod("ja",5,3);
        WorkSchedule.Hour hour = ws.readSchedule(4);
        int result = hour.workingEmployees.length;
        int expected = 2;
        assertEquals(expected, result);
    }

    @Test
    void setRequiredpart4()
    {
        WorkSchedule ws = new WorkSchedule(10);
        ws.setRequiredNumber(5,0,5);
        ws.addWorkingPeriod("je",5,3);
        ws.addWorkingPeriod("ja",5,3);
        WorkSchedule.Hour hour = ws.readSchedule(2);
    }

    @Test
    void setRequiredTestWithEdgeCase(){
        WorkSchedule ws = new WorkSchedule(10);
        ws.setRequiredNumber(0,1,3);
        WorkSchedule.Hour hour = ws.readSchedule(2);
        //TODO add asserting

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

    //B)
    //inputspace:

    @Test

    public void nextIncomplete()
    {

    }


}

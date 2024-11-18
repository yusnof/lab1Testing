import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkScheduleTest {

    //TODO Partitions?!?!?!
    //TODO Understand the methods ;D
    @Test
    public void setRequiredNumberTest()  {
        int size = 5;
        WorkSchedule ws = new WorkSchedule(10);
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

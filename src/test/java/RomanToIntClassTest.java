import org.example.coding.RomanToIntClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.exceptions.misusing.MissingMethodInvocationException;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

public class RomanToIntClassTest {

    public void fake() { //real impl in simpler way -h2

    }

//    @Test
    public void dummy() { // some variables not being used, employee last name in employee class with Id
        // Mockito.mock(RomanToIntClassTest.class);

    }

    @Test
    public void stub() { //hardcoded answers, consts
        RomanToIntClass ob = Mockito.mock(RomanToIntClass.class); //create mock.stub
        Assertions.assertEquals(0, ob.romanToInt(""));

        Mockito.when(ob.romanToInt("hello")).thenReturn(2);
        Assertions.assertEquals(2, ob.romanToInt("hello"));

        Mockito.verify(ob).romanToInt("");
        Mockito.verify(ob).romanToInt("hello");
//        Mockito.verify(ob).romanToInt("III"); // only 2 interactions

       Mockito.verify(ob, times(1)).romanToInt("hello"); // 0 for print("hello")

        Mockito.verify(ob, times(2)).romanToInt(anyString());
    }

    public void spy() { //record all interactions of real object; how method interacts with dependencies

    }

    public void mock() { // stub that saves all interactions, verify called only once

    }

}

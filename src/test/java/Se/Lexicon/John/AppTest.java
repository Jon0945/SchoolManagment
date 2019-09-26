package Se.Lexicon.John;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;

public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue() {
        String[] test = {"Test"};
        App.main(test);
        assertTrue(Arrays.toString(test).contains("Test"));
    }
}

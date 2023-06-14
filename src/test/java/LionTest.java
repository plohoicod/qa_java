import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sexInput;

    private final boolean hasManeResult;

    private final Feline feline;

    public LionTest(String sexInput, boolean hasManeResult) {
        this.sexInput = sexInput;
        this.hasManeResult = hasManeResult;
        this.feline = Mockito.mock(Feline.class);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }
    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion(sexInput, feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }
    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(sexInput, feline);
        Assert.assertEquals(hasManeResult, lion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(sexInput, feline);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testLionWithInvalidSex() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Используйте допустимые значения пола животного - самей или самка");
        new Lion("Паркет", feline);
    }
}

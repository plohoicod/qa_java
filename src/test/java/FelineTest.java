import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        List<String> result = feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetFamily() {
        Assert.assertEquals(feline.getFamily(), "Кошачьи");
    }

    @Test
    public void testGetKittensWithoutArgument() {
        int expected = 1;
        int result = feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(expected);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetKittensWithArgument() {
        int expected = 10;
        int result = feline.getKittens(expected);
        Assert.assertEquals(expected, result);
    }
}

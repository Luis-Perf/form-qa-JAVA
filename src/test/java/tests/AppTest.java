package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {
    @Test
    public void testeSimples() {
        Assert.assertEquals(2 + 2, 4, "A soma está incorreta!");
    }
}

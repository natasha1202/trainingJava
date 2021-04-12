package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

    @Test
    public void testArea(){
        Square3 s = new Square3(5);
        Assert.assertEquals(s.area(), 25);

    }

}

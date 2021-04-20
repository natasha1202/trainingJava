package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointDistanceTests {

    @Test
    public void testDistance(){
        Point2 punkt1 = new Point2(1,5);
        Point2 punkt2 = new Point2(1, 2);
        Assert.assertEquals(punkt1.distance(punkt2),3);
    }

    @Test
    public void testDistanceSecond(){
        Point2 punkt1 = new Point2(1,6);
        Point2 punkt2 = new Point2(4, 2);
        Assert.assertEquals(punkt2.distance(punkt1),5);
    }

}

package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 {
    @Test
    public void Test1(){
        System.out.println("test run");
        Assert.assertTrue(true);
    }
}

package testngdem;

import org.testng.annotations.*;

public class annotatinsDemo {
    @BeforeTest //run-1
    public void beforeTest()
    {
        System.out.println("this is my before test");
    }
    @BeforeClass //run-2
    public void beforeClass()
    {
        System.out.println("this is before class");
    }
    @BeforeMethod //before method
    public void beforeMethod()
    {
        System.out.println("this is before method");
    }
    @AfterTest //run-7
    public void afterTest()
    {
        System.out.println("this is afterTest");
    }
    @AfterClass  //run-6
    public void afterClass()
    {
        System.out.println("this is after class");
    }
    @AfterMethod //run-5
    public void afterMethod()
    {
        System.out.println("this is after method");
    }
    @Test //run-4
    public void testcase_3()
    {
        System.out.println("this is my testcase");
    }

    @Test //run-4
    public void testcase_2()
    {
        System.out.println("this is my second testcase");
    }
    @Test //run-4
    public void testcase_1()
    {
        System.out.println("this is my second testcase");
    }

}

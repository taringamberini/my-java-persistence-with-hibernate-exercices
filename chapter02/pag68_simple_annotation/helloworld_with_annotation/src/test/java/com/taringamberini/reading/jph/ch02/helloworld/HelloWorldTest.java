package com.taringamberini.reading.jph.ch02.helloworld;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * @author Tarin Gamberini <www.taringamberini.com>
 */
public class HelloWorldTest {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @org.junit.Test
    public void testSayHello() {
        HelloWorld instance = new HelloWorld();
        instance.sayHello();
        Assert.assertTrue(true);
    }
}

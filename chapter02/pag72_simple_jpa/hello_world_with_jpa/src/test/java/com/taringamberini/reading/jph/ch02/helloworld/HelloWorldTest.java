package com.taringamberini.reading.jph.ch02.helloworld;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Tarin Gamberini <www.taringamberini.com>
 */
public class HelloWorldTest {

    public HelloWorldTest() {
    }

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

    @Test
    public void testSayHello() {
        HelloWorld instance = new HelloWorld();
        instance.sayHello();
        Assert.assertTrue(true);
    }
}
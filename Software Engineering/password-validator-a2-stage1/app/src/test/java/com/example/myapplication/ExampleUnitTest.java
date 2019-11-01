package com.example.myapplication;

import org.junit.Test;
import static com.example.myapplication.Validator.validate;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {
    @Test
    public void password_first() { assertEquals( 0, validate("password"));}

    @Test
     public void password_second() {assertEquals(1, validate("P4ssword"));}

     @Test
     public void password_third() {assertEquals(2, validate("tbsj6hsnal"));}

}

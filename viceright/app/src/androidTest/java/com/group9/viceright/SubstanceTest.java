package com.group9.viceright;

import com.group9.viceright.model.Substance;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class SubstanceTest {
    @Test
    public void testNamePull(){
        Substance substance = new Substance();
        substance.name = "Coffee";
        List<Substance> subs = new ArrayList<Substance>();
        subs.add(substance);
        Substance polledSub = Substance.poll(subs, "Coffee");
        assertEquals(polledSub.name, "Coffee");
    }
}

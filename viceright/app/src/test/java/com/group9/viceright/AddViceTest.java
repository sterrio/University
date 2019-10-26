package com.group9.viceright;

import com.group9.viceright.model.Substance;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddViceTest {

    @Test
    public void viceTest(){

        Substance sub = new Substance();
        assertNotNull(sub);

    }

    @Test
    public void viceNameTest(){

        String name = "Heroin";
        Substance sub = new Substance(name, "", Double.parseDouble("1"), true, "");
        assertEquals(name, sub.name);

    }

    @Test
    public void viceDescTest(){

        String desc = "Some pretty gnarly stuff";
        Substance sub = new Substance("", desc, Double.parseDouble("1"), true, "");
        assertEquals(desc, sub.description);

    }

    @Test
    public void viceWarningTest(){

        double max = 45;
        Substance sub = new Substance("", "", max, true, "");
        assertEquals(max, sub.maxWarning, 0);

    }

    @Test
    public void vicePermTest(){

        Boolean perm = true;
        Substance sub = new Substance("", "", Double.parseDouble("1"), perm, "");
        assertEquals(perm, sub.govHidden);

    }

    @Test
    public void viceImgTest(){

        String img = "Image";
        Substance sub = new Substance("", "", Double.parseDouble("1"), true, img);
        assertEquals(img, sub.image);

    }

}
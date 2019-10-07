package org.manager.data.personal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenderProcessorImplTest {

    private GenderProcessor genderProcessor;


    @Before
    public void setup(){
        genderProcessor = new GenderProcessorImpl();
    }

    @Test
    public void processWithEmpty() {
        Person p = new Person();
        genderProcessor.process(p, "");
        assertEquals(GenderEnum.Unknown, p.getGender());
    }

    @Test
    public void processWithNull() {
        Person p = new Person();
        genderProcessor.process(p, null);
        assertEquals(GenderEnum.Unknown, p.getGender());
    }

    @Test
    public void processMale() {
        Person p = new Person();
        genderProcessor.process(p, "Male");
        assertEquals(GenderEnum.Male, p.getGender());
    }

    @Test
    public void processMaleDifferentCase() {
        Person p = new Person();
        genderProcessor.process(p, "MaLe");
        assertEquals(GenderEnum.Male, p.getGender());
    }

    @Test
    public void processFemale() {
        Person p = new Person();
        genderProcessor.process(p, "Female");
        assertEquals(GenderEnum.Female, p.getGender());
    }

    @Test
    public void process() {
        Person p = new Person();
        genderProcessor.process(p, "Unknown");
        assertEquals(GenderEnum.Unknown, p.getGender());
    }
}
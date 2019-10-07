package org.manager.data.personal.processor;

import org.junit.Before;
import org.junit.Test;
import org.manager.data.personal.model.Person;
import org.manager.data.personal.processor.DateProcessorImpl;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class DateProcessorImplTest {


    DateProcessorImpl underTest;

    @Before
    public void setup(){
        underTest = new DateProcessorImpl();
    }

    @Test
    public void process() {
        Person p = new Person();
        underTest.process(p, "16/03/77");
        LocalDate expected = LocalDate.of(1977, 3, 16);
        assertEquals(expected, p.getBirthDate());
    }

    @Test
    public void processWithEmptyData() {
        Person p = new Person();
        underTest.process(p, "");
        assertNull(p.getBirthDate());
    }

    @Test
    public void processWithNullData() {
        Person p = new Person();
        underTest.process(p, null);
        assertNull(p.getBirthDate());
    }
}
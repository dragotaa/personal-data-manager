package org.manager.data.personal.processor;

import org.junit.Before;
import org.junit.Test;
import org.manager.data.personal.model.Person;
import org.manager.data.personal.processor.NameProcessor;
import org.manager.data.personal.processor.NameProcessorImpl;

import static org.junit.Assert.*;

public class NameProcessorImplTest {

    private NameProcessor underTest;

    @Before
    public void setup(){
        underTest = new NameProcessorImpl();
    }

    @Test
    public void processNullValue() {
        Person p = new Person();
        underTest.process(p, null);
        assertNull(p.getFirstName());
        assertNull(p.getLastName());
    }

    @Test
    public void processEmptyValue() {
        Person p = new Person();
        underTest.process(p, "");
        assertNull(p.getFirstName());
        assertNull(p.getLastName());
    }

    @Test
    public void process() {
        Person p = new Person();
        underTest.process(p, "Bill McKnight");
        assertEquals("Bill", p.getFirstName());
        assertEquals("McKnight", p.getLastName());
    }

    @Test
    public void processInvalidData() {
        Person p = new Person();
        underTest.process(p, "BillMcKnight");
        assertEquals("BillMcKnight", p.getFirstName());
        assertNull(p.getLastName());
    }



}
package org.manager.data.personal;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class PersonalDataManagerTest
{

    private PersonalDataManager underTest;

    @Before
    public void setup(){
        underTest = new PersonalDataManager();
    }

    @Test (expected = IOException.class)
    public void readFileWithException() throws IOException {
        underTest.processFile(Paths.get("AddressBook1"));
    }

    @Test
    public void readFileLineByLine() throws IOException {
        List<Person> addressBookLines = underTest.processFile(Paths.get("AddressBook"));
        assertEquals(5, addressBookLines.size());
        assertEquals("1977-03-16", addressBookLines.get(0).getBirthDate().toString());
    }

}

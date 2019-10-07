package org.manager.data.personal;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

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

}

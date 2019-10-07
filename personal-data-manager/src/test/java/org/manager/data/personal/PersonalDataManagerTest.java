package org.manager.data.personal;

import org.junit.Before;
import org.junit.Test;
import org.manager.data.personal.model.GenderEnum;
import org.manager.data.personal.model.Person;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

    @Test
    public void readPersonalData() throws IOException {
        List<Person> personList = underTest.processFile(Paths.get("AddressBook"));
        assertEquals(5, personList.size());
        verifyTestData(personList.get(0));
        verifyTestData(personList.get(1));
        verifyTestData(personList.get(2));
        verifyTestData(personList.get(3));
        verifyTestData(personList.get(4));
    }

    @Test
    public void findPerson() throws IOException {
        underTest.processFile(Paths.get("AddressBook"));
        Optional<Person> p = underTest.findPerson("Gemma");
        Person gemma = p.get();
        assertEquals("Gemma", gemma.getFirstName());
        assertEquals("Lane", gemma.getLastName());
        assertEquals(GenderEnum.Female.toString(), gemma.getGender().toString());
        assertEquals(LocalDate.of(1991, 11, 20).toString(), gemma.getBirthDate().toString());
    }

    @Test
    public void findOldestPerson() throws IOException {
        underTest.processFile(Paths.get("AddressBook"));
        Person oldestPerson = underTest.findOldestPerson();
        assertNotNull(oldestPerson);
        assertEquals("Wes", oldestPerson.getFirstName());
        assertEquals("Jackson", oldestPerson.getLastName());
        assertEquals(LocalDate.of(1974, 8, 14).toString(), oldestPerson.getBirthDate().toString());
    }

    @Test
    public void countMales() throws IOException {
        underTest.processFile(Paths.get("AddressBook"));
        assertEquals(3, underTest.countMales());
    }

    private void verifyTestData(Person person) {
        assertNotNull(person.getFirstName());
        assertNotNull(person.getLastName());
        assertNotNull(person.getGender());
        assertNotNull(person.getBirthDate());
    }
}

package org.manager.data.personal;

import org.manager.data.personal.model.GenderEnum;
import org.manager.data.personal.model.Person;
import org.manager.data.personal.processor.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonalDataManager
{
        private List<Person> persistedData;

        private DateProcessor dateProcessor;
        private NameProcessor nameProcessor;
        private GenderProcessor genderProcessor;


        public List<Person> processFile(Path personalDataFile) throws IOException {
            nameProcessor = new NameProcessorImpl();
            dateProcessor = new DateProcessorImpl();
            genderProcessor = new GenderProcessorImpl();

            List<String> lines = Files.readAllLines(personalDataFile);
            persistedData = new ArrayList<>(lines.size());
            for (String x : lines) {
                Person p = new Person();
                String[] data = x.split(",");
                if (data.length == 3) {
                    if (!data[0].isEmpty()) {
                        nameProcessor.process(p, data[0].trim());
                    }
                    if (!data[1].isEmpty()) {
                        genderProcessor.process(p, data[1].trim());
                    }
                    if (!data[2].isEmpty()) {
                        dateProcessor.process(p, data[2].trim());
                    }
                }
                persistedData.add(p);
            }
            return persistedData;
        }


    public Optional<Person> findPerson(String name) {
        return persistedData.stream().filter(x -> x.getFirstName().equals(name)).findFirst();
    }

    public int countMales() {
        return persistedData.stream().filter(x -> x.getGender().equals(GenderEnum.Male)).collect(Collectors.toList()).size();
    }

    public Person findOldestPerson() {
        Optional<Person> first = persistedData.stream().min(Comparator.comparing(Person::getBirthDate));
        return first.orElse(null);

    }


}

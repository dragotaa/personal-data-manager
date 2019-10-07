package org.manager.data.personal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PersonalDataManager
{
        private List<Person> persistedData;

        private DateProcessor dateProcessor;
        public List<Person> processFile(Path personalDataFile) throws IOException {
            dateProcessor = new DateProcessorImpl();

            List<String> lines = Files.readAllLines(personalDataFile);
            persistedData = new ArrayList<>(lines.size());
            for (String x : lines) {
                Person p = new Person();
                String[] data = x.split(",");
                if (data.length == 3) {
                    if (!data[2].isEmpty()) {
                        dateProcessor.process(p, data[2].trim());
                    }
                }
                persistedData.add(p);
            }
            return persistedData;
        }
}

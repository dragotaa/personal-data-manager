package org.manager.data.personal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PersonalDataManager
{
    public List<String> processFile(Path personalDataFile) throws IOException {
        return Files.readAllLines(personalDataFile);
    }
}

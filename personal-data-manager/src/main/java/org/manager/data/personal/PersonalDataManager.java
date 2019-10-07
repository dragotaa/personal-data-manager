package org.manager.data.personal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PersonalDataManager
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public void processFile(Path personalDataFile) throws IOException {
        Files.readAllLines(personalDataFile);
    }
}

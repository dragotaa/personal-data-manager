package org.manager.data.personal;

import java.time.LocalDate;

public class DateProcessorImpl implements DateProcessor {

    public static final String SLASH = "/";

    @Override
    public void process(Person p, String data){
        if (!data.isEmpty()) {
            p.setBirthDate(preprocessDate(data));
        }
    }

    private LocalDate preprocessDate(String data) {
        String[] dateParts = data.split(SLASH);

        String year = dateParts[2];
        String currentYear = "" + LocalDate.now().getYear();
        if (Integer.valueOf(year) > Integer.valueOf(currentYear.substring(2))){
            return LocalDate.of(Integer.valueOf("19" + dateParts[2]), Integer.valueOf(dateParts[1]), Integer.valueOf(dateParts[0]));
        } else {
            return LocalDate.of(Integer.valueOf("20" + dateParts[2]), Integer.valueOf(dateParts[1]), Integer.valueOf(dateParts[0]));
        }
    }
}



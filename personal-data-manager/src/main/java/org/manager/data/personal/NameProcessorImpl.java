package org.manager.data.personal;

public class NameProcessorImpl implements NameProcessor{

    @Override
    public void process(Person p, String data){
        if (data != null && !data.isEmpty()){
            String[] nameData = data.split(" ");
            p.setFirstName(nameData[0]);
            if (nameData.length > 1) {
                p.setLastName(nameData[1]);
            }
        }
    }
}

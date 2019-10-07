package org.manager.data.personal;

public class GenderProcessorImpl implements GenderProcessor {

    @Override
    public void process(Person p, String data){
        if (data != null){
            switch(data.toLowerCase()){
                case "female":
                    p.setGender(GenderEnum.Female);
                    break;
                case "male":
                    p.setGender(GenderEnum.Male);
                    break;
                default:
                    p.setGender(GenderEnum.Unknown);
            }
        } else {
            p.setGender(GenderEnum.Unknown);
        }
    }
}

package org.manager.data.personal.processor;

import org.manager.data.personal.model.Person;

public interface DateProcessor {
    void process(Person p, String data);
}
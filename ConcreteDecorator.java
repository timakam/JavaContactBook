package org.itstep.msk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcreteDecorator implements AbstractDecorator {
    private Iterable<Contact> contacts;

    public ConcreteDecorator(Iterable<Contact> contacts){
        this.contacts = contacts;
    }

    @Override
    public Iterable<ContactFormatter> contactFormatter() {
        List<ContactFormatter> list = new ArrayList<>();
        Iterable<ContactFormatter> iterable = new Iterable<ContactFormatter>() {
            @Override
            public Iterator<ContactFormatter> iterator() {
                for(Contact con : contacts){
                    list.add(new StringContactFormatter(con,18,20));
                }
                return list.iterator();
            }
        };
        return iterable;
    }
}

package org.itstep.msk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ContactFormatterIterableDecorator implements Iterable<ContactFormatter> {

    private final Iterable<Contact> origin;

    public ContactFormatterIterableDecorator(Iterable<Contact> origin) {
        this.origin = origin;
    }

    @Override
    public Iterator<ContactFormatter> iterator() {
        List<ContactFormatter> list = new ArrayList<>();
        for(Contact con : origin){
            list.add(new StringContactFormatter(con,18,20));
        }
        return list.iterator();
    }
}

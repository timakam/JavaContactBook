package org.itstep.msk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringDecorator implements Decorator {

   private AbstractContactFormatterFactory factory;

    public StringDecorator(AbstractContactFormatterFactory factory){
        this.factory = factory;
    }


@Override
    public Iterable<ContactFormatter> getContactFormatters() {
        return factory.createContactFormatter();
    }

}


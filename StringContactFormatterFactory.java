package org.itstep.msk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringContactFormatterFactory implements AbstractContactFormatterFactory {

    private SimpleContactBook contactBook;
    private int nameLength = 18;
    private int phoneLength = 20;

    public StringContactFormatterFactory(SimpleContactBook contactBook, int nameLength, int phoneLength){
       this.contactBook = contactBook;
       this.nameLength = nameLength;
       this.phoneLength = phoneLength;
    }

    public StringContactFormatterFactory(SimpleContactBook contactBook){
        this.contactBook = contactBook;
    }

    @Override
    public Iterable<ContactFormatter> createContactFormatter() {
        List<ContactFormatter> list = new ArrayList<>();
        Iterable<ContactFormatter> iterable = new Iterable<ContactFormatter>() {
            @Override
            public Iterator<ContactFormatter> iterator() {
                for(Contact con : contactBook.read()){
                    list.add(new StringContactFormatter(con,nameLength,phoneLength));
                }
                return list.iterator();
            }
        };
        return iterable;

    }
}

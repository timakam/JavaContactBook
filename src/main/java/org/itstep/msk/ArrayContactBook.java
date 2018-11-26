package org.itstep.msk;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The most simple implementation of the contact repository
 * It stores the data in the ArrayList
 * Might be useful for testing
 *
 * @author Марк Михайлович
 * @version 1.0
 * */
public final class ArrayContactBook implements SimpleContactBook {
    private final ArrayList<Contact> contacts;
    public Contact ContactVar;

    public ArrayContactBook(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public Contact create(String name, String phoneNumber) {
        contacts.add(new Contact(name,phoneNumber));
        return contacts.get(contacts.size()-1);
    }

    @Override
    public SimpleContactBook delete(Contact c) {
        contacts.remove(c);
        return this;
    }

    @Override
    public Iterable<Contact> read() {
        return Collections.unmodifiableCollection(contacts);
    }

    @Override
    public SimpleContactBook commit() {
        return null;
    }

    @Override
    public SimpleContactBook FindByPhone(String Number)
    {
        ArrayList<Contact> FoundContacts = new ArrayList<>();

        for (int i = 0; i < contacts.size(); i++)
        {
            ContactVar = contacts.get(i);

            for (int j = 0; j < ContactVar.getPhone().length(); j++)
            {
                if ( Number == ContactVar.getPhone().subSequence(j,Number.length()) )
                    FoundContacts.add(ContactVar);
            }
        }

        SimpleContactBook Book = new ArrayContactBook(FoundContacts);
        return Book;

    }
}

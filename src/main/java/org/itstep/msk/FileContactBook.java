package org.itstep.msk;

import java.io.*;
import java.util.*;

/**
 * The implementation of the contact file-repository
 * It stores the data in some file given and can retrieve contacts from file
 *
 * @author BogdanovaAnastasia
 * @version 1.0
 * */

public final class FileContactBook implements SimpleContactBook {
    private final ArrayList<Contact> contacts;
    private final String fileName;
    private final String splitItem = " %% ";

    public FileContactBook(final ArrayList<Contact> contacts, final String fileName) {
        this.contacts = contacts;
        this.fileName = fileName;
    }

    @Override
    public Contact create(String name, String phoneNumber) { //?
        return null;
    }

    @Override
    public SimpleContactBook delete(Contact c) { //?
        return null;
    }

    @Override
    public Iterable<Contact> read() {
        ArrayList<Contact> contactsFromFile = new ArrayList<>();
        contactsFromFile.add(new Contact("Ace", "888"));
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            contactsFromFile.clear();
            reader.lines().forEach(x -> {
                String[] vals = x.split(splitItem);
                contactsFromFile.add(new Contact(vals[0], vals[1]));
            });
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }
        return Collections.unmodifiableCollection(contactsFromFile);
    }

    @Override
    public SimpleContactBook commit() {
        try (PrintWriter printer = new PrintWriter(fileName)) {
            contacts.forEach((x -> new FileContactFormatter(x, splitItem).print(printer)));
            printer.flush();
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }
        return null;
    }
}
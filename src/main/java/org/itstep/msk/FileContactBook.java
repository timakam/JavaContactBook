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
    public Contact create(String name, String phoneNumber) {
        contacts.add(new Contact(name, phoneNumber));
        return contacts.get(contacts.size()-1);
    }

    @Override
    public SimpleContactBook delete(Contact c) {
        contacts.remove(c);
        return null;
    }

    @Override
    public Iterable<Contact> read() {
        if (new File(fileName).exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                contacts.clear();
                reader.lines().forEach(x -> {
                    String[] vals = x.split(splitItem);
                    contacts.add(new Contact(vals[0], vals[1]));
                });
            } catch (IOException e) {
                throw new RuntimeException("Ошибка при работе с файлами", e);
            }
            return Collections.unmodifiableCollection(contacts);
        } else {
            System.out.println("File is not found");
            return Collections.emptyList();
        }
    }

    @Override
    public SimpleContactBook commit() {
        try (PrintWriter printer = new PrintWriter(fileName)) {
            contacts.forEach((x -> new FileContactFormatter(x, splitItem).print(printer)));
            printer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при работе с файлами", e);
        }
        return null;
    }
}
package org.itstep.msk;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Application main class
 *
 * @author Марк Михайлович
 * @version 1.0
 */
public final class App {
    /**
     * To print out contacts
     * Defines the main abstractions needed to do the job
     *
     * @param contactFormatters Iterable with contacts
     * @param writeTo PrintWriter to write to
     * */
    private static void printContacts(Iterable<ContactFormatter> contactFormatters, PrintWriter writeTo) {
        for (ContactFormatter cf : contactFormatters) {
            cf.print(writeTo);
            writeTo.println();
        }
        writeTo.flush();
    }

    public static void main( String[] args ) {
        ArrayList<Contact> contacts = new ArrayList<>(16);
        contacts.add(new Contact("Павел Иванович Чичиков","+13(900)999-99-99"));
        contacts.add(new Contact("Настасья Петровна Коробочка","+17(900) 999 99 99"));
        contacts.add(new Contact("Михаил Семёнович Сабакевич","8 900 999-99-99"));
        contacts.add(new Contact("Плюшкин","999-99-99"));
        contacts.add(new Contact("Манилов","999 99 99"));
        contacts.add(new Contact("Ноздрёв","8 (900) 999-99-99"));
        contacts.add(new Contact("Хлестаков Иван","+7(900)9999999"));
        contacts.add(new Contact("Земляника Артемий","+4 900 99999999"));
        contacts.add(new Contact("Шлёпкин Иван","8 800 8889999"));
        contacts.add(new Contact("Hercule Poirot","8 800 900 99 99"));
        contacts.add(new Contact("Mary Debenham","+19 900 999 99 99"));
        contacts.add(new Contact("Mrs. Hubbard","+23 900 999-99-99"));

//=======================================================================================
        SimpleContactBook contactBook = new ArrayContactBook(contacts);
//=======================================================================================
        AbstractDecorator decorator = new ConcreteDecorator(contacts);
        printContacts(decorator.contactFormatter(),new PrintWriter(System.out));
//=======================================================================================
    }
}

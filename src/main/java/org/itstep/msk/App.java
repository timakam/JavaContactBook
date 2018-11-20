package org.itstep.msk;

import java.util.ArrayList;

/**
 * Application main class
 *
 * @author Марк Михайлович
 * @version 1.0
 */
public class App {
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

        ArrayList<Contact> toPrintOut = contacts;
        for (Contact c : toPrintOut)
            System.out.printf("%-30s    %-18s"+System.lineSeparator(),c.getName(),c.getPhone());
    }
}

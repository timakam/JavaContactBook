package org.itstep.msk;

public interface AbstractContactFormatterFactory {

    ContactFormatter getContactFormatter(Contact origin);
}

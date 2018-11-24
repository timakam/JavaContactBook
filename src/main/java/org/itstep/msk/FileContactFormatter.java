package org.itstep.msk;

import java.io.PrintWriter;

public final class FileContactFormatter implements ContactFormatter {
    private final Contact origin;

    public FileContactFormatter(Contact origin) {
        this.origin = origin;
    }

    @Override
    public void print(PrintWriter writeToFile) {
        writeToFile.write(origin.getName() + " %% " + origin.getPhone());
        writeToFile.println();
    }
}

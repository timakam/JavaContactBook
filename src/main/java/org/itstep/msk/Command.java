package org.itstep.msk;

/**
 * Declares the type of the executable object
 * */
@FunctionalInterface
public interface Command {
    /**
     * The method to execute particular command
     * No input, no output - utilize effects on the inner data
     *
     * @throws Exception if some internal fails
     * */
    void exec() throws Exception;
}

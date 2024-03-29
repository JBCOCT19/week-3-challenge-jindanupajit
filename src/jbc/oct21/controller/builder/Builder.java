package jbc.oct21.controller.builder;


import jbc.oct21.Interface.UserInputable;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

// Builder interact with user and model via interface "UserInput"
// see jbc.oct21.Interface.UserInput for more information

public abstract class Builder {

    public void auto() {
        this.auto(System.out, System.in);
    }

    public void auto(PrintStream printStream) {
        this.auto(printStream, System.in);
    }

    public void auto(InputStream inputStream) {
        this.auto(System.out, inputStream);
    }

    public abstract void auto(PrintStream printStream, InputStream inputStream) ;

    // Actual User Interaction
    public Object retrieve(PrintStream printStream, InputStream inputStream, UserInputable userInputable) {
        Scanner scanner = new Scanner(inputStream);


        String value = "";
        do {
            printStream.print(userInputable.prompt());
            try {
                value = scanner.nextLine();
                // Flush input buffer
                while (inputStream.available() > 0) {
                    inputStream.read();
                }

            } catch (IOException e) {
                value = "";
            } finally {
                if (value.equalsIgnoreCase("abort")) {
                    System.err.println("User abort");
                    System.exit(1);
                }
            }

            if (! userInputable.isValidValue(value)) {
                System.err.println(" * Not a valid input\n");
            }
        } while (! userInputable.isValidValue(value));

        return userInputable.store(value);
    }
}

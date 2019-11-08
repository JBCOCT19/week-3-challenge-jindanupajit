package jbc.oct21.Interface;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

// Most ExtendsType will have UserInput specification
// such as validation, data casting (and storing),
// toString conversion

// we direct the builder how to interact with user here
// other special specification will be in ExtendsType package
//  eg, each ExtendsType can have special instruction how to
//  interact with user, see ExtendsType for more information
//  ExtendsType will implements this interface


public interface UserInput <T> {

    // customize your prompt here
    default String  prompt() {
        StringBuilder sb = new StringBuilder();
        String guide = guide();

        sb.append( typeName() );
        sb.append( guide==null?"":" ("+guide+")" );
        sb.append(" > ");

        return sb.toString();
    }

//    // ****** The actual interaction with user happened here
//    // sub class should attempt to override other methods before this method
//    default T retrieve(PrintStream printStream, InputStream inputStream) {
//        Scanner scanner = new Scanner(inputStream);
//
//
//        String value = "";
//        do {
//            printStream.print(prompt());
//            try {
//                value = scanner.nextLine();
//                // Flush input buffer
//                while (inputStream.available() > 0) {
//                    inputStream.read();
//                }
//
//            } catch (IOException e) {
//                value = "";
//            } finally {
//                if (value.equalsIgnoreCase("abort")) {
//                    System.err.println("User abort");
//                    System.exit(1);
//                }
//            }
//
//            if (! isValidValue(value)) {
//                System.err.println(" * Not a valid input\n");
//            }
//        } while (! isValidValue(value));
//
//        return store(value);
//    }

    // will display as a prompt for user input
    default String typeName() {
        return getClass().getSimpleName();
    }

    // will display as a guide for user input
    default String guide() {
        return null;
    }

    // required: how each type cast from string and store it
    public T store(String string) ;

    // required: is that string a valid input?
    public boolean isValidValue(String string);
}

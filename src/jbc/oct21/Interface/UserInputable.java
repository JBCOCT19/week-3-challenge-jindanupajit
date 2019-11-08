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


public interface UserInputable<T> {

    // customize your prompt here,
    // but try to @Override other method first
    default String  prompt() {
        StringBuilder sb = new StringBuilder();
        String guide = guide();

        sb.append( typeName() );
        sb.append( guide==null?"":" ("+guide+")" );
        sb.append(" > ");

        return sb.toString();
    }

    // will display as a prompt for user input
    default String typeName() {
        return getClass().getSimpleName();
    }

    // will display as a guide for user input
    default String guide() {
        return null;
    }

    // required: how each type cast from string and store it
    T store(String string) ;

    // required: is that string a valid input?
    boolean isValidValue(String string);
}

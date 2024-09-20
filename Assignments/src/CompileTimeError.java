/*********************************************************************
 - This class demonstrates different compile-time errors
 *********************************************************************/
public class CompileTimeError {
    public static void main(String[] args) {
        System.out.println("This is a test of a compiler time errors!");
    }
}

//My guess is that it will be an Incorrect Class Declaration error.
//4:8 java: class compileTimeError is public, should be declared in a file named compileTimeError.java

//My guess is that there will be no error

//My guess is that it will be an Incorrect main Method Signature error.
//Error: Main method not found in class CompileTimeError, please define the main method as:
//   public static void main(String[] args)
//or a JavaFX application class must extend javafx.application.Application

//My guess is that an Incorrect Print Statement error will happen.
// java: cannot find symbol
//  symbol:   method Println(java.lang.String)
//  location: variable out of type java.io.PrintStream

//My guess is that an Incorrect Method Declaration error will happen.
// 8:15 java: package system does not exist

//My guess is that a Unclosed String Literal error will happen.
//8:32 java: ')' or ',' expected

//My guess is that an Unclosed String Literal error will happen.
//8:28 java: unclosed string literal

//My guess is that an Incorrect Print Statement error will happen.
//8:72 java: ';' expected

//My guess is that an Incorrect Class Declaration error will happen.
//9:6 java: reached end of file while parsing
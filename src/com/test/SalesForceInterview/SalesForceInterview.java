package com.test.SalesForceInterview;

import java.io.*;
import java.util.*;

public class SalesForceInterview {

//    public void initApplications(){
//        Application a = new Application("A");
//        Application b = new Application("B");
//        Application c = new Application("C");
//        Application d = new Application("D");
//        Application e = new Application("E");
//        Application f = new Application("F");
//        Application g = new Application("G");
//
//
//        a.dependencies.add(b);
//        a.dependencies.add(c);
//
//        b.dependencies.add(d);
//
//        c.dependencies.add(b);
//        c.dependencies.add(f);
//
//        d.dependencies.add(e);
//        d.dependencies.add(f);
//
//        g.dependencies.add(f);
//
//        a.installApplication();
//
//        d.installApplication();
//
//        b.removeApplication();
//
//        a.removeApplication();
//
//        System.out.println("Here");
//
//    }

    /*
     * Input stream for commands
     */
    private BufferedReader _input;


    public SalesForceInterview(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("com/test/SalesForceInterview/data.dat");
        _input = new BufferedReader(new InputStreamReader(inputStream));

    }

    /**
     * Runs the parser on the supplied test data set. Expects a file in the
     * current working directory. Output is sent to stdout
     *
     * @param args not used
     */
    public static void main(String[] args) throws Exception {

        SalesForceInterview salesForceInterview = new SalesForceInterview();
//        InputStream in = salesForceInterview .getClass().getResourceAsStream("data.dat");
//        if(in == null)
//            throw new IllegalArgumentException("no input file found");

//        SalesForceInterview parser = new SalesForceInterview(in);


        salesForceInterview.process();
    }

    /**
     * Creates a new CommandParser, sending input and output to the specified
     * locations
     *
     * @param in  input stream for commmands
     */
//    public SalesForceInterview(InputStream in) {
//        _input = new BufferedReader();
//    }

    /**
     * Processes a command from user. invalid commands are not printed, and
     * silently ignored. An invalid command includes a command which is missing
     * its argument. For example: "mkdir " is invalid.
     *
     * @param line line of text representing the command string
     */
    public void processLine(String line) {
        String[] arguments = line.split("[ ]+");
        String command = arguments[0];

        switch (command){
            case "DEPEND":
                PackageManager.getInstance().depend(arguments);
                break;
            case "INSTALL":
                PackageManager.getInstance().install(arguments);
                break;
            case "REMOVE":
                PackageManager.getInstance().remove(arguments);
                break;
            case "LIST":
                PackageManager.getInstance().list();
                break;
                default:
                    System.out.println("Invalid Command");
                    return;
        }
    }

    /**
     * Reads all commands from the input, and executes them
     *
     * @throws IOException if a read error occurs while parsing commands
     */
    public void process() throws IOException {
        String line = _input.readLine();
        while (line != null && line.length() > 0) {
            if (line.equals("END")) {
                break;
            }
            processLine(line);
            line = _input.readLine();
        }
    }

}

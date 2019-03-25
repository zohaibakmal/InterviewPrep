package com.test.SalesForceInterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PackageManager implements PackageOperations {

    HashMap<String, Application> map;

    private static PackageManager singleton = null;

    private PackageManager(){
        List<Application> applications = new ArrayList<>();
        map= new HashMap<>();
    }

    public static PackageManager getInstance(){
        if(singleton==null){
            singleton = new PackageManager();
        }
        return singleton;

    }

    @Override
    public void install(String ... args) {
        if(args.length!=2){
            System.out.println("Invalid INSTALL command");
            return;
        }
        String applicationName = args[1];
        Application currentApplication = map.get(applicationName);
        printArgs(args);
        if(currentApplication!=null){
            currentApplication.installApplication();
        }else{
            currentApplication = new Application(applicationName);
            map.put(applicationName, currentApplication);
            currentApplication.installApplication();
        }


    }

    @Override
    public void depend(String ... list) {
        if(list.length>1){
            printArgs(list);
            String currentApplicationName = list[1];
            Application currentApplication = map.get(currentApplicationName);
            if(currentApplication==null){
                currentApplication = new Application(currentApplicationName);
                map.put(currentApplicationName, currentApplication);
            }
            for(int i=2; i<list.length; i++){
                Application dependentApplication = map.get(list[i]);
                if(dependentApplication==null){
                    dependentApplication  = new Application(list[i]);
                    map.put(list[i], dependentApplication);
                }
                currentApplication.addDependency(dependentApplication);
            }

        }else{
            System.out.println("Invalid DEPEND command");
        }
    }

    @Override
    public void remove(String ... args) {
        printArgs(args);
        if(args.length!=2){
            System.out.println("Invalid INSTALL command");
            return;
        }
        String applicationName = args[1];
        Application currentApplication = map.get(applicationName);
        currentApplication.removeApplication();
    }

    @Override
    public void list() {
        System.out.println("LIST");
        for(String applicationName: map.keySet()){
            Application currentApplication = map.get(applicationName);
            if(currentApplication.getInstallationState()!=InstallationState.NotInstalled){
                System.out.println("\t"+currentApplication.getName());
            }
        }
    }

    private void printArgs (String ... args){
        StringBuilder stringBuilder = new StringBuilder();
        for (String item: args){
            stringBuilder.append(item);
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder.toString().trim());
    }
}

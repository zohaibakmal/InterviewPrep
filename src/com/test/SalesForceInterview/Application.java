package com.test.SalesForceInterview;

import java.util.LinkedList;
import java.util.List;

public class Application {
    private String name;
    private InstallationState state;
    private List<Application> dependencies;
    private int installCount;

    public Application(String name){
        this.name = name;
        this.dependencies = new LinkedList<>();
        this.state = InstallationState.NotInstalled;
        this.dependencies = new LinkedList<>();
        this.installCount=0;
    }

    public void installApplication(){
        this.state = InstallationState.ExplicitInstalled;
        if(installCount>0){
            System.out.println("\t"+this.name+ " is already installed");
            return;
        }
        this.installCount++;
        installDependencies(this);
        System.out.println("\t"+this.name+ " successfully installed");
    }

    public void removeApplication(){
        if(this.state == InstallationState.ImplicitInstalled){
            System.out.println("\t"+this.name+ " is still needed");
            return;
        }
        if(installCount==0){
            System.out.println("\t"+this.name+ " is not installed");
            return;
        }
        this.state = InstallationState.ImplicitInstalled;
        this.installCount--;
        if(installCount==0){
            this.state = InstallationState.NotInstalled;
            System.out.println("\t"+this.name+ " successfully removed");
        }else{
            System.out.println("\t"+this.name+ " is still needed");
        }
        removeDependencies(this);

    }

    public void addDependency(Application application){
        this.dependencies.add(application);
    }

    public String getName(){
        return this.name;
    }

    public InstallationState getInstallationState(){
        return this.state;
    }


    private void installDependencies(Application application){
        if(application.dependencies==null || application.dependencies.size()==0){
            return;
        }
        for(Application app: application.dependencies){
            installDependencies(app);
            app.installCount++;
            if(app.state== InstallationState.NotInstalled){
                app.state = InstallationState.ImplicitInstalled;
                System.out.println("\t"+app.name+ " successfully installed");
            }
        }
    }

    private void removeDependencies(Application application){
        if(application.dependencies==null || application.dependencies.size()==0){
            return;
        }
        for(Application app: application.dependencies){
            if(app.state!=InstallationState.ExplicitInstalled){
                removeDependencies(app);
                app.installCount--;
            }
            if(app.installCount==0){
                app.state= InstallationState.NotInstalled;
                System.out.println("\t"+app.name+ " is no longer needed");
                System.out.println("\t"+app.name+ " is successfully removed");
            }
        }
    }

}

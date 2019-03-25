package com.test.SalesForceInterview;

import java.util.List;

public interface PackageOperations {
    public void install(String ... args);
    public void depend(String ... args);
    public void remove(String ... application);
    public void list();
}

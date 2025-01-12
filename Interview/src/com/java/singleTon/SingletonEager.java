package com.java.singleTon;

public final class SingletonEager {

    // Eagerly create the instance at the time of class loading
    private static final SingletonEager INSTANCE = new SingletonEager();

    // Private constructor to prevent external instantiation
    private SingletonEager() {}

    // Public method to provide access to the single instance
    public static SingletonEager getInstance() {
        return INSTANCE;
    }
}


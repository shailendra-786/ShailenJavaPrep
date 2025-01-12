package com.javaRelatedCode;

//Interface with abstract methods
interface Vehicle {
 void start();
 void stop();
}

//Abstract class that implements the interface
abstract class AbstractVehicle implements Vehicle {
 private String name;

 public AbstractVehicle(String name) {
     this.name = name;
 }

 public String getName() {
     return name;
 }

 // Abstract method
 public abstract void fuelUp();

 // Final method to prevent overriding
 public final void horn() {
     System.out.println(name + " is honking.");
 }

 // Static method
 public static void maintenance() {
     System.out.println("Vehicle is under maintenance.");
 }

 // Static block
 static {
     System.out.println("Static block of AbstractVehicle executed.");
 }

 // Instance block
 {
     System.out.println("Instance block of AbstractVehicle executed.");
 }
}

//Final class extending the abstract class
final class Car extends AbstractVehicle {
 private static int carCount = 0;
 private final String model;
 private static final String CATEGORY = "Sedan";

 public Car(String name, String model) {
     super(name);
     this.model = model;
     carCount++;
 }

 // Overriding abstract method
 @Override
 public void fuelUp() {
     System.out.println(getName() + " is fueling up.");
 }

 // Overriding interface methods
 @Override
 public void start() {
     System.out.println(getName() + " is starting.");
 }

 @Override
 public void stop() {
     System.out.println(getName() + " has stopped.");
 }

 // Overloading methods
 public void start(boolean withKey) {
     if (withKey) {
         System.out.println(getName() + " is starting with a key.");
     } else {
         System.out.println(getName() + " is starting without a key.");
     }
 }

 // Static method
 public static void showCarCount() {
     System.out.println("Total cars: " + carCount);
 }

 // Static block
 static {
     System.out.println("Static block of Car executed.");
 }

 // Instance block
 {
     System.out.println("Instance block of Car executed.");
 }
}

//Another class extending the abstract class
class Motorcycle extends AbstractVehicle {
 private final String type;

 public Motorcycle(String name, String type) {
     super(name);
     this.type = type;
 }

 // Overriding abstract method
 @Override
 public void fuelUp() {
     System.out.println(getName() + " is fueling up.");
 }

 // Overriding interface methods
 @Override
 public void start() {
     System.out.println(getName() + " is starting.");
 }

 @Override
 public void stop() {
     System.out.println(getName() + " has stopped.");
 }

 // Static block
 static {
     System.out.println("Static block of Motorcycle executed.");
 }

 // Instance block
 {
     System.out.println("Instance block of Motorcycle executed.");
 }
}

public class OOPConceptsDemo {
 public static void main(String[] args) {
     System.out.println("Creating a Car object:");
     Car car = new Car("Tesla", "Model S");
     car.start();
     car.start(false);
     car.fuelUp();
     car.stop();
     car.horn();
     Car.showCarCount();
     AbstractVehicle.maintenance();

     System.out.println("\nCreating a Motorcycle object:");
     Motorcycle motorcycle = new Motorcycle("Harley", "Cruiser");
     motorcycle.start();
     motorcycle.fuelUp();
     motorcycle.stop();
     motorcycle.horn();
 }
}

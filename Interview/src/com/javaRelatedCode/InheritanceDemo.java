package com.javaRelatedCode;

//Interface defining common behaviors
interface Flying {
 void fly();
}

//Abstract class implementing the interface and providing a base for other classes
abstract class Animal {
 private String name;

 public Animal(String name) {
     this.name = name;
 }

 public String getName() {
     return name;
 }

 public abstract void makeSound();

 public void sleep() {
     System.out.println(name + " is sleeping.");
 }
}

//Another abstract class to demonstrate multiple levels of inheritance
abstract class Bird extends Animal implements Flying {
 public Bird(String name) {
     super(name);
 }

 @Override
 public void fly() {
     System.out.println(getName() + " is flying.");
 }
}

//Concrete class inheriting from Bird
class Eagle extends Bird {
 public Eagle(String name) {
     super(name);
 }

 @Override
 public void makeSound() {
     System.out.println(getName() + " screeches.");
 }

 public void hunt() {
     System.out.println(getName() + " is hunting.");
 }
}

//Another class demonstrating polymorphism and method overriding
class Sparrow extends Bird {
 public Sparrow(String name) {
     super(name);
 }

 @Override
 public void makeSound() {
     System.out.println(getName() + " chirps.");
 }

 public void buildNest() {
     System.out.println(getName() + " is building a nest.");
 }
}

//Another concrete class for further complexity
class Dog extends Animal {
 public Dog(String name) {
     super(name);
 }

 @Override
 public void makeSound() {
     System.out.println(getName() + " barks.");
 }

 public void fetch() {
     System.out.println(getName() + " is fetching a ball.");
 }
}

public class InheritanceDemo {
 public static void main(String[] args) {
     // Polymorphism in action
     Animal eagle = new Eagle("Eagle");
     Animal sparrow = new Sparrow("Sparrow");
     Animal dog = new Dog("Dog");

     eagle.makeSound();
     eagle.sleep();
     ((Eagle) eagle).fly();
     ((Eagle) eagle).hunt();

     sparrow.makeSound();
     sparrow.sleep();
     ((Sparrow) sparrow).fly();
     ((Sparrow) sparrow).buildNest();

     dog.makeSound();
     dog.sleep();
     ((Dog) dog).fetch();
     
     // Demonstrating encapsulation
     Animal animal = new Eagle("Generic Eagle");
     System.out.println("Animal name: " + animal.getName());

     // Demonstrating super keyword
     System.out.println("Animal sleeping:");
     animal.sleep();
 }
}


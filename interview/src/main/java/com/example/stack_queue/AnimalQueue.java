package com.example.stack_queue;

import java.util.LinkedList;

/**
 * Created by binea on 2016/11/9.
 */

public class AnimalQueue {
    public abstract class Animal {
        private int order;
        protected String name;

        public Animal(String n) {
            name = n;
        }

        public void setOrder(int ord) {
            order = ord;
        }

        public int getOrder() {
            return order;
        }

        public boolean isOlderThan(Animal a) {
            return this.order > a.getOrder();
        }
    }

    public class Dog extends Animal {

        public Dog(String n) {
            super(n);
        }
    }

    public class Cat extends Animal {

        public Cat(String n) {
            super(n);
        }
    }

    LinkedList<Dog> dogQueue = new LinkedList<>();
    LinkedList<Cat> catQueue = new LinkedList<>();

    public void enqueue(Animal animal) {
        animal.setOrder((int) System.currentTimeMillis());
        if (animal instanceof Dog) {
            dogQueue.push((Dog) animal);
        } else {
            catQueue.push((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        Dog dog = dogQueue.peek();
        Cat cat = catQueue.peek();
        if(dog.isOlderThan(cat)) {
            return dequeueDog();
        }
        return dequeueCat();
    }
    
    public Animal dequeueDog() {
        return dogQueue.poll();
    }

    public Animal dequeueCat() {
        return catQueue.poll();
    }
}

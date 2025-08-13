package org.example.stackAndQueues.queuePractice;

import java.util.LinkedList;

public abstract class Animal {
    private int order;
    protected String name;

    public Animal(String n) {
        name = n;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}

class AnimalQueue {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0;

    public void enqueue(Animal a) {
        a.setOrder(0);
        order++;

        if (a instanceof Dog) {
            dogs.addLast((Dog) a);
        } else if (a instanceof Cat) {
            cats.addLast((Cat) a);
        }
    }

    public Animal dequeueAny() {
        if (dogs.size() == 0) {
            dequeueCats();
        } else if (cats.size() == 0) {
            dequeueDogs();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderThan(cat)) {
            return dequeueDogs();
        } else {
            return dequeueCats();
        }
    }


    public Cat dequeueCats() {
        return cats.poll();
    }

    public Dog dequeueDogs() {
        return dogs.poll();
    }


}


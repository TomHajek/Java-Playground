package dev.playground.designPatterns.creational.singleton;

/**
 * As mentioned in Lazy Initialization if our get instance method invoked by two threads at the same time, then there
 * are chances that two objects created, and we violate singleton pattern.
 *
 * To avoid, we have two choices:
 *
 * 1. Create getInstance synchronized, so that only one instance can invoke that method. However, the disadvantage is
 * lets say there are 3 thread t1 is inside getInstance and t2,t3 waiting. Now t2 will get into method and simply return
 * instance created by t1 and t3 still waiting. So it had led to unnecessary locks.
 *
 * 2. To avoid we, have synchronized block which we will implement here.
 */
public class MultithreadSingleton {

    //2nd: have a static instance of the class itself (null because lazy initialized)
    private static MultithreadSingleton instance = null;

    //1st: have a private constructor
    private MultithreadSingleton() {
    }

    //3rd: have a static method that instantiates the object
    public static MultithreadSingleton getInstance() {
        /*
         * The Question arises, why we have two null checks here.
         * Reason for first null check is same as explained in method level synchronization why create lock if our
         * object is already created.
         */

        if(instance == null) {
            // Our method is static, so we have class level locking here
            synchronized (MultithreadSingleton.class) {  // synchronized block, all threads come here if null
                /*
                * Reason for second null check is lets say two objects comes inside first null at same time.
                * One call has taken lock and proceeds for creating an object the first time. Now once lock is released
                * for t1 t2 should not create an object because it is already created, and that's why we have a second
                * null check.
                */
                if(instance == null) {
                    instance = new MultithreadSingleton();
                }
            }
        }
        return instance;
    }

}

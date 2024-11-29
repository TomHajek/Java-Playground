package dev.playground.designPatterns.structural.proxy;

/**
 * Proxy pattern: The proxy pattern is structural pattern. We use proxy when we don't want to expose a real object, and
 * provide the proxy object to deal with.
 *
 * Many times when you are dealing with remote servers and do lookup from the naming server, it provides you a proxy
 * object from remote server, not actual one. Even in hibernate, we have a concept of lazy loading, where whenever we
 * load data from db, we get a proxy object of a database and return it. However, if we get it, then it gets only loaded
 * from a database. This is one of the best examples of a proxy object.
 *
 * Another example can be Spring AOP, where AOP objects are proxy and treated on advice aspects.
 *
 * Different types of proxies are:
 * 1. Remote proxy: When you are dealing with the remote system, you require a remote object to interact with the system.
 *                  Usually in the past, it gets used in ejb, where beans gets created in container and client gets the
 *                  objects using JNDI system.
 * 2. Virtual proxy: Delay the object creation until it is required, as explained, hibernate uses this.
 * 3. Protection proxy: This proxy is used when we are dealing with a security system, where before invoking system
 *                       implementation, we want to check access.
 * 4. Snart proxy: Perform some additional steps before accessing the object.
 *
 * The Proxy pattern has mainly three components:
 * 1. A common interface
 * 2. Real Class
 * 3. Proxy class - this uses the real class, and it is proxy of real class.
 *
 * https://www.javadevjournal.com/java-design-patterns/proxy-design-pattern/
 *
 * For Example, suppose you have a Bank Account where you can withdraw, deposit or check account. All these you can do
 * by visiting the bank. But the same thing you can do using the proxy of the bank account is the ATM. You can go to the
 * ATM and withdraw, deposit or check your account. You can see that it has, or it is the implementation of the bank
 * account itself. So the ATM is basically a proxy of your bank account (you're not going directly to the bank
 * (main object)).
 *
 */
public class Main {

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.withdraw();
    }

}

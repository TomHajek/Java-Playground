package dev.playground.designPatterns.structural.bridge;

/**
 * Bridge Pattern: The Bridge pattern is also a structural pattern similar to adapter, facade.
 *
 * As the name suggests, Bridge - we are creating bridge between two implementations using composition rather than going
 * by inheritance. While dealing with abstraction, we usually create inheritance hierarchies to achieve abstraction.
 * However, inheritance is not a good option every time as it creates a tightly coupled application, and one change in
 * base class causes issues in the whole inheritance hierarchy.
 *
 * The bridge pattern does it by separating the abstraction and the implementation in separate class hierarchies. The
 * bridge between the class hierarchies is achieved through composition.
 *
 * Usage:
 * When we want a parent abstract class to define the set of basic rules, and the concrete classes to add additional rules
 * When we go via inheritance, it keeps growing the hierarchy.
 *
 * For example, we have a Shape class, which has Rectangle and Triangle. And each shape has two color variants red and
 * yellow, so you extended and Created RedRectangleShape and YellowRentangleShape and the same for triangle.
 * So we have now these 4 different variants of the shape, consider you decided to expand for Blue color and Circle
 * shape. So your classes keep getting increased.
 *
 * Rather, let's implement a bridge pattern, which says separate out function in different hierarchies one color and one
 * shape. So your shape has a color and uses it. So you can keep expanding your system now.
 *
 * Major components to achieve bridge patterns are:
 *
 * 1. Abstraction: This is a main abstract class, which the client uses.
 * 2. RefinedAbstraction: This is the class which extends abstraction.
 * 3. Implementor: Interface for the implementation hierarchy.
 * 4. Concrete Implementor: Implementation of the implementor.
 *
 * https://howtodoinjava.com/design-patterns/structural/bridge-design-pattern/
 * https://springframework.guru/gang-of-four-design-patterns/bridge-pattern/
 *
 * Example:
 * Consider example of video processing provider. Where we process youtube and netflix video in 4K and HD for now. We
 * can simply go in a way Youtube4kProcess, YoutubeHDProcess and same for netflix. However, as you know, it is not
 * scalable and became more complex.
 *
 * So we implement this bridge pattern where:
 *
 * 1. Abstraction: Video has video processor.
 * 2. RefinedAbstraction: Which is our Youtube and Netflix.
 * 3. Implementor: VideoProcessor.
 * 4. Concrete Implementor: 4KProcessor and HDProcessor.
 *
 * As you see in the example, you can simply expand the processor and video provider without issues.
 * Here we have implemented has-a relationship.
 */
public class Main {

    public static void main(String[] args) {
        // We are passing which video we want and which video processor we want as well
        Video youtubeVideo = new YoutubeVideo(new HDProcessor());
        youtubeVideo.play("abc.mp4");

        Video netflixVideo = new NetflixVideo(new UHD4KProcessor());
        netflixVideo.play("abc.mp4");
    }

}

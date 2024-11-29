package dev.playground.designPatterns.behavioral.state;

/**
 * State design pattern is a part of a behavioral design patterns, which allows us to do some behaviors based on the
 * state. For example, the state of the machine.
 *
 * Suppose we have a document, when a document state is "new," that means it will have some behavior (written -> save).
 * Then it will have a new state "draft" with different behavior (let's say review). Then it can have another state
 * "complete."
 *
 * In our example, we will have "State" interface with any action to perform. Based on any state, we will do some action
 * (behavior for the state). This interface can be implemented by any state (state1, state2, etc.). Every state will
 * have different actions to perform.
 *
 * For all states, we can also have a "Context." This context can be passed along with every state to identify what is
 * the actual state of the object or what we have to do.
 *
 */
public class Main {

    public static void main(String[] args) {
        // Creating context
        Context context = new Context();

        // Calling (creating) the state and performing an action
        StartState startState = new StartState();
        startState.doAction(context);

        // So whenever we perform an action, the state will be set accordingly
        System.out.println(context.getState().toString());

        // Calling another state/action and state will be changed
        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }

}

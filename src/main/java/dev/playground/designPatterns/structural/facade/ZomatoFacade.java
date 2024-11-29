package dev.playground.designPatterns.structural.facade;

/**
 * This facade class has the responsibility of the restaurant delivery boy and the delivery team as well,
 * so it has the abstraction on top of everything, and with one method, it allows us to do all the things.
 */
public class ZomatoFacade {

    private Restaurant restaurant;
    private  DeliveryBoy deliveryBoy;
    private DeliveryTeam deliveryTeam;

    public void placeOrder() {
        restaurant.prepareOrder();
        deliveryTeam.assignDeliveryBoy();
        deliveryBoy.pickUpOrder();
        deliveryBoy.deliverOrder();
    }

}

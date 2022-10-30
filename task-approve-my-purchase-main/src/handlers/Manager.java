package handlers;

import common.Type;

/**
 * //TODO - If needed, validate logic and if possible optimize code
 */
public class Manager extends Approver {
    public Manager() {
        super(300, 500, 700, 1000, 1500, "Manager");
    }
    // Validaciq (OPEN CLOSE)

    /**
     * After consideration of the data that we have as an input the only one that I think is mandatory that we actually validate is the price that was put in as a request for the purchase
     * as an item requested could never be negative price or 0. I use the Open Close principle here where the approve validation method is open for extension but not modification.
     * As to the reason why this is left in the Manager Class its simply because it's the first one that gets in line for the order from the list of orders(presumably list of orders.)
     */
    @Override
    public void approve(int id, double cost, Type type) {
        if (cost <= 0) {
            System.out.println("Cannot have a price that's less than 0");
            return;
        }
        super.approve(id, cost, type);
    }
}

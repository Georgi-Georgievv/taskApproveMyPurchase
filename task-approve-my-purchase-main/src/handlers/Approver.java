package handlers;

import common.Type;

/**
 * Because ....
 */
public abstract class Approver {
    /**
     * I added variables to the abstract class, so we can use the class as cast of the data that we are going to be using.
     */
    protected Approver next;
    protected double consumablesValue;
    protected double clericalValue;
    protected double gadgetsValue;
    protected double gamingValue;
    protected double pcValue;
    protected String position;

    /**
     * Added this constructor for the Executive meeting
     */
    public Approver() {
    }

    /**
     * Standart constructor for the class which we are going to be using with the Approver positions. I do this, so we do not repeat the code and to be able to
     * instead of repeating the methods in all the other classes we can call to these with the variables given by the approvers(on their respective positions)
     */
    public Approver(double consumablesValue, double clericalValue, double gadgetsValue, double gamingValue, double pcValue, String position) {
        this.consumablesValue = consumablesValue;
        this.clericalValue = clericalValue;
        this.gadgetsValue = gadgetsValue;
        this.gamingValue = gamingValue;
        this.pcValue = pcValue;
        this.position = position;
    }

    /**
     *  If needed, be free to change signature of abstract methods.
     */

    /**
     * For this method I just change the PrintLine to PrintFormat because it's easier to edit and add to it if needed.
     */
    public void approve(int id, double cost, Type type) {

        if (canApprove(cost, type)) {
            System.out.printf("%s approved purchase with id %d that costs %.2f .%n", this.position, id, cost);
            return;
        }
        System.out.printf("Purchase with id %d needs approval from higher position than %s.%n", id, this.position);
        next.approve(id, cost, type);
    }

    /**
     * Here in this method instead of having the logic in every instance of the approvers I created a method which works better than the if else chain that was coded.
     * Adittionally I moved the logic that was inside the switch case in a different method because it was repeating which after moving it out made the code look a lot more
     * readable and clean, also the id param was being called in the function without using it, so I simply removed it as a requirement.
     */
    protected boolean canApprove(double cost, Type type) {
        switch (type) {
            case CONSUMABLES:
                return isValueInRange(cost, consumablesValue);
            case CLERICAL:
                return isValueInRange(cost, clericalValue);
            case GADGETS:
                return isValueInRange(cost, gadgetsValue);
            case GAMING:
                return isValueInRange(cost, gamingValue);
            case PC:
                return isValueInRange(cost, pcValue);
            default:
                return false;
        }
    }

    // Removed the repeating logic from the switch case statement so instead we point to a method
    protected boolean isValueInRange(double givenValue, double valueRange) {
        return givenValue <= valueRange ? true : false;
    }

    /**
     * Method used for registering next approver level.
     * DO NOT CHANGE IT.
     */
    public Approver registerNext(Approver next) {
        this.next = next;
        return next;
    }
}

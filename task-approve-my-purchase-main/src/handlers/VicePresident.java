package handlers;


/**
 * //TODO - Implement approval implementation for VicePresident level
 */
public class VicePresident extends Approver {
    // Simply added a super constructor that is using the details of the Approver in order to be able to set parameters for our approvers.
    public VicePresident() {
        this.consumablesValue = 700;
        this.clericalValue = 1500;
        this.gadgetsValue = 2000;
        this.gamingValue = 4500;
        this.pcValue = 6500;
        this.position = "Vice President";
    }
}

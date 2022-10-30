package handlers;

import common.Type;

/**
 * //TODO - Implement approval implementation for President level
 */
public class President extends Approver {
    // Simply added a super constructor that is using the details of the Approver in order to be able to set parameters for our approvers.
    public President() {
        super(300, 500, 700, 1000, 1500, "Manager");
    }
}

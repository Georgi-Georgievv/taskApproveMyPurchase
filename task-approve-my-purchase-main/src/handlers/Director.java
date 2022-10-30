package handlers;
import common.Type;
import java.sql.SQLOutput;
/**
 * //TODO - If needed, validate logic and if possible optimize code.
 */
public class Director extends Approver {
    // Simply added a super constructor that is using the details of the Approver in order to be able to set parameters for our approvers.
    public Director() {
        super(500,1000,1500,3500,6000,"Director");
    }
}

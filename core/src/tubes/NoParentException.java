package tubes;

import java.util.ArrayList;

public class NoParentException extends Exception {
    private ArrayList<String> errorMessage;

    public NoParentException() {
        errorMessage = new ArrayList<>();
        errorMessage.add(0,"Engimon tidak memiliki Parent");
    }
    public ArrayList<String> getErrorMessage() {
        return this.errorMessage;
    }
}

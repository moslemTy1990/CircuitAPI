package circuitAPI;

public class PairInput<T extends Object>{
    private Boolean inputType;
    private T inputValue;

    public PairInput(Boolean inputType, T inputValue) {
        this.inputType = inputType;
        this.inputValue = inputValue;
    }

    public Boolean getInputType(){return inputType;}

    public  T getInputValue(){return inputValue;}

    boolean validaPair(){
        if(!(inputValue instanceof Boolean) && !(inputValue instanceof Double))
            return false;

        return true;
    }
    boolean validPairs(PairInput otherPair){
        if((otherPair.getInputType() != inputType) ||
                (otherPair.getInputValue() instanceof Boolean && inputValue instanceof Double) ||
                (otherPair.getInputValue() instanceof Double && inputValue instanceof Boolean))
            return false;

        return true;
    }

    boolean checkRange() throws Exception {
        if(inputType == false && !(inputValue instanceof Double))
            throw new Exception("Invalid Input Type");
        else if(inputType == false && (((Double)inputValue) < 0 ||  ((Double)inputValue) > 1))
            throw new Exception("Invalid Input Range");

        return true;
    }

    @Override
    public String toString() {
        return "(" +
                "" + inputType +
                ", " + inputValue +
                ')';
    }
}

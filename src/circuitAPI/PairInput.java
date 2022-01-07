package circuitAPI;

public class PairInput<T extends Object>{
    private Boolean inputType;
    private T inputValue;

    public PairInput(Boolean inputType, T inputValue){
        this.inputType = inputType;
        this.inputValue = inputValue;
    }
}

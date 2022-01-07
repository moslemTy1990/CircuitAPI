package circuitAPI;


public class GteGate<T extends Object> extends BinaryCircuit<T>{

    protected GteGate(Circuit<T> lOperand, Circuit<T> rOperand){
        super(lOperand, rOperand);
    }

    @Override
    public T getValue() throws Exception {
        if(rOperand.getValue() instanceof PairInput && lOperant.getValue() instanceof  PairInput
                && (((PairInput) rOperand.getValue()).getInputValue() instanceof Double && ((PairInput) lOperant.getValue()).getInputValue() instanceof Double )){
            return getValueOfPairInput();
        }
        else
            throw new Exception("Invalid Input Type");
    }

    public T getValueOfBoolean() throws Exception {
        Object value= (Boolean)rOperand.getValue() && (Boolean)lOperant.getValue();
        return (T)value;
    }

    public T getValueOfPairInput() throws Exception {
        Object inputValue1 = ((PairInput)lOperant.getValue()).getInputValue();
        Object inputValue2 = ((PairInput)rOperand.getValue()).getInputValue();
        Object result = null;

        if(((PairInput)rOperand.getValue()).checkRange() && ((PairInput)lOperant.getValue()).checkRange()) {
            result = ((Double)inputValue1 >= (Double)inputValue2)? true : false;
        }

        return (T) new PairInput(true,result);
    }
}

package circuitAPI;

import org.hamcrest.Factory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GteGate<T extends Object> extends BinaryCircuit<T>{

    protected GteGate(Circuit rOperand, Circuit lOperand){
        super(rOperand, lOperand);
    }

    @Override
    public T getValue() throws Exception {

        CircuitFactory factory = new CircuitFactory();

        Circuit and = factory.createAnd(lOperant, rOperand);
        Circuit not = factory.createNot(lOperant);
        Circuit or = factory.createOr(and, not);

        return (T)or.getValue();

    }
}

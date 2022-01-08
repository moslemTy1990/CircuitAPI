# Circuit API

CircuitAPI is a tool that can be used for making AND, OR, NOT, GTE gates

## System requirements
* Java 16+


## How to run

in order to use this API, add CircuitAPI.jar to your directory, you can create new Gates and logics by using
CircuitFactory. It can be used as bellow for creating (X1 And X2) logic:

	CircuitFactory factory = new CircuitFactory();
    Circuit x1 = factory.createConstant();
    Circuit x2 = factory.createConstant();
    Circuit and = factory.createAnd(x1, x2);
    x1.setValue(Boolean.valueOf(true));
    x2.setValue(Boolean.valueOf(true));

### What is each Gates functions:

And/Or/Not : these gates are the same logical operators that operate like below:

        X1 and X2 = X1 && X2 
        X1 or X2 = X1 || X2
        NOT X1 = ~X1

GTE Gate Operates like following:

    X1 gte X2 = this gate works just for PairInput(Boolean, Double)
        if (the double part of x1 >= x2)  => the result is (true, true)
        otherwise the result is (true, false)
        


## Supported Data Types #
Boolean Data Type are supported by gates.

CircuitAPI also supports two types of PairInput data Type that are as below:

    1. (true, Boolean) -- true mean that the second value in pair is Boolean Type
    2. (false, Double) -- false mean that the second value in pair is Double Type


In the case of Double PairInput format, the rules of And/Or/Not are as following:

    not((false, d)) = (false, 1-d)
    and((false, d1), false, d2)) = (false, d1*d2)
    or((false, d1), (false, d2)) =(false, 1-(1-d1)*(1-d2))

# Contributors
* Shyam Akhter

* Renisa Suryahadikusumah

* Moslem Teymoori

* Shabnam Zarepoor

    
    
    
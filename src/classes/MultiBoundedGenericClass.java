package classes;

import interfaces.Interface1;

public class MultiBoundedGenericClass<T extends Object & Interface1> {
    T var;

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar() {
        return var;
    }
}

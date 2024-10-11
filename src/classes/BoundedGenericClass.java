package classes;

// upper bounded generic class
public class BoundedGenericClass<T extends Number> {
    T variable;

    public void setVariable(T variable) {
        this.variable = variable;
    }

    public T getVariable() {
        return variable;
    }
}

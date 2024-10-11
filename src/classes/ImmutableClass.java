package classes;

import java.util.ArrayList;
import java.util.List;

// add final to class so it cannot be extended
public final class ImmutableClass {

    // make variables final and private
    private final String var;
    private final List<Object> varList;

    // can only set values to variables in constructor
    public ImmutableClass(String var, List<Object> varList) {
        this.var = var;
        this.varList = varList;
    }

    // only getters are allowed, setters are not preset
    // for String, its immutable so we can just send it like this for String
    public String getVar() {
        return var;
    }

    // only getters are allowed, setters are not preset
    // send copy of Arraylist
    public List<Object> getVarList() {
        return new ArrayList<>(varList);
    }
}

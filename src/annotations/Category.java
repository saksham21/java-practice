package annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Repeatable(Categories.class)
public @interface Category {
    String name();
}

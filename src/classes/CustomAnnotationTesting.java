package classes;

import annotations.Categories;
import annotations.Category;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Category(name = "Name1")
@Category(name = "Name2")
public class CustomAnnotationTesting {

    public static void main(String[] args) {
        Category[] aList = CustomAnnotationTesting.class.getDeclaredAnnotationsByType(Category.class);
        System.out.println(aList.length);
        for(Category a: aList) {
            System.out.println(a.name());
            System.out.println(a.annotationType());
            System.out.println();
        }

        Categories[] bList = CustomAnnotationTesting.class.getDeclaredAnnotationsByType(Categories.class);
        System.out.println(bList.length);
        for(Categories a: bList) {
            System.out.println(Arrays.stream(a.value()).toList());
            System.out.println(a.annotationType());
            System.out.println();
        }
    }
}

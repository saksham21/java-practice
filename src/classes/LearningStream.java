package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LearningStream {

    public static void main(String []args) {

        List<Integer> salaryList = new ArrayList<>();
        salaryList.add(100002);
        Stream<Integer> newSalaryStream = salaryList.stream().filter(s-> s>1000).filter(s->s>10001);
        List<Integer> newSalaryList = newSalaryStream.collect(Collectors.toList());
        System.out.println(newSalaryList);
//        System.out.println(newSalaryStream.peek(null));
    }
}

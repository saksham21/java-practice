package enums;

import interfaces.Interface1;

public enum SimpleEnumImplementsInteface implements Interface1 {
    MONDAY {
        @Override
        public void method1() {
            System.out.println("Monday method1");
        }
    },
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    @Override
    public void method1() {
        System.out.println("General method1");
    }
}

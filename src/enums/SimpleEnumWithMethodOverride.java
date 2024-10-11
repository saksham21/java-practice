package enums;

public enum SimpleEnumWithMethodOverride {
    MONDAY(1, "1st day of the week") {
        @Override
        public void dummyMethod() {
            System.out.println("Dummy method of " + this.getVal() + " , " + this.getComment() + " , " + this.name());
        }
    },
    TUESDAY(2, "2nd day of the week"),
    WEDNESDAY(3, "3rd day of the week"),
    THURSDAY(4, "4th day of the week"),
    FRIDAY(5, "5th day of the week"),
    SATURDAY(6, "6th day of the week"),
    SUNDAY(7, "7th day of the week");

    private int val;
    private String comment;

    SimpleEnumWithMethodOverride(int val, String comment) {
        this.val = val;
        this.comment = comment;
    }

    public int getVal() {
        return val;
    }

    public String getComment() {
        return comment;
    }

    public static SimpleEnumWithMethodOverride getEnumFromValue(int val) {
        for(SimpleEnumWithMethodOverride v: SimpleEnumWithMethodOverride.values()) {
            if(v.val == val) {
                return v;
            }
        }
        return null;
    }

    public void dummyMethod() {
        System.out.println("default dummy method");
    }
}

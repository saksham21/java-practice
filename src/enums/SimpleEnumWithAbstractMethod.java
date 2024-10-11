package enums;

public enum SimpleEnumWithAbstractMethod {
    MONDAY(1, "1st day of the week") {
        @Override
        public void dummyMethod() {

        }
    },
    TUESDAY(2, "2nd day of the week") {
        @Override
        public void dummyMethod() {

        }
    },
    WEDNESDAY(3, "3rd day of the week") {
        @Override
        public void dummyMethod() {

        }
    },
    THURSDAY(4, "4th day of the week") {
        @Override
        public void dummyMethod() {

        }
    },
    FRIDAY(5, "5th day of the week") {
        @Override
        public void dummyMethod() {

        }
    },
    SATURDAY(6, "6th day of the week") {
        @Override
        public void dummyMethod() {

        }
    },
    SUNDAY(7, "7th day of the week") {
        @Override
        public void dummyMethod() {

        }
    };

    private int val;
    private String comment;

    SimpleEnumWithAbstractMethod(int val, String comment) {
        this.val = val;
        this.comment = comment;
    }

    public int getVal() {
        return val;
    }

    public String getComment() {
        return comment;
    }

    public static SimpleEnumWithAbstractMethod getEnumFromValue(int val) {
        for(SimpleEnumWithAbstractMethod v: SimpleEnumWithAbstractMethod.values()) {
            if(v.val == val) {
                return v;
            }
        }
        return null;
    }

    public abstract void dummyMethod();
}

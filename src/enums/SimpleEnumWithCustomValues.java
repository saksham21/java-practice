package enums;

public enum SimpleEnumWithCustomValues {
    MONDAY(1, "1st day of the week") ,
    TUESDAY(2, "2nd day of the week"),
    WEDNESDAY(3, "3rd day of the week"),
    THURSDAY(4, "4th day of the week"),
    FRIDAY(5, "5th day of the week"),
    SATURDAY(6, "6th day of the week"),
    SUNDAY(7, "7th day of the week");

    private int val;
    private String comment;

    SimpleEnumWithCustomValues(int val, String comment) {
        this.val = val;
        this.comment = comment;
    }

    public int getVal() {
        return val;
    }

    public String getComment() {
        return comment;
    }

    public static SimpleEnumWithCustomValues getEnumFromValue(int val) {
        for(SimpleEnumWithCustomValues v: SimpleEnumWithCustomValues.values()) {
            if(v.val == val) {
                return v;
            }
        }
        return null;
    }
}

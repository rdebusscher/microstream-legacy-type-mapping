package be.rubus.microstream.demo.mapping.complex;

import java.util.StringJoiner;

public class Country {

    public static final Country DEFAULT;

    static {
        DEFAULT = new Country();
        DEFAULT.setCode("D");
        DEFAULT.setName("Germany");
    }

    private String code;

    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Country.class.getSimpleName() + "[", "]")
                .add("code='" + code + "'")
                .add("name='" + name + "'")
                .toString();
    }
}

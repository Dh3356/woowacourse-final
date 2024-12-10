package lotto.model.enums;

public enum ModelEnum {

    ENUM1("data");

    private final String data;

    ModelEnum(final String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

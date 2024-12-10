package lotto.model;

public class Model {

    private final String data;

    private Model(final String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Model{" +
                "data='" + data + '\'' +
                '}';
    }
}

package lotto.view.response;

import lotto.model.Model;

public class ModelResponse {

    private final String data;

    private ModelResponse(final String data) {
        this.data = data;
    }

    public static ModelResponse from(final Model model) {
        return new ModelResponse(model.getData());
    }

    public String getData() {
        return data;
    }
}

package menu.model.category;

public enum Category {

    JAPANESE_FOOD("일식"),
    KOREAN_FOOD("한식"),
    CHINESE_FOOD("중식"),
    ASIAN_FOOD("아시안"),
    WESTERN_FOOD("양식");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}

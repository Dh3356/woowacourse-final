package menu.model.menu;

import static menu.model.category.Category.ASIAN_FOOD;
import static menu.model.category.Category.CHINESE_FOOD;
import static menu.model.category.Category.JAPANESE_FOOD;
import static menu.model.category.Category.KOREAN_FOOD;
import static menu.model.category.Category.WESTERN_FOOD;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.model.category.Category;

public enum Menu {

    GYUDON("규동", JAPANESE_FOOD),
    UDON("우동", JAPANESE_FOOD),
    MISO_SOUP("미소시루", JAPANESE_FOOD),
    SUSHI("스시", JAPANESE_FOOD),
    KATSUDON("가츠동", JAPANESE_FOOD),
    ONIGIRI("오니기리", JAPANESE_FOOD),
    HIGH_RICE("하이라이스", JAPANESE_FOOD),
    RAMEN("라멘", JAPANESE_FOOD),
    OKONOMIYAKI("오코노미야끼", JAPANESE_FOOD),


    KIMBAP("김밥", KOREAN_FOOD),
    KIMCHI_STEW("김치찌개", KOREAN_FOOD),
    SSAMBAP("쌈밥", KOREAN_FOOD),
    SOYBEAN_PASTE_STEW("된장찌개", KOREAN_FOOD),
    BIBIMBAP("비빔밥", KOREAN_FOOD),
    KALGUKSU("칼국수", KOREAN_FOOD),
    BULGOGI("불고기", KOREAN_FOOD),
    TTEOKBOKKI("떡볶이", KOREAN_FOOD),
    STIR_FRIED_PORK("제육볶음", KOREAN_FOOD),


    KKANPUNGGI("깐풍기", CHINESE_FOOD),
    FRIED_NOODLES("볶음면", CHINESE_FOOD),
    DONGPO_PORK("동파육", CHINESE_FOOD),
    BLACK_BEAN_NOODLES("짜장면", CHINESE_FOOD),
    JJAMPPONG("짬뽕", CHINESE_FOOD),
    MAPO_TOFU("마파두부", CHINESE_FOOD),
    SWEET_AND_SOUR_PORK("탕수육", CHINESE_FOOD),
    STIR_FRIED_TOMATO_EGG("토마토 달걀볶음", CHINESE_FOOD),
    RED_PEPPER_JAPCHAE("고추잡채", CHINESE_FOOD),


    PAD_THAI("팟타이", ASIAN_FOOD),
    KHAO_PAD("카오 팟", ASIAN_FOOD),
    NASI_GORENG("나시고렝", ASIAN_FOOD),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥", ASIAN_FOOD),
    RICE_NOODLES("쌀국수", ASIAN_FOOD),
    TOM_YUM_GOONG("똠얌꿍", ASIAN_FOOD),
    BANH_MI("반미", ASIAN_FOOD),
    VIETNAMESE_SSAM("월남쌈", ASIAN_FOOD),
    BUN_CHA("분짜", ASIAN_FOOD),


    LASAGNA("라자냐", WESTERN_FOOD),
    GRATIN("그라탱", WESTERN_FOOD),
    GNOCCHI("뇨끼", WESTERN_FOOD),
    QUICHE("끼슈", WESTERN_FOOD),
    FRENCH_TOAST("프렌치 토스트", WESTERN_FOOD),
    BAGUETTE("바게트", WESTERN_FOOD),
    SPAGHETTI("스파게티", WESTERN_FOOD),
    PIZZA("피자", WESTERN_FOOD),
    PANINI("파니니", WESTERN_FOOD);

    private final String name;
    private final Category category;


    Menu(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public static Menu from(String name) {
        return Arrays.stream(values())
                .filter(menu -> menu.name.equals(name))
                .findFirst()
                .orElseThrow(MenuException::notFound);
    }

    public static List<Menu> fromCategory(Category category) {
        return Arrays.stream(values())
                .filter(value -> value.category == category)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                "category=" + category +
                '}';
    }
}

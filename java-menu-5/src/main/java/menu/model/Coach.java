package menu.model;

import menu.model.vo.coach_name.CoachName;

public class Coach {

    private final CoachName name;

    private Coach(final String name) {
        this.name = CoachName.from(name);
    }

    public static Coach from(final String name) {
        return new Coach(name);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name=" + name +
                '}';
    }
}

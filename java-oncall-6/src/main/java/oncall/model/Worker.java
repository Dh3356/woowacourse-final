package oncall.model;

import java.util.Objects;

public class Worker {

    private final String nickName;

    private Worker(final String nickName) {
        this.nickName = nickName;
    }

    public static Worker from(final String nickName) {
        return new Worker(nickName);
    }

    private void validateNickName(final String nickName) {
        if (nickName.length() > 5) {
            throw new IllegalArgumentException("닉네임은 5자를 초과할 수 없습니다.");
        }
    }

    public String getNickName() {
        return nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Worker worker = (Worker) o;
        return Objects.equals(nickName, worker.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nickName);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "nickName='" + nickName + '\'' +
                '}';
    }
}

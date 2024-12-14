# 구현 기능 목록

## 1. 게임 시작 메시지를 출력하는 기능

- [ ]`숫자 야구 게임을 시작합니다.`를 출력한다.

## 2. 랜덤한 숫자를 생성하는 기능

- [ ] 1~9 중 중복되지 않는 랜덤한 숫자를 세 개 생성해 가지고 있는다.

## 3. 사용자에게 숫자를 입력받는 기능

- [ ] `숫자를 입력해주세요 : `를 출력한다.
- [ ] 1~9 사이의 정수를 입력받는다.
- 다음과 같은 경우에 예외가 발생하고, 예외가 발생하면 프로그램을 종료한다.
    - [ ] 사용자 입력이 정수가 아닌 경우.

## 4. 사용자가 입력한 수와 2에서 생성한 수를 비교해 결과를 구하는 기능

- [ ] 사용자가 입력한 수와 2에서 생성하는 수를 비교해 결과를 구한다.
- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱.
- 다음과 같은 경우에 예외가 발생하고, 예외가 발생하면 프로그램을 종료한다.
    - [ ] 사용자 입력이 세 자리 정수가 아닌 경우.
    - [ ] 숫자가 중복되는 경우 ex) 121, 133

## 5. 결과를 출력하는 기능

- [ ] 4에서 구한 결과를 출력한다.

## 6. 3스트라이크라면 게임을 종료하는 기능

- [ ] `3개의 숫자를 모두 맞히셨습니다! 게임 종료`를 출력한다.

## 7. 재시도 여부를 입력받고 재시도를 수행하는 기능

- [ ] `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.` 를 출력한다.
- [ ] 사용자로부터 재시도 여부를 입력받는다.
- 다음과 같은 경우에 예외가 발생하고, 예외가 발생하면 프로그램을 종료한다.
    - 입력이 1 또는 2가 아닌 경우.
- 사용자가 1을 입력했다면, 2부터 다시 시작한다.
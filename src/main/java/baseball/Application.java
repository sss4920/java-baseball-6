package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현

        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.start();

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        while (true){
            try {
                int restartOrExit = Integer.parseInt(Console.readLine());
                if (restartOrExit == 1){
                    baseBallGame.start();
                    continue;
                }
                break;
            }catch (Exception e){
                throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
            }
        }
    }
}

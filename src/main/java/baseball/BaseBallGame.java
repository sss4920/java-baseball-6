package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseBallGame {
	private List<Integer> computer = new ArrayList<>();

	BaseBallGame() {}

	private void setComputer(){
		computer.clear();
		while (computer.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
	}

	private void run(){
			while (true) {
				System.out.print("숫자를 입력해주세요 : ");
				String userNumber;
				try{
					userNumber = Console.readLine();
					if (userNumber.length()>3 || userNumber.isEmpty()){
						throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
					}
				}catch (Exception e){
					throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
				}
				System.out.println(userNumber);
				String result = makeResultString(reportGame(userNumber));
				System.out.println(result);
				if (result.equals(BaseBallResult.THREE_STRIKE.result)) {
					break;
				}
			}
	}

	/**
	 * 설명: 유저가 준 숫자에 대해 볼 개수와 스트라이크 개수를 카운트함.
	 * @param userNumber: 유저가 준 숫자.
	 * @return gameResult : 볼개수와 스트라이크 개수.
	 */
	public int[] reportGame(String userNumber){
		int ballCount = 0;
		int strikeCount = 0;
		int [] gameResult;
		for (int i=0; i<3; i++){

			if (computer.get(i) == userNumber.charAt(i) - '0'){
				strikeCount++;
			}
			for (int j=i;j<3;j++){
				if (computer.get(i) == (userNumber.charAt(j) - '0')){
					ballCount ++;
				}
			}
		}
		gameResult = new int[] {ballCount, strikeCount};
		return gameResult;
	}

	/**
	 * 설명 : 결과 문자열 리턴.
	 * @param gameResult : 볼개수와 스트라이크 개수
	 * @return : 결과 문자열
	 */
	private String makeResultString(int[] gameResult){
		StringBuilder sb = new StringBuilder();
		if (gameResult[0] == 0 && gameResult[1] ==0){ //모두 틀리는 케이스
			return BaseBallResult.NOTHING.result;
		}
		if (gameResult[1] == 3){
			return BaseBallResult.THREE_STRIKE.result; //3스트라이크인 경우
		}
		if (gameResult[0] >= 1){
			sb.append(gameResult[0])
				.append("볼");
		}
		if (gameResult[1] >= 1){
			sb.append(" ")
				.append(gameResult[1])
				.append("스트라이크");
		}
		return sb.toString().strip();
	}

	public void start(){
		setComputer();
		System.out.println("숫자 야구 게임을 시작합니다.");
		run();
	}
}

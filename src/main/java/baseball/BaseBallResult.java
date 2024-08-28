package baseball;

/**
 * String Builder 등으로 결과를 계속 넣으니까 코드가 복잡해지는 것 같아서 enum을 통해 정리
 * 하지만 고민. 그냥 StringBuilder로 모든 경우를 넣는게 맞을까 1볼 1스트라이크 이런경우를 다 enum에 넣는게 더 좋을까?
 */
public enum BaseBallResult {


	NOTHING(0,"낫싱"),

	ONE_BALL(1,"1볼"),
	TWO_BALL(2,"2볼"),
	THREE_BALL(3,"3볼"),

	ONE_STRIKE(1,"1스트라이크"),
	TWO_STRIKE(2,"2스트라이크"),
	THREE_STRIKE(3, "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	final int status;
	final String result;

	BaseBallResult(int status, String result) {
		this.status = status;
		this.result= result;
	}
}

package baseball;

/**
 * String Builder 등으로 결과를 계속 넣으니까 코드가 복잡해지는 것 같아서 enum을 통해 정리
 * 하지만 고민. 그냥 StringBuilder로 모든 경우를 넣는게 맞을까 1볼 1스트라이크 이런경우를 다 enum에 넣는게 더 좋을까?
 */
public enum BaseBallResult {

	THREE_STRIKE("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"),

	NOTHING("낫싱");

	final String result;

	BaseBallResult(String result) {
		this.result= result;
	}
}

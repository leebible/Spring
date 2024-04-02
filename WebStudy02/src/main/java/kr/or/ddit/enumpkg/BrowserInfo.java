package kr.or.ddit.enumpkg;

public enum BrowserInfo {

	EDG("엣지"), WHALE("웨일"), CHROME("크롬"), SAFARI("사파리"), OTHERS("기타"); //enum일때. 이렇게 되있어도 edg와 whale, chrome, safari, others의 타입은 browserinfo!
	//enum안에서 상수들의 순서가 유지가 된다.
	
	private BrowserInfo(String browserName) {
		this.browserName = browserName;
	}
	
	private String browserName;
	public String getBrowserName() {
		return browserName;
	}
	
	public static BrowserInfo findBrowser(String userAgent) {
		BrowserInfo finded = OTHERS;
		for(BrowserInfo single : values()) {
			if(userAgent.toUpperCase().contains(single.name())){
				finded = single;
				break;
			}
		}
		return finded;
	}

	public static String findBrowserName(String userAgent) { //static : 상수가 없어도 사용할수 있게 풀어놓는다.
		return findBrowser(userAgent).getBrowserName();
	}
	//private final BrowserInfo EDG = new BrowserInfo();// final : 상수로 만듬 (enum이 아니라 class일때)
	//private final BrowserInfo WHALE = new BrowserInfo();// final : 상수로 만듬 (enum이 아니라 class일때)
	//private BrowserInfo() {
	//	super();
	//} //class로 바꿔도 오류안남. enum도 클래스이기때문에.
	

}

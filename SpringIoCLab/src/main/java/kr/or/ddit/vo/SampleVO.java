package kr.or.ddit.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE) //기본생성자 없애기, 초록색 버튼은 접근제한자가 public이라는 뜻
@Builder
public class SampleVO {
	private String id;
	private String name;
	private String role;
	
}

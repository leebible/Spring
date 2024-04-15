package kr.or.ddit.case07.vo;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class BankInfoVO { //db의 스키마가 vo에 영향을 , vo가 입력받을 form에 영향을 줌 //Command Object로 쓰임
	@NotBlank
	private String bankNo;
	
	@NotBlank
	private String bankName;
	@NotBlank
	private String bankUserName;
//	private LocalDate bankDate;
	@NotBlank
	private String bankDate;
}

package kr.or.ddit.case07.vo;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
//	@NotBlank (String일때만)
	//date타입을 파싱하기 위한 장치
//	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate bankDate;
}

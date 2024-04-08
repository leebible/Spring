package kr.or.ddit.person.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class PersonVO implements Serializable {
	private String id;
	private String name;
	private String gender;
	private long age;
	private String address;
}

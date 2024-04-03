package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 회원관리를 위한 Domain Layer
 *
 */

@Data
@Getter
@Setter
@ToString(exclude = {"memPass","memRegno1","memRegno2"})
@EqualsAndHashCode(of = "memId")
public class MemberVO implements Serializable {
	private String memId;
	//마샬링할때도 노출안되게 하는 방법 :
	@JsonIgnore
	private transient String memPass; //노출X : transient
	private String memName;
	@JsonIgnore
	private transient String memRegno1;
	@JsonIgnore
	private transient String memRegno2;
	private String memBir;
	private String memZip;
	private String memAdd1;
	private String memAdd2;
	private String memHometel;
	private String memComtel;
	private String memHp;
	private String memMail;
	private String memJob;
	private String memLike;
	private String memMemorial;
	private String memMemorialday;
	private Long memMileage;
	private boolean memDelete;
	
	private Set<CartVO> cartList; //Has Many //set :중복을 허용하지 않겠다!
	
	
}

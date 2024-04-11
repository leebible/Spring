package kr.or.ddit.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.validate.groups.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString.Exclude;

/**
 *	상품관리를 위한 Domain Layer
 *	1번 그룹 (상품입력시 검증그룹) : 
 *	2번 그룹 (수정시 검증 그룹) : 
 */
@Data
@EqualsAndHashCode(of = "prodId")
//@ToString(exclude = "prodDetail")
public class ProdVO implements Serializable{
	
	@NotBlank(groups = UpdateGroup.class)
	private String prodId;
	
	@NotBlank
	private String prodName;
	@NotBlank(groups = InsertGroup.class)
	private String prodLgu;
	@NotBlank
	private String prodBuyer;
	@Min(0) //value=0. single..anotation?사용해서 숫자만 넣어도 됨
	private long prodCost; //값만 담을수 있는 변수기때문에 null reference를 담을 수 없음
	@Min(0)
	private long prodPrice;
	@Min(0)
	private long prodSale;
	@NotBlank
	private String prodOutline;
	@Exclude
	private String prodDetail;
	@NotBlank
	private String prodImg;
	@Min(0)
	private long prodTotalstock;
	private LocalDate prodInsdate;
	@Min(0)
	private long prodProperstock;
	private String prodSize;
	private String prodColor;
	private String prodDelivery;
	private String prodUnit;
	private Long prodQtyin; //null reference 담을수 있음
	private Long prodQtysale;
	private Long prodMileage;
	
	private BuyerVO buyer; // Has a 관계(1:1), PROD(1) : BUYER(1) --> ProdVO has a BuyerVO
	private LprodVO lprod; // Has a 관계(1:1), PROD(1) : LPROD(1) --> ProdVO has a LprodVO
	private List<CartVO> cartList; // Has Many
	
	
}

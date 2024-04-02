package kr.or.ddit.vo;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString.Exclude;

@Data
@EqualsAndHashCode(of = "prodId")
//@ToString(exclude = "prodDetail")
public class ProdVO implements Serializable{
	private String prodId;
	private String prodName;
	private String prodLgu;
	private String prodBuyer;
	private long prodCost;
	private long prodPrice;
	private long prodSale;
	private String prodOutline;
	@Exclude
	private String prodDetail;
	private String prodImg;
	private long prodTotalstock;
	private LocalDate prodInsdate;
	private long prodProperstock;
	private String prodSize;
	private String prodColor;
	private String prodDelivery;
	private String prodUnit;
	private long prodQtyin;
	private long prodQtysale;
	private long prodMileage;
	
	private BuyerVO buyer; // Has a 관계(1:1), PROD(1) : BUYER(1) --> ProdVO has a BuyerVO
	private LprodVO lprod; // Has a 관계(1:1), PROD(1) : LPROD(1) --> ProdVO has a LprodVO
}

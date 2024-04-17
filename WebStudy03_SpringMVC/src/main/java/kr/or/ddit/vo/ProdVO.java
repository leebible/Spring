package kr.or.ddit.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.validate.groups.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString.Exclude;





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
	@NotBlank(groups = InsertGroup.class)
	private String prodBuyer;
	@Min(0)	
	private long prodCost;
	@Min(0)	
	private long prodPrice;
	@Min(0)	
	private long prodSale;
	@NotBlank
	private String prodOutline;
	@Exclude
	private String prodDetail;
	@NotBlank
	private String prodImg; //DB 데이터를 받기위한 프로퍼티
	public void setProdImage(MultipartFile prodImage) {
		if(prodImage.isEmpty()) return;
		this.prodImage = prodImage;
		this.prodImg = UUID.randomUUID().toString();
	}
    private MultipartFile prodImage; // client의 part 데이터를 받기위한 프로퍼티.
	@Min(0)
	private long prodTotalstock;
	@DateTimeFormat(iso = ISO.DATE) //java.util.Date, java.util.Calendar, java.time.* 
	private LocalDate prodInsdate;
	@Min(0)
	private long prodProperstock;
	private String prodSize;
	private String prodColor;
	private String prodDelivery;
	private String prodUnit;
	private Long prodQtyin;
	private Long prodQtysale;
	private Long prodMileage;
	
	private BuyerVO buyer; // Has a 관계 (1:1), PROD(1) : BUYER(1) --> ProdVO has a BuyerVO
	private LprodVO lprod; // Has a 관계 (1:1), PROD(1) : LPROD(1) --> ProdVO has a LprodVO
	private List<CartVO> cartList; // Has Many
}

























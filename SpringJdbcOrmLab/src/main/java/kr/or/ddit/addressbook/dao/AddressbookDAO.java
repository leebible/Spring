package kr.or.ddit.addressbook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.AddressbookVO;
import kr.or.ddit.vo.BuyerVO;

@Mapper
public interface AddressbookDAO {
	/**
	 * 주소록 전체 조회
	 * @return
	 */
	
	public List<AddressbookVO> selectAddressBookList();
	/**
	 * 주소록 단건 조회
	 * @param adrsNo
	 * @return
	 */
	public AddressbookVO selectAddress(Long adrsNo);
	
	/**
	 * 주소록 추가
	 * @param abook
	 * @return
	 */
	public int insertAddress(AddressbookVO abook);
	
	/**
	 * 주소록 수정
	 * @param abook
	 * @return
	 */
	public int updateAddress(AddressbookVO abook);
	
	/**
	 * 주소록 삭제
	 * @param adrsNo
	 * @return
	 */
	public int deleteAddress(Long adrsNo);
}

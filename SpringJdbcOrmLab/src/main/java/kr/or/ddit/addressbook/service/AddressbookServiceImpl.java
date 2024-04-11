package kr.or.ddit.addressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.addressbook.dao.AddressbookDAO;
import kr.or.ddit.vo.AddressbookVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressbookServiceImpl implements AddressbookService {
	private final AddressbookDAO dao; //생성자 필요(injection필요없음. 알아서 container가 넣어줄테니!)

	@Override
	public List<AddressbookVO> selectAddressBookList() {
		return dao.selectAddressBookList();
	}

	@Override
	public AddressbookVO selectAddress(Long adrsNo) {
		return dao.selectAddress(adrsNo);
	}

	@Override
	public int insertAddress(AddressbookVO abook) {
		return dao.insertAddress(abook);
	}

	@Override
	public int updateAddress(AddressbookVO abook) {
		return 0;
	}

	@Override
	public int deleteAddress(Long adrsNo) {
		return 0;
	}



}

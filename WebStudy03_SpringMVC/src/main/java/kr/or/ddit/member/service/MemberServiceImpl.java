package kr.or.ddit.member.service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.login.BadCredentialException;
import kr.or.ddit.login.service.AuthenticateService;
import kr.or.ddit.login.service.AuthenticateServiceImpl;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.paging.PaginationInfo;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProdVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberDAO dao;
	
	@Value("/resources/memberImages/") // 웹 리소스. (폴더 표현) 뒤에 / 붙이기, prefix 아무것도 안붙음
	private Resource memberImages;
	
	@Autowired
	private AuthenticateService authService;

	private void encryptMember(MemberVO member) {
		String plain = member.getMemPass();
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String encoded = encoder.encode(plain);
		member.setMemPass(encoded);
	}
	
	private void processImage(MemberVO member) { // 폴더는 스프링안에서 Resource 타입으로
		MultipartFile uploadFile = member.getMemImage();
		if (uploadFile==null) return;
		try {
			Resource saveRes = memberImages.createRelative(uploadFile.getOriginalFilename());
			FileUtils.copyInputStreamToFile(uploadFile.getInputStream(), saveRes.getFile());
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	@Override
	public ServiceResult createMember(MemberVO member) {
		ServiceResult result = null;
		if(dao.selectMember(member.getMemId())==null) {
			encryptMember(member);
			int rowcnt = dao.insertMember(member);
			if(rowcnt > 0){
				result = ServiceResult.OK;
			}else { 
				result = ServiceResult.FAIL;
			}
		}else {
			result = ServiceResult.PKDUPLICATED;
		}
		return result;
	}

	@Override
	public List<MemberVO> retrieveMemberList(PaginationInfo paging) {
		int totalRecord = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return dao.selectMemberList(paging);
	}

	@Override
	public MemberVO retrieveMember(String memId) throws PkNotFoundException {
		MemberVO member = dao.selectMember(memId);
		if(member==null)
			throw new PkNotFoundException(500);
		return member;
	}

	@Override
	public ServiceResult modifyMember(MemberVO member) throws PkNotFoundException {
		try {
			authService.authenticate(member);
			return dao.updateMember(member) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}catch (BadCredentialException e) {
			return ServiceResult.INVALIDPASSWORD;
		}
	}

	@Override
	public ServiceResult removeMember(MemberVO inputData) throws PkNotFoundException {
		try {
			authService.authenticate(inputData);
			return dao.deleteMember(inputData.getMemId()) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}catch (BadCredentialException e) {
			return ServiceResult.INVALIDPASSWORD;
		}
	}

}











package kr.or.ddit.prod.service;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.paging.PaginationInfo;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.vo.ProdVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdServiceImpl implements ProdService {
	private final ProdDAO dao;

	@Value("/resources/prodImages/") // 웹 리소스. (폴더 표현) 뒤에 / 붙이기, prefix 아무것도 안붙음
	private Resource prodImages;

	@PostConstruct
	public void init() throws IOException {
		if (!prodImages.exists()) {
			prodImages.getFile().mkdirs();
		}
	}

	private void processImage(ProdVO prod) { // 폴더는 스프링안에서 Resource 타입으로
		if(1==1) { //true
			throw new RuntimeException("강제 발생 예외");
		}
		MultipartFile uploadFile = prod.getProdImage();
		String saveName = prod.getProdImg();
		if (uploadFile==null) return;
		try {
//			Resource saveRes = prodImages.createRelative(saveName);
			File saveFile = new File(prodImages.getFile(), saveName);
			FileUtils.copyInputStreamToFile(uploadFile.getInputStream(), saveFile);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	@Override
	public ServiceResult createProd(ProdVO prod) { // 한개의 로직안에서 두가지 등록절차를 이룸
		if (dao.insertProd(prod) > 0) {
			processImage(prod);
			return ServiceResult.OK;
		} else {
			return ServiceResult.FAIL;
		}
	}

	@Override
	public List<ProdVO> retrieveProdList(PaginationInfo paging) {
		int totalRecord = dao.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return dao.selectProdList(paging);
	}

	@Override
	public ProdVO retrieveProd(String prodId) throws PkNotFoundException {
		ProdVO prod = dao.selectProd(prodId);
		if (prod == null)
			throw new PkNotFoundException(500);
		return prod;
	}
	
//	@Transactional //AOP방법론을 이용한 선언적 프로그래밍. 실제필드에서는권장하지 않음. Target에 결합력을 주는거니까.
	@Override
	public ServiceResult modifyProd(ProdVO prod) {
		if (dao.updateProd(prod) > 0) {
			processImage(prod);
			return ServiceResult.OK;
		} else {
			return ServiceResult.FAIL;
		}
	}
}

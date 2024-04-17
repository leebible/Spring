package kr.or.ddit.prod.service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.vo.ProdVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdServiceImpl implements ProdService {
	private final ProdDAO dao;
	
	@Value("/resources/images/") //웹 리소스. (폴더 표현) 뒤에 / 붙이기, prefix 아무것도 안붙음
	private Resource prodImages;
	
	@PostConstruct
	public void init() throws IOException {
		if(!prodImages.exists()) {
			prodImages.getFile().mkdirs();
		}
	}
	
	private void processImage(ProdVO prod) { //폴더는 스프링안에서 Resource 타입으로
		String saveName = prod.getProdImg();
		if(StringUtils.isBlank(saveName)) return;
		try {
			Resource saveRes = prodImages.createRelative(saveName);
			MultipartFile uploadFile = prod.getProdImage();
			FileUtils.copyInputStreamToFile(uploadFile.getInputStream(), saveRes.getFile());
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	
	@Override
	public ServiceResult createProd(ProdVO prod) { //한개의 로직안에서 두가지 등록절차를 이룸
		if(dao.insertProd(prod) > 0) {
			processImage(prod);
			return ServiceResult.OK;
		}else {
			return ServiceResult.FAIL;
		}
	}

	@Override
	public List<ProdVO> retrieveProdList() {
		return dao.selectProdList();
	}

	@Override
	public ProdVO retrieveProd(String prodId) throws PkNotFoundException {
		ProdVO prod = dao.selectProd(prodId);
		if(prod==null)
			throw new PkNotFoundException(500);
		return prod;
	}

	@Override
	public ServiceResult modifyProd(ProdVO prod) {
		return dao.updateProd(prod) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}
}

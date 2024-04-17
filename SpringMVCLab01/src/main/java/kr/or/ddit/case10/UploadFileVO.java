package kr.or.ddit.case10;

import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
//@NoArgsConstructor : final이 붙어있으면 기본생성자생성X
@AllArgsConstructor
public class UploadFileVO {
	private final MultipartFile file;
	
	public UploadFileVO(MultipartFile file) {
		this.file = file;
		this.fileName = file.getOriginalFilename();
		this.fileSize = file.getSize();
		this.saveName = UUID.randomUUID().toString();
	}
	public UploadFileVO(String fileName, String saveName, long fileSize) {
			this(null, fileName, saveName, fileSize); //오버로딩 되어있는 다른 생성자를 호출할때 사용
	}
	private String fileName;
	private String saveName;
	private long fileSize;

}

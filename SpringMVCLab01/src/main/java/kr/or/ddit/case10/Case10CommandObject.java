package kr.or.ddit.case10;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
public class Case10CommandObject {
	private String[] uploader;
	private int count;
	
	@ToString.Exclude
	@JsonIgnore
	private transient MultipartFile[] uploadFile;
	public void setUploadFile(MultipartFile[] uploadFile) {
		this.uploadFile = uploadFile;
		this.voList = new ArrayList<>();
		for(MultipartFile single : uploadFile) {
			if(single.isEmpty()) continue;
			voList.add(new UploadFileVO(single));
			
		}
	}
	
	private List<UploadFileVO> voList;

}

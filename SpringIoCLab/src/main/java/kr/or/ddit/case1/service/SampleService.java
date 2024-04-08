package kr.or.ddit.case1.service;

import java.util.List;

import kr.or.ddit.vo.SampleVO;
import lombok.extern.slf4j.Slf4j;

public interface SampleService {
	public List<SampleVO> readSampleList();
	public SampleVO readSample(String id);
}

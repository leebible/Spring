package kr.or.ddit.servlet04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.Session;

public class test {
public static void main(String[] args) throws IOException {
	File data = new File("src/main/resources/kr/or/ddit/MemberData.properties");
	//파일 읽기
	try(
		FileReader fr = new FileReader(data);
		BufferedReader br = new BufferedReader(fr);
	){
		String memData;
		String id="135";
		String info[];
		String name="";
		Map<String, String> memMap = new HashMap<String, String>();
		while(!((memData=br.readLine())==null)) {
			System.out.println(memData);
			id = memData.substring(0, 5);
			info = memData.split("\\|");
			System.out.println("info: "+info[0]);
			name = info[0].substring(6);
			memMap.put(id, name); 
			System.out.println("ㅇㅅㅇ:"+memMap.get(id));
		}
		System.out.println("memMap에 저장된값: "+memMap);
		System.out.println("memMap.values()에 저장된값: "+memMap.values());
		
	}
	
	
    //데이터 | 를 기준으로 분리해서 name|gender|age|address 각 변수에 저장하기
    //나눈 후 setAttribute로 memberForm jsp로 보내기
    //jsp에서 1차로 name값만 li에 넣고 뿌리고
    //2차로 js이용해서 클릭했을때 모달창에 나머지 데이터 뜨게 하기
}
}

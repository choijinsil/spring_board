package com.encore.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.domain.SampleVO;
import com.encore.domain.Ticket;

@RestController
@RequestMapping("/sample")
public class SampleController {

	@GetMapping(value = "/getText")
	public String getText() {
		return "안녕?";
	}

	@GetMapping(value = "/getSample", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}

	@RequestMapping("/getList")
	public List<SampleVO> getList() {
		List<SampleVO> list = new ArrayList<SampleVO>();
		list.add(new SampleVO(1, "first1", "Last1"));
		list.add(new SampleVO(2, "first2", "Last2"));
		list.add(new SampleVO(3, "first3", "Last3"));
		return list;
	}

	@RequestMapping("/getMap")
	public Map<String, SampleVO> getMap() {
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put("first", new SampleVO(111, "그루트", "주니어"));
		return map;
	}

	@RequestMapping(value = "/check")
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		// 에러 방지용으로 Double을 사용한다.
		SampleVO vo = new SampleVO(0, "" + height, "" + weight);
		ResponseEntity<SampleVO> result = null;
		// ResponseEntity --return 데이터+(조작된) 서버의 상태
		if (height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
	}
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat,
							@PathVariable("pid") Integer pid){
		//경로변수를 사용하는 경우 {}의 갯수만큼 메소드의 매개변수에 @Pathvariable선언이 있어야 하고
		//경로변수와 같은 이름이 정의되어 있어야 한다.
		//뒤에 변수명은 메소드 바디에서 사용할 새로 정의된 변수이다.
		return new String[] {"category: "+cat, "productid: "+pid};
	}
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		//requestBody: Html에서 전달되는 Json을 vo로 변환
		System.out.println("ticket>>"+ticket);
		return ticket;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

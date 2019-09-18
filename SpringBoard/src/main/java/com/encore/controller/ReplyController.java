package com.encore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.encore.domain.Criteria;
import com.encore.domain.ReplyPageDTO;
import com.encore.domain.ReplyVO;
import com.encore.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {

	@Autowired
	private ReplyService service;
	
	//댓글 작성
    @PostMapping(value = "/new", consumes = "application/json",
    		     produces = {MediaType.TEXT_PLAIN_VALUE})	
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {    	
    	int insertCnt = service.register(vo);//insertCnt ==> 추가된 행의 갯수
    	System.out.println("insertCnt>>>"+ insertCnt);
    	return  (insertCnt == 1)  ?   new ResponseEntity<>("success", HttpStatus.OK) 
    			: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
	}
    
    @PostMapping("/new2")	
    public String create2(ReplyVO vo) {    	
    	int insertCnt = service.register(vo);//insertCnt ==> 추가된 행의 갯수
    	return  (insertCnt == 1)  ? "success":"fail"; 
    }
    
    //댓글 조회  (요청URL --->   http://192.168.0.96/replies/2   + GET )
    @GetMapping("/{rno}")
//    public ReplyVO get(@PathVariable("rno") int  rno) {
//    	 return service.get(rno);
//    }
    public ResponseEntity<ReplyVO> get(@PathVariable("rno") int  rno) {
    	return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
    }
    
    //댓글 삭제 (요청URL --->   http://192.168.0.96/replies/1    + DELETE)
    @DeleteMapping("/{rno}")
//    public String remove(@PathVariable("rno") int  rno) {
//    	int delCnt = service.remove(rno);
//    	return (delCnt==1) ? "success" : "fail";
//    }
    public ResponseEntity<String> remove(@PathVariable("rno") int  rno) {
    	int delCnt = service.remove(rno);
    	return (delCnt==1) ? new ResponseEntity<>("success",HttpStatus.OK) :
    		                 new ResponseEntity<>("fail",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    //댓글 수정 (요청URL --->   http://192.168.0.96/replies/1    + PUT 또는 PATCH)
    //@PutMapping
    @RequestMapping(value = "/{rno}",
    		       method = {RequestMethod.PUT,RequestMethod.PATCH},
    		       consumes = "application/json")
    public ResponseEntity<String> modify(@RequestBody ReplyVO vo,
    		//@RequestBody:   JSON   ----->   VO 로  변환!!
    		                      @PathVariable("rno") int  rno) {
    	System.out.println("댓글번호>>>"+rno);
        vo.setRno(rno);
    	System.out.println("댓글수정>>>"+vo);
    	int upCnt = service.modify(vo);
    	
    	return (upCnt==1) ? new ResponseEntity<>("success",HttpStatus.OK) :
    		new ResponseEntity<>("fail",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    //특정 게시물에 대한 댓글 목록 조회 (페이징)
    //(요청URL --->   http://192.168.0.96/replies/pages/256/1    + GET)
    @GetMapping(value = "/pages/{bno}/{page}")
    public ResponseEntity<ReplyPageDTO> getList(@PathVariable("bno") Integer bno,
    		            @PathVariable("page") Integer page) {
        Criteria cri = new Criteria(page,10);// (1,10)  ---> 1페이지 10개의 레코드
        return new ResponseEntity<>( service.getListPage(cri, bno), HttpStatus.OK );
    }
	
}







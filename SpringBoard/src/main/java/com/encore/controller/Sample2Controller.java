package com.encore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class Sample2Controller {

	@GetMapping("/all")
	public void doAll() {
		System.out.println("모든 사용자가 접속할 수 있음");
	}

	@GetMapping("/member")
	public void doMember() {
		System.out.println("로그인된 사용자 접속할 수 있음");
	}

	@GetMapping("/admin")
	public void doAdmin() {
		System.out.println("관리자 접속할 수 있음");
	}

	@RequestMapping("/list")
	public void list() {
		System.out.println(">>>list");
	}

	@RequestMapping("/delete")
	public void delete() {
		System.out.println(">>>delete");
	}

	@RequestMapping("/update")
	public void update() {
		System.out.println(">>>update");
	}

	// ------------로그인
	@GetMapping("/login")
	public void loginForm() {

	}

	@PostMapping("/loginPost")
	public void loginPost(String username, String password, HttpSession session) {
		if (username.equals("siri") && password.equals("1234")) {
			session.setAttribute("login", "success");
			
		}
	}

}

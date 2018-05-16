package org.navin.ocbr.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@RequestMapping("/rest")
	public String heartBeat() {
		return "beat";
	}
	
	@RequestMapping("/error")
	public String errorPage() {
		return "My Error Page";
	}	
}

package com.cdac.controller;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdac.service.IncrementService;

@RestController
	public class MyController {
		@Autowired
		IncrementService incrementService;

		@GetMapping("/")
		public String doIncrement() {//Welcome page, non-rest
			System.out.println("hello from controller");
			return "Reslult :: "+incrementService.increaseNumberForID();
		}

}

package com.example.demo.pro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GrilController {
	
	@Autowired
	private GrilRep grilRep;
	
	@RequestMapping(value="/grils", method=RequestMethod.GET)
	public List<Gril> getAll() {
		return grilRep.findAll();
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public Gril addGril(@RequestParam("cupSize") String cupSize,
			@RequestParam("age") Integer age) {
		Gril gril = new Gril();
		gril.setAge(age);
		gril.setCupSize(cupSize);
		return grilRep.save(gril);
	}

}

package klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import klu.model.StudentManager;

@RestController
@CrossOrigin(origins = "http://localhost:1292/")
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentManager SM;
	
	@GetMapping("/getstudents/{cpage}/{psize}")
	public String getStudents(@PathVariable("cpage") int cPage, 
							  @PathVariable("psize") int pSize)
	{
		return SM.getData(cPage - 1, pSize);
	}
	
	@GetMapping("/getpages/{psize}")
	public String getPages(@PathVariable("psize") int pSize)
	{
		return SM.getPages(pSize);
	}
}

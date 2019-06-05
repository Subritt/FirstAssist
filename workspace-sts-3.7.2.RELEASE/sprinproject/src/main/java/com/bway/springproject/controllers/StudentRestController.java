package com.bway.springproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bway.springproject.daos.StudentDao;
import com.bway.springproject.model.Student;

@RestController
@RequestMapping("api/student")
public class StudentRestController{
	
	@Autowired
	private StudentDao studentDao;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> studentList(){
		
		ResponseEntity<List<Student>> studList = new ResponseEntity<>(studentDao.getAllStudent(), HttpStatus.OK);
		
		return studList;
		
	}
	
	@RequestMapping(value="/id", method = RequestMethod.GET)
	public ResponseEntity<Student> getBYId(@PathVariable("id") int id){
		
		ResponseEntity<Student> s = new ResponseEntity<>(studentDao.getById(id),HttpStatus.OK);
		
		return s;
		
	}

}

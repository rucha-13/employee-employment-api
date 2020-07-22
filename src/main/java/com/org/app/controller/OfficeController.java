package com.org.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.app.model.Office;
import com.org.app.services.OfficeService;

@RestController
public class OfficeController {

	@Autowired
	private OfficeService service;
	
	@RequestMapping(value = "/office" ,method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Office>addOfficeDeatil(@RequestBody Office office) {
		Office off = service.saveOfficeDetails(office);
		return ResponseEntity.accepted().body(off);
	}
	
	@RequestMapping("/offices")
	public ResponseEntity<List<Office>> getAllOffices(){
		List<Office> officeList = service.fetchAllOfficeLocations();
		return ResponseEntity.status(HttpStatus.FOUND).body(officeList);
	}
	
	@RequestMapping("/office/{id}")
	public ResponseEntity<Office> getOfficeDetailsById(@PathVariable("id") Integer id){
		Office office = service.fetchOfficeDetailById(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(office);
	}
	
	@RequestMapping(value = "/office/{id}" ,consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public ResponseEntity<Office> updateOfficeDetails(@RequestBody Office office,@PathVariable("id") Integer id){
		Office updatedOffice = service.updateStreetAddress(office, id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedOffice);
	}
	
	@RequestMapping(value = "/offices", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAllOfficeDetails(){
		service.deleteAll();
		return ResponseEntity.status(HttpStatus.FOUND).body("deleted all data of office.");
	}
	
	@RequestMapping(value = "/office/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteOfficeDetailById(@PathVariable("id") Integer id){
		service.deleteOfficeDetailById(id);
		return ResponseEntity.status(HttpStatus.FOUND).body("deleted  data of office for id "+id);
	}
	
}

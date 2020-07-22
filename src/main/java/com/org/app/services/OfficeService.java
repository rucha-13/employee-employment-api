package com.org.app.services;

import java.util.List;

import com.org.app.model.Office;

public interface OfficeService {

	public List<Office>fetchAllOfficeLocations();
	public Office saveOfficeDetails(Office office);
	public Office updateStreetAddress(Office office,Integer officeId);
	public void deleteAll();
	public void deleteOfficeDetailById(Integer id);
	public Office fetchOfficeDetailById(Integer officeId);
	
}

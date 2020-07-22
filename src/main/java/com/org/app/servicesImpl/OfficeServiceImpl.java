package com.org.app.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.app.model.Office;
import com.org.app.repository.OfficeRepository;
import com.org.app.services.OfficeService;

@Service
public class OfficeServiceImpl implements OfficeService{

	@Autowired
	private OfficeRepository repo;
	
	@Override
	public List<Office> fetchAllOfficeLocations() {
		List <Office>locations = new ArrayList<Office>();
		repo.findAll().forEach(locations::add);
		return locations;
	}

	@Override
	public Office saveOfficeDetails(Office office) {
		return repo.save(office);
	}

	@Override
	public Office updateStreetAddress(Office office,Integer officeId) {
		Office oldLocation = this.fetchOfficeDetailById(officeId);
		if(office.getCity()!=null)
			oldLocation.setCity(office.getCity());
		if(office.getPostalCode()!=null)
			oldLocation.setPostalCode(office.getPostalCode());
		if(office.getStreetName()!=null)
			oldLocation.setStreetName(office.getStreetName());
		return repo.save(oldLocation);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}

	@Override
	public Office fetchOfficeDetailById(Integer officeId) {
		return repo.findById(officeId).get();
	}

	@Override
	public void deleteOfficeDetailById(Integer id) {
		repo.deleteById(id);
	}

}

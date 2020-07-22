package com.org.app.servicesImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.org.app.model.Employee;
import com.org.app.model.Winner;
import com.org.app.repository.WinnerRepository;
import com.org.app.services.EmployeeService;
import com.org.app.services.WinnerService;

@Service
public class WinnerServiceImpl implements WinnerService {

	@Autowired
	private EmployeeService service; 
	
	@Autowired
	private WinnerRepository winnerRepo;
	
	@Scheduled(cron="0 10 17 28 * ?")
	public void scheduledTask() {
		List<Employee> employeeList = service.findAllEmployee();
		Random rand = new Random();
		Employee emp = (Employee) employeeList.get(rand.nextInt(employeeList.size()));
		Winner winner = new Winner(emp,new Date(System.currentTimeMillis()));
		winnerRepo.save(winner);
	}
	@Override
	public Winner findWinner(int month,int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
		return winnerRepo.getWinner(month,year);
	}
	@Override
	public List<Winner> findAll() {
		List list = new ArrayList();
		winnerRepo.findAll().forEach(list::add);;
		return list;
	}

}

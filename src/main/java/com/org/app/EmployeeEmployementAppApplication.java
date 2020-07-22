package com.org.app;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.org.app.model.Department;
import com.org.app.model.Employee;
import com.org.app.model.Office;
import com.org.app.repository.DepartmentRepository;
import com.org.app.repository.EmployeeRepository;
import com.org.app.repository.OfficeRepository;

@SpringBootApplication
@EnableScheduling
public class EmployeeEmployementAppApplication implements CommandLineRunner{

	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private OfficeRepository offRepo;
	
	@Autowired
	private DepartmentRepository depRepo;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeEmployementAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Office office1 = offRepo.save(new Office("prince street","Wembly","WA2 12A"));
		Office office2 = offRepo.save(new Office("Greenwich street","NY","NY2 12A"));
		Office office3 = offRepo.save(new Office("Queen street","London","EC2 12A"));
		Office office4 = offRepo.save(new Office("abc street","Glasgow","GA3 12A"));
		
		Department dpt1 = depRepo.save(new Department("Card Payment",office2));
		Department dpt2 = depRepo.save(new Department("Loan Payment",office1));
		Department dpt3 = depRepo.save(new Department("Sales",office3));
		Department dpt4 = depRepo.save(new Department("Marketing",office2));
		
		Employee emp1 = empRepo.save(new Employee("John","Spencer","john@mail.com",new Long(789223122),new Date(),office2,dpt1,new Double(340000)));
		Employee emp2 = empRepo.save(new Employee("Merry","J","merryn@mail.com",new Long(729223122),new Date(),office3,dpt3,new Double(360000)));
		Employee emp3 = empRepo.save(new Employee("Jenni","Markel","jenni@mail.com",new Long(709223122),new Date(),office2,dpt1,new Double(940000)));
		Employee emp4 = empRepo.save(new Employee("Raj","K","raj@mail.com",new Long(719223122),new Date(),office3,dpt3,new Double(1400000)));
		Employee emp5 = empRepo.save(new Employee("Robbert","Johnson","johnson@mail.com",new Long(729263122),new Date(),office2,dpt1,new Double(900000)));
		Employee emp6 = empRepo.save(new Employee("Cuper","M","cupper@mail.com",new Long(700223122),new Date(),office3,dpt3,new Double(80000)));

	}

}

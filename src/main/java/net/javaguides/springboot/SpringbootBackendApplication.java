package net.javaguides.springboot;

import net.javaguides.springboot.entity.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {
	private final EmployeeRepository employeeRepository;
	public SpringbootBackendApplication(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Employee employee1 = Employee.builder()
				.firstName("Swetha")
				.lastName("Keerthi")
				.email("swetha@gmail.com")
				.build();

		Employee employee2 = Employee.builder()
				.firstName("John")
				.lastName("Dee")
				.email("john@gmail.com")
				.build();

		Employee employee3 = Employee.builder()
				.firstName("Josha")
				.lastName("De")
				.email("josha@gmail.com")
				.build();

		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
		employeeRepository.save(employee3);
		List<Employee> employeeList = employeeRepository.findAll();
		System.out.println("employeeList = " + employeeList);

	}
}

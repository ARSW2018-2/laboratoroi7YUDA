package hello;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

        private static final String USER_AGENT = "Mozilla/5.0";
        private static final String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=fb&apikey=Q1QZFVJQ21K7C6XM";

    
    
    
	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args)  throws IOException {
		SpringApplication.run(Application.class, args);
                
	}
        
        
        public void almacenar(String... args)throws Exception{
        
        
        
        }

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));
		repository.save(new Customer("julia", "lore"));
                repository.save(new Customer("julia", "Smith"));                   

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
                Customer per=repository.findByFirstName("julio");
                System.out.println("lalalal"+per.toString());
                
                List<Customer> er=repository.findByLastName("Smith");
                //System.out.println("miermos nombe"+repository.findByFirstName("julia"));
                for (int i=0;i<er.size();i++){
                    System.out.println("que imprime+"+er.get(i));
                
                
                }
                
                

	}

}

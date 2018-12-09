package com.aqryuz.zstore;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.aqryuz.zstore.entity.Product;
import com.aqryuz.zstore.entity.Role;
import com.aqryuz.zstore.entity.User;
import com.aqryuz.zstore.entity.Variant;
import com.aqryuz.zstore.repository.ProductDetailRepository;
import com.aqryuz.zstore.repository.ProductRepository;
import com.aqryuz.zstore.repository.RoleRepository;
import com.aqryuz.zstore.repository.UserRepository;
@Component
public class Seeder implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository ProductRepository;
	@Autowired
	private ProductDetailRepository ProductDetailRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private void productSeed() {
		for(int i=0; i<12; i++) {
			Product product = new Product();
			product.setName("product " + i);
			product.setPrice(new BigDecimal(i));
			product.setSalePrice(new BigDecimal(i));
			product.setImage(null);
			product.setImageName("product1.jpg");
			product.setStatus("new");
			product.setDescription("description " + i);
			product.setCreatedBy(userRepository.findByEmail("merchant1@gmail.com").get());
			product.setLastModifiedBy(userRepository.findByEmail("merchant1@gmail.com").get());

			Variant variant1 = new Variant();
			variant1.setQuantity(5);
			variant1.setSize("L");
			variant1.setProduct(product);

			Variant variant2 = new Variant();
			variant2.setQuantity(10);
			variant2.setSize("XXL");
			variant2.setProduct(product);

			ProductRepository.save(product);
			ProductDetailRepository.save(variant1);
			ProductDetailRepository.save(variant2);
			
		}
	}
	
	private void roleSeeds() {
		Role admin = new Role();
		admin.setName("ADMIN");
		Role customer = new Role();
		customer.setName("CUSTOMER");
		Role merchant = new Role();
		merchant.setName("MERCHANT");
		roleRepository.save(admin);
		roleRepository.save(customer);
		roleRepository.saveAndFlush(merchant);
		
	}
	
	private void userSeeds() {
		User customer1 = new User();
		customer1.setEmail("customer1@gmail.com");
		customer1.setPassword(passwordEncoder.encode("123"));
		customer1.setRole(roleRepository.findRoleByName("CUSTOMER"));
		customer1.setName("customer1");
		customer1.setEnabled(true);
		customer1.setAccountNonExpired(true);
		
		User customer2 = new User();
		customer2.setEmail("customer2@gmail.com");
		customer2.setPassword(passwordEncoder.encode("123"));
		customer2.setRole(roleRepository.findRoleByName("CUSTOMER"));
		customer2.setName("customer2");
		customer2.setEnabled(true);
		customer2.setAccountNonExpired(true);
		
		User merchant1 = new User();
		merchant1.setEmail("merchant1@gmail.com");
		merchant1.setPassword(passwordEncoder.encode("123"));
		merchant1.setRole(roleRepository.findRoleByName("MERCHANT"));
		merchant1.setName("merchant1");
		merchant1.setEnabled(true);
		merchant1.setAccountNonExpired(true);
		
		User merchant2 = new User();
		merchant2.setEmail("merchant2@gmail.com");
		merchant2.setPassword(passwordEncoder.encode("123"));
		merchant2.setRole(roleRepository.findRoleByName("MERCHANT"));
		merchant2.setName("merchant2");
		merchant2.setEnabled(true);
		merchant2.setAccountNonExpired(true);
		
		User admin1 = new User();
		admin1.setEmail("admin1@gmail.com");
		admin1.setPassword(passwordEncoder.encode("123"));
		admin1.setRole(roleRepository.findRoleByName("ADMIN"));
		admin1.setName("admin1");
		admin1.setEnabled(true);
		admin1.setAccountNonExpired(true);
		
		User admin2 = new User();
		admin2.setEmail("admin2@gmail.com");
		admin2.setPassword(passwordEncoder.encode("123"));
		admin2.setRole(roleRepository.findRoleByName("ADMIN"));
		admin2.setName("admin2");
		admin2.setEnabled(true);
		admin2.setAccountNonExpired(true);

		userRepository.save(customer1);
		userRepository.save(merchant1);
		userRepository.save(admin1);
		userRepository.save(customer2);
		userRepository.save(merchant2);
		userRepository.saveAndFlush(admin2);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}

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
		Product product1 = new Product();
		product1.setName("Geometry Pattern Pullover Hoodie - Ruby");
		product1.setPrice(new BigDecimal(5));
		product1.setSalePrice(new BigDecimal(5));
		product1.setImageName("men1.png");
		product1.setStatus("new");
		product1.setCategory("men");
		product1.setDescription("<p><strong>Clothes Type:</strong> Hoodies</p>" + 
				"Style: Casual\n" + 
				"Pattern Type: Snowman\n" + 
				"Material: Polyester\n" + 
				"Shirt Length: Regular\n" + 
				"Sleeves Length: Full\n" + 
				"Weight: 0.4890kg\n" + 
				"Package: 1 x Hoodie");

		Variant variant1 = new Variant();
		variant1.setQuantity(5);
		variant1.setSize("L");
		variant1.setProduct(product1);

		Variant variant2 = new Variant();
		variant2.setQuantity(10);
		variant2.setSize("XXL");
		variant2.setProduct(product1);

		ProductRepository.save(product1);
		ProductDetailRepository.save(variant1);
		ProductDetailRepository.saveAndFlush(variant2);

		Product product2 = new Product();
		product2.setName("Plaid Print Pocket Button Up Shirt - Sea Green");
		product2.setPrice(new BigDecimal(10));
		product2.setSalePrice(new BigDecimal(10));
		product2.setImageName("men2.png");
		product2.setStatus("new");
		product2.setCategory("men");
		product2.setDescription("Plaid shirt with a super soft feeling. Features a classic collar, long sleeves, a chest pocket and a button-up front.\n" + 
				"Shirts Type: Casual Shirts\n" + 
				"Sleeves Length: Full\n" + 
				"Collar: Turn-down Collar\n" + 
				"Fit Type: Regular\n" + 
				"Material: Cotton,Polyester,Viscose\n" + 
				"Weight: 0.4100kg\n" + 
				"Package: 1 x Shirt");

		Variant variant21 = new Variant();
		variant21.setQuantity(5);
		variant21.setSize("S");
		variant21.setProduct(product2);

		Variant variant22 = new Variant();
		variant22.setQuantity(10);
		variant22.setSize("M");
		variant22.setProduct(product2);

		ProductRepository.save(product2);
		ProductDetailRepository.save(variant21);
		ProductDetailRepository.saveAndFlush(variant22);

		Product product3 = new Product();
		product3.setName("Plaid Drawstring Hooded Shirt - Blue");
		product3.setPrice(new BigDecimal(8));
		product3.setSalePrice(new BigDecimal(5));
		product3.setImageName("men3.png");
		product3.setStatus("best seller");
		product3.setCategory("men");
		product3.setDescription("Shirts Type: Casual Shirts\n" + 
				"Sleeves Length: Full\n" + 
				"Collar: Hooded \n" + 
				"Fit Type: Regular \n" + 
				"Material: Cotton,Polyester \n" + 
				"Weight: 0.4000kg \n" + 
				"Package: 1 x Shirt");

		Variant variant31 = new Variant();
		variant31.setQuantity(100);
		variant31.setSize("S");
		variant31.setProduct(product3);

		Variant variant32 = new Variant();
		variant32.setQuantity(100);
		variant32.setSize("M");
		variant32.setProduct(product3);

		ProductRepository.save(product3);
		ProductDetailRepository.save(variant31);
		ProductDetailRepository.saveAndFlush(variant32);

		Product women10 = new Product();
		women10.setName("Striped Cropped T-Shirt - Fire Engine Red");
		women10.setPrice(new BigDecimal(10));
		women10.setSalePrice(new BigDecimal(9));
		women10.setImageName("women10.png");
		women10.setStatus("best seller");
		women10.setCategory("women");
		women10.setDescription("Style: Casual \n" + 
				"Collar: Crew Collar \n" + 
				"Sleeves Length: Short \n" + 
				"Material: Cotton,Polyester \n" + 
				"Pattern Type: Striped \n" + 
				"Weight: 0.1900kg \n" + 
				"Package: 1 x T-Shirt");

		Variant women101 = new Variant();
		women101.setQuantity(100);
		women101.setSize("S");
		women101.setProduct(women10);

		Variant women102 = new Variant();
		women102.setQuantity(100);
		women102.setSize("M");
		women102.setProduct(women10);

		ProductRepository.save(women10);
		ProductDetailRepository.save(women101);
		ProductDetailRepository.save(women102);

		Product men4 = new Product();
		men4.setName("Long Sleeves Jarcquard Denim Mens Shirt - Blue");
		men4.setPrice(new BigDecimal(10));
		men4.setSalePrice(new BigDecimal(9));
		men4.setImageName("men4.png");
		men4.setStatus("best seller");
		men4.setCategory("men");
		men4.setDescription("Shirts Type: Casual Shirts \n" + 
				"Sleeves Length: Full \n" + 
				"Collar: Turn-down Collar \n" + 
				"Material: Cotton \n" + 
				"Weight: 0.5000kg \n" + 
				"Package: 1 x Shirt");

		Variant men41 = new Variant();
		men41.setQuantity(100);
		men41.setSize("S");
		men41.setProduct(men4);

		ProductRepository.save(men4);
		ProductDetailRepository.save(men41);

		Product men5 = new Product();
		men5.setName("Flowers Printed Short Sleeve Shirt - Butterfly Blue");
		men5.setPrice(new BigDecimal(10));
		men5.setSalePrice(new BigDecimal(9));
		men5.setImageName("men5.png");
		men5.setStatus("new");
		men5.setCategory("men");
		men5.setDescription("Shirts Type: Casual Shirts \n" + 
				"Occasionss: Beach,Casual,Holiday \n" + 
				"Sleeves Length: Short \n" + 
				"Collar: Turn-down Collar \n" + 
				"Fit Type: Regular \n" + 
				"Material: Polyester \n" + 
				"Weight: 0.2000kg \n" + 
				"Package: 1 x Shirt");

		Variant men51 = new Variant();
		men51.setQuantity(100);
		men51.setSize("S");
		men51.setProduct(men5);

		ProductRepository.save(men5);
		ProductDetailRepository.saveAndFlush(men51);

		Product men6 = new Product();
		men6.setName("Casual Striped Hooded Shirt - Black");
		men6.setPrice(new BigDecimal(10));
		men6.setSalePrice(new BigDecimal(9));
		men6.setImageName("men6.png");
		men6.setStatus("new");
		men6.setCategory("men");
		men6.setDescription("Shirts Type: Casual Shirts \n" + 
				"Sleeves Length: Full \n" + 
				"Collar: Hooded \n" + 
				"Fit Type: Regular \n" + 
				"Material: Polyester \n" + 
				"Weight: 0.3900kg \n" + 
				"Package: 1 x Shirt");

		Variant men61 = new Variant();
		men61.setQuantity(100);
		men61.setSize("S");
		men61.setProduct(men6);

		ProductRepository.save(men6);
		ProductDetailRepository.saveAndFlush(men61);

		Product men7 = new Product();
		men7.setName("Retro Newspaper Print Button Up Shirt - White");
		men7.setPrice(new BigDecimal(10));
		men7.setSalePrice(new BigDecimal(9));
		men7.setImageName("men7.png");
		men7.setStatus("new");
		men7.setCategory("men");
		men7.setDescription("Shirts Type: Casual Shirts \n" + 
				"Sleeves Length: Full \n" + 
				"Collar: Turn-down Collar \n" + 
				"Fit Type: Regular \n" + 
				"Material: Polyester \n" + 
				"Weight: 0.2500kg \n" + 
				"Package: 1 x Shirt");

		Variant men71 = new Variant();
		men71.setQuantity(100);
		men71.setSize("S");
		men71.setProduct(men7);

		ProductRepository.save(men7);
		ProductDetailRepository.saveAndFlush(men71);

		Product men8 = new Product();
		men8.setName("Rose Flowers Print Casual Shirt - Black");
		men8.setPrice(new BigDecimal(10));
		men8.setSalePrice(new BigDecimal(9));
		men8.setImageName("men8.png");
		men8.setStatus("new");
		men8.setCategory("men");
		men8.setDescription("Shirts Type: Casual Shirts \n" + 
				"Sleeves Length: Full \n" + 
				"Collar: Turn-down Collar \n" + 
				"Fit Type: Regular \n" + 
				"Material: Cotton,Polyester \n" + 
				"Weight: 0.2000kg \n" + 
				"Package: 1 x Shirt");

		Variant men81 = new Variant();
		men81.setQuantity(100);
		men81.setSize("S");
		men81.setProduct(men8);

		ProductRepository.save(men8);
		ProductDetailRepository.saveAndFlush(men81);

		Product men9 = new Product();
		men9.setName("Button Fly Long Sleeves Striped Shirt - Midnight Blue");
		men9.setPrice(new BigDecimal(10));
		men9.setSalePrice(new BigDecimal(9));
		men9.setImageName("men9.png");
		men9.setStatus("new");
		men9.setCategory("men");
		men9.setDescription("Shirts Type: Casual Shirts \n" + 
				"Occasionss: Casual \n" + 
				"Sleeves Length: Full \n" + 
				"Collar: Turn-down Collar \n" + 
				"Fit Type: Regular \n" + 
				"Material: Cotton \n" + 
				"Weight: 0.2900kg \n" + 
				"Package: 1 x Shirt");

		Variant men91 = new Variant();
		men91.setQuantity(100);
		men91.setSize("S");
		men91.setProduct(men9);

		ProductRepository.save(men9);
		ProductDetailRepository.saveAndFlush(men91);

		Product women1 = new Product();
		women1.setName("Tie Striped T-shirt - Red");
		women1.setPrice(new BigDecimal(10));
		women1.setSalePrice(new BigDecimal(9));
		women1.setImageName("women1.png");
		women1.setStatus("new");
		women1.setCategory("women");
		women1.setDescription("Style: Casual \n" + 
				"Shirt Length: Regular \n" + 
				"Collar: Round Collar \n" + 
				"Sleeves Length: Full \n" + 
				"Material: Polyester,Spandex \n" + 
				"Elasticity: Elastic \n" + 
				"Decoration: Tie \n" + 
				"Pattern Type: Striped \n" + 
				"Seasons: Autumn,Spring,Winter \n" + 
				"Weight: 0.2500kg \n" + 
				"Package: 1 x T-shirt");

		Variant women11 = new Variant();
		women11.setQuantity(100);
		women11.setSize("S");
		women11.setProduct(women1);

		Variant women12 = new Variant();
		women12.setQuantity(100);
		women12.setSize("M");
		women12.setProduct(women1);

		ProductRepository.save(women1);
		ProductDetailRepository.save(women11);
		ProductDetailRepository.save(women12);

		Product women2 = new Product();
		women2.setName("Striped Ribbed Cropped Tee - Multi");
		women2.setPrice(new BigDecimal(10));
		women2.setSalePrice(new BigDecimal(9));
		women2.setImageName("women2.png");
		women2.setStatus("new");
		women2.setCategory("women");
		women2.setDescription("A cropped tee featuring multicolored stripes, a ribbed knit construction, a form-fitting silhouette, and a cropped length. Pair with high waisted denim bottoms for a complete look.\n" + 
				"Style: Fashion \n" + 
				"Collar: Round Collar \n" + 
				"Sleeves Length: Short \n" + 
				"Material: Cotton,Polyacrylic,Polyurethane \n" + 
				"Pattern Type: Striped \n" + 
				"Weight: 0.2100kg \n" + 
				"Package: 1 x Tee");

		Variant women21 = new Variant();
		women21.setQuantity(100);
		women21.setSize("S");
		women21.setProduct(women2);

		Variant women22 = new Variant();
		women22.setQuantity(100);
		women22.setSize("M");
		women22.setProduct(women2);

		ProductRepository.save(women2);
		ProductDetailRepository.save(women21);
		ProductDetailRepository.save(women22);

		Product women3 = new Product();
		women3.setName("Printed Short Sleeves Tee - Black");
		women3.setPrice(new BigDecimal(10));
		women3.setSalePrice(new BigDecimal(9));
		women3.setImageName("women3.png");
		women3.setStatus("new");
		women3.setCategory("women");
		women3.setDescription("This casual short-sleeved tee emphasizes a classic round collarline and abstract face printed pattern at the front. Wear it with denim shorts for a casual simple look.\n" + 
				"Style: Casual \n" + 
				"Collar: Round Collar \n" + 
				"Sleeves Length: Short \n" + 
				"Material: Cotton \n" + 
				"Pattern Type: Print \n" + 
				"Weight: 0.2500kg \n" + 
				"Package: 1 x Tee");

		Variant women31 = new Variant();
		women31.setQuantity(100);
		women31.setSize("S");
		women31.setProduct(women3);

		Variant women32 = new Variant();
		women32.setQuantity(100);
		women32.setSize("M");
		women32.setProduct(women3);

		ProductRepository.save(women3);
		ProductDetailRepository.save(women31);
		ProductDetailRepository.save(women32);

		Product women4 = new Product();
		women4.setName("American Flag Print Tee - Gray Goose");
		women4.setPrice(new BigDecimal(10));
		women4.setSalePrice(new BigDecimal(9));
		women4.setImageName("women3.png");
		women4.setStatus("new");
		women4.setCategory("women");
		women4.setDescription("Style: Casual \n" + 
				"Collar: Round Collar \n" + 
				"Sleeves Length: Three Quarter \n" + 
				"Material: Cotton,Polyester \n" + 
				"Pattern Type: American Flag,Letter \n" + 
				"Seasons: Spring,Summer \n" + 
				"Weight: 0.1800kg \n" + 
				"Package: 1 x Tee");

		Variant women41 = new Variant();
		women41.setQuantity(100);
		women41.setSize("S");
		women41.setProduct(women4);

		ProductRepository.save(women4);
		ProductDetailRepository.save(women41);
		
		Product women5 = new Product();
		women5.setName("Letter Print Contrast Asymmetric Tee - White And Black");
		women5.setPrice(new BigDecimal(10));
		women5.setSalePrice(new BigDecimal(9));
		women5.setImageName("women3.png");
		women5.setStatus("new");
		women5.setCategory("women");
		women5.setDescription("Crafted from comfy fabric, this trendy tee with round collar features letter print, color block design and asymmetric hemline.\n" + 
				"Style: Fashion \n" + 
				"Collar: Round Collar \n" + 
				"Sleeves Length: Short \n" + 
				"Material: Polyester \n" + 
				"Pattern Type: Letter,Patchwork \n" + 
				"Weight: 0.2600kg \n" + 
				"Package: 1 x Tee");

		Variant women51 = new Variant();
		women51.setQuantity(100);
		women51.setSize("S");
		women51.setProduct(women5);

		ProductRepository.save(women5);
		ProductDetailRepository.save(women51);
		
		Product women6 = new Product();
		women6.setName("Striped Knitted Tee - Medium Sea Green");
		women6.setPrice(new BigDecimal(10));
		women6.setSalePrice(new BigDecimal(9));
		women6.setImageName("women3.png");
		women6.setStatus("new");
		women6.setCategory("women");
		women6.setDescription("This casual short-sleeved tee with a classic round collarline features a comfy knitted fabric, contrasting striped graphic pattern throughout, and an alluring cropped length which shows your slimming waist. Wear it with denim shorts for a stylish look.\n" + 
				"Style: Casual \n" + 
				"Shirt Length: Crop Top \n" + 
				"Collar: Round Collar \n" + 
				"Sleeves Length: Short \n" + 
				"Material: Polyester \n" + 
				"Pattern Type: Striped \n" + 
				"Seasons: Spring ");

		Variant women61 = new Variant();
		women61.setQuantity(100);
		women61.setSize("S");
		women61.setProduct(women6);

		ProductRepository.save(women6);
		ProductDetailRepository.save(women61);
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
		customer1.setAddress("550 West 29th Street");
		customer1.setCity("New York");
		customer1.setPhone("2126291020");
		customer1.setEnabled(true);

		User customer2 = new User();
		customer2.setEmail("customer2@gmail.com");
		customer2.setPassword(passwordEncoder.encode("123"));
		customer2.setRole(roleRepository.findRoleByName("CUSTOMER"));
		customer2.setName("customer2");
		customer2.setAddress("67 Liberty street");
		customer2.setCity("New York");
		customer2.setPhone("2126999999");
		customer2.setEnabled(true);

		User aqryuz = new User();
		aqryuz.setEmail("aqryuz@gmail.com");
		aqryuz.setPassword(passwordEncoder.encode("123"));
		aqryuz.setRole(roleRepository.findRoleByName("CUSTOMER"));
		aqryuz.setName("aqryuz");
		aqryuz.setAddress("200 Pearl street");
		aqryuz.setCity("New York");
		aqryuz.setPhone("2126999999");
		aqryuz.setEnabled(true);


		User merchant1 = new User();
		merchant1.setEmail("merchant1@gmail.com");
		merchant1.setPassword(passwordEncoder.encode("123"));
		merchant1.setRole(roleRepository.findRoleByName("MERCHANT"));
		merchant1.setName("merchant1");
		merchant1.setAddress("2-18 Maiden Ln");
		merchant1.setCity("New York");
		merchant1.setPhone("0903838700");
		merchant1.setEnabled(true);

		User merchant2 = new User();
		merchant2.setEmail("merchant2@gmail.com");
		merchant2.setPassword(passwordEncoder.encode("123"));
		merchant2.setRole(roleRepository.findRoleByName("MERCHANT"));
		merchant2.setName("merchant2");
		merchant2.setAddress("102 West street");
		merchant2.setCity("New York");
		merchant2.setPhone("0913090903");
		merchant2.setEnabled(true);

		User admin1 = new User();
		admin1.setEmail("admin1@gmail.com");
		admin1.setPassword(passwordEncoder.encode("123"));
		admin1.setRole(roleRepository.findRoleByName("ADMIN"));
		admin1.setName("admin1");
		admin1.setEnabled(true);

		User admin2 = new User();
		admin2.setEmail("admin2@gmail.com");
		admin2.setPassword(passwordEncoder.encode("123"));
		admin2.setRole(roleRepository.findRoleByName("ADMIN"));
		admin2.setName("admin2");
		admin2.setEnabled(true);

		userRepository.save(customer1);
		userRepository.save(customer2);
		userRepository.save(aqryuz);
		userRepository.save(merchant1);
		userRepository.save(merchant2);
		userRepository.save(admin1);
		userRepository.saveAndFlush(admin2);
	}

	@Override
	public void run(String... args) throws Exception {
		/*roleSeeds();
		userSeeds();
		productSeed();*/
	}

}

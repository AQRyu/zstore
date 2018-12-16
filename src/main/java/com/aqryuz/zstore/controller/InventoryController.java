package com.aqryuz.zstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aqryuz.zstore.entity.Product;
import com.aqryuz.zstore.entity.User;
import com.aqryuz.zstore.service.ProductService;
import com.aqryuz.zstore.utils.Pager;

@Controller
@RequestMapping("/merchant/inventory")
public class InventoryController {
	private static final int INITIAL_PAGE = 0;
	@Autowired
	private ProductService productService;

	@GetMapping
	public String showInventory(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "4") Integer size,
			@RequestParam(name = "sort", required = false, defaultValue = "DESC") String sort,
			@RequestParam(name = "type", required = false, defaultValue = "id") String type
			) {
		Sort sortable = null;
		if (sort.equals("ASC")) {
			sortable = Sort.by(type).ascending();
		}
		if (sort.equals("DESC")) {
			sortable = Sort.by(type).descending();
		}

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		int evalPage = (page < 1) ? INITIAL_PAGE : page - 1;
		Pageable pageable = PageRequest.of(evalPage, size, sortable);

		Page<Product> products = productService.findAllByUser(pageable, user);
		Pager pager = new Pager(products);
		System.out.println(pager.getPageSize());

		model.addAttribute("products", products);
		model.addAttribute("pager", pager);
		return "merchant/inventory";
	}	

	@GetMapping(value = "/save")
	public String showSaveProductPage(@RequestParam(name = "id", required = false)Long id, Model model) {
		Product product = new Product();
		if(id != null) {
			product = productService.findById(id);
			System.out.println(product.toString());
		}
		model.addAttribute("product",product);
		return "merchant/saveProduct";
	}	

	@PostMapping(value = "/save")
	public String save(Model model, Product product, RedirectAttributes redirectAttributes) {
		productService.save(product);
		return "redirect:/inventory";
	}


	@GetMapping(value = "/delete")
	public String delete(@RequestParam(name = "id", required = true) Long id) {
		productService.delete(id);
		return "redirect:/inventory";
	}
}

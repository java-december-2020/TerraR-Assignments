package com.trobinson.products.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trobinson.products.models.Category;
import com.trobinson.products.models.Product;
import com.trobinson.products.services.CategoryService;
import com.trobinson.products.services.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService pService;
	
	@Autowired
	private CategoryService cService;
	
	
	// Landing page
	@GetMapping("/")
	public String landing(Model viewModel) {
		List<Product> products = pService.findAllProducts();
		viewModel.addAttribute("product", products);

		List<Category> categories = cService.findAllCategories();
		viewModel.addAttribute("category", categories);
		return "index.jsp";
	}

	
	// Add product
	@GetMapping("/products/new")
	public String displayAddNewProduct(@ModelAttribute("product") Product product) {
		return "new_product.jsp";
	}
	   
	// Post product
	@PostMapping("/products/new")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "/new_product.jsp";
		} else {
			pService.createProduct(product);
			return "redirect:/";
		}
	}
	
	
	// Add category
	@GetMapping("/categories/new")
	public String displayAddNewCategory(@ModelAttribute("category") Category category) {
		return "/new_category.jsp";
	}
	
	// Post category
	@PostMapping("/categories/new")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
		return "/new_category.jsp";
	} else {
		cService.createCategory(category);
		return "redirect:/";
		}
	}
	
	
	// Add category to product
	@GetMapping("/products/{id}")
	public String displayProduct(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("product", pService.findOneProduct(id));
		List<Category> categories = cService.findAllCategories();
		viewModel.addAttribute("category", categories);
		return "/update_product.jsp";
	}

	// Post category to project
	@PostMapping("/products/{id}")
	public String updateProduct(@PathVariable("id") Long product_id, @RequestParam(name = "category_id") Long category_id) {
		Product product = pService.findOneProduct(product_id);
		Category category = cService.findOneCategory(category_id);
		pService.updateProductCategory(product, category);
		return "redirect:/";
	}
	
	
	// Add product to category
	@GetMapping("/categories/{id}")
	public String displayCategory(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("category", cService.findOneCategory(id));
		List<Product> products = pService.findAllProducts();
		viewModel.addAttribute("product", products);
		return "/update_category.jsp";
	}

	// Post product to category
	@PostMapping("/categories/{id}")
	public String updateCategory(@PathVariable("id") Long category_id, @RequestParam(name = "product_id") Long product_id) {
		Product product = pService.findOneProduct(product_id);
		Category category = cService.findOneCategory(category_id);
		pService.updateProductCategory(product, category);
		return "redirect:/";
		}
	}

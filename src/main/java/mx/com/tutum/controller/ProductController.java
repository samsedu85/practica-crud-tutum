/**
 * 
 */
package mx.com.tutum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.com.tutum.dto.ProductDto;
import mx.com.tutum.models.service.IProductService;

/**
 * @author EduSam
 *
 */
@Controller
public class ProductController {

	private final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private IProductService productService;

	@GetMapping("/products")
	public String getProducts(Model model) {

		try {

			List<ProductDto> listProducts = productService.findAll();
			model.addAttribute("products", listProducts);
			logger.info("obteniendo lista de productos");

		} catch (Exception error) {
			model.addAttribute("mensaje_error", "Por el momento no es posible mostrar los productos");
		}

		return "products";
	}

	@GetMapping("/product/create")
	public String createProduct(Model model) {
		return "product_create";
	}

	@PostMapping("/product/save")
	public String saveProduct(ProductDto productDto, RedirectAttributes redirectAttributes) {
		return "redirect:/products";
	}

	@GetMapping("/product/{id}")
	public String updateProduct(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
		return "product_update";
	}

	@GetMapping("/product/delete/{id}")
	public String deleteProduct(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
		return "redirect:/products";
	}

}

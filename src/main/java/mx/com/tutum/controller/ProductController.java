/**
 * 
 */
package mx.com.tutum.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

	@GetMapping("/")
	public String get(Model model) {

		List<ProductDto> listProducts = new ArrayList<>();

		try {
			listProducts = productService.findAll();
			model.addAttribute("productos", listProducts);

		} catch (Exception error) {
			model.addAttribute("mensaje", "Por el momento no es posible mostrar los productos");
			logger.error(error.getMessage());
		}
		logger.info("obteniendo lista de productos");
		return "products";
	}

	@GetMapping("/products")
	public String getProducts(Model model, @Param("keyword") String keyword) {

		List<ProductDto> listProducts = new ArrayList<>();
		try {

			if (keyword == null) {
				listProducts = productService.findAll();
			} else {
				productService.findByNameContainingIgnoreCase(keyword).forEach(listProducts::add);
				model.addAttribute("keyword", keyword);
			}
			model.addAttribute("productos", listProducts);
			logger.info("obteniendo lista de productos");

		} catch (Exception error) {
			model.addAttribute("mensaje", "Por el momento no es posible mostrar los productos");
			logger.error(error.getMessage());
		}

		return "products";
	}

	@GetMapping("/product/create")
	public String createProduct(Model model) {
		ProductDto product = new ProductDto();
		model.addAttribute("producto", product);
		model.addAttribute("titulo", "Crear Producto");
		return "product_create";
	}

	@PostMapping("/product/save")
	public String saveProduct(ProductDto productDto, RedirectAttributes redirectAttributes) {

		try {
			productService.save(productDto);
			redirectAttributes.addFlashAttribute("mensaje", "El producto se guardo correctamente");
			logger.info("producto (" + productDto.getName() + ") se guardo correctamente");
		} catch (Exception error) {
			redirectAttributes.addFlashAttribute("mensaje", "Hubo un error al guardar el producto");
			logger.error(error.getMessage());
		}

		return "redirect:/products";
	}

	@GetMapping("/product/{id}")
	public String updateProduct(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {

		try {
			ProductDto produDto = productService.findById(id);
			model.addAttribute("producto", produDto);
			model.addAttribute("titulo", "Editar producto #" + produDto.getIdProduct());
			logger.info("Se actualizo correctamente el producto " + produDto.getName());

		} catch (Exception error) {
			redirectAttributes.addFlashAttribute("mensaje", "Hubo un error en la actualización");
			logger.error(error.getMessage());
		}

		return "product_create";
	}

	@GetMapping("/product/delete/{id}")
	public String deleteProduct(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {

		try {
			productService.deleteById(id);
			redirectAttributes.addFlashAttribute("mensaje", "El producto #" + id + " se elimino correctamente");
			logger.info("El producto #" + id + " se elimino correctamente");
		} catch (Exception error) {
			redirectAttributes.addFlashAttribute("mensaje", "Hubo un error al eliminar el producto");
			logger.error(error.getMessage());
		}
		return "redirect:/products";
	}

}

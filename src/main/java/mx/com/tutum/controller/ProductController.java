/**
 * 
 */
package mx.com.tutum.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
	

}

/**
 * 
 */
package mx.com.tutum.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * @author EduSam
 *
 */
@Getter
@Setter
public class ProductDto {

	private Long idProduct;
	private String name;
	private Double price;
	private LocalDateTime createAt;

}

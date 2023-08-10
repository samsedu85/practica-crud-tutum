/**
 * 
 */
package mx.com.tutum.models.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author EduSam
 *
 */
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7094636838296606312L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")
	private Long idProduct;

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Double price;

	@Column(name = "create_at")
	private LocalDateTime createAt;

}

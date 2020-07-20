package cl.boletasystem.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del proveedor")
@Entity
@Table(name = "proveedor")
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProveedor;

	@ApiModelProperty(notes = "La Razon social debe tener minimo 3 caracteres")
	@Size(min = 3, message = "La Razon social debe tener minimo 3 caracteres")
	@Column(name = "razon_social", nullable = false, length = 70)
	private String razonsocial;

	@ApiModelProperty(notes = "RUT debe tener 8 caracteres sin el digito berificador")
	@Size(min = 8, max = 8, message = "RUT debe tener 8 caracteres")
	@Column(name = "RUT", nullable = false, length = 8)
	private String rut;

	@ApiModelProperty(notes = "Dirección debe tener minimo 3 caracteres")
	@Size(min = 3, max = 150, message = "Dirección debe tener minimo 3 caracteres")
	@Column(name = "direccion", nullable = true, length = 150)
	private String direccion;

	@ApiModelProperty(value = "Teléfono debe tener 9 caracteres")
	@Size(min = 9, max = 9, message = "Telefono debe tener 9 caracteres")
	@Column(name = "telefono", nullable = true, length = 9)
	private String telefono;

	@ApiModelProperty(notes = "Correo electronico del proveedor")
	@Email
	@Column(name = "email", nullable = true, length = 55)
	private String email;	
	
	@ApiModelProperty(notes = "Indica si esta activo sy valor es TRUE o FALSE")
	@Column(name = "estado", nullable = false)
	private boolean enabled;

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getRazonsocial() {
		return razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



}

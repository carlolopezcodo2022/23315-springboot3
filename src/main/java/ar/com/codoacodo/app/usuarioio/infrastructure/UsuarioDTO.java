package ar.com.codoacodo.app.usuarioio.infrastructure;

public class UsuarioDTO {

	private Long id;

	private String nombre;
	
	public UsuarioDTO(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}

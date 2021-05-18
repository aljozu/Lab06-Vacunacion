package personadto;

import java.time.LocalDate;

public class PersonaDTO {

    private String idDTO;
    private String nombresDTO;
    private String apellidosDTO;
    private LocalDate fdnDTO;
    private String tlfDTO;
    private String emailDTO;
    private LocalDate fdvDTO;

	public String getIdDTO() {
		return this.idDTO;
	}

	public void setIdDTO(String idDTO) {
		this.idDTO = idDTO;
	}

	public String getNombresDTO() {
		return this.nombresDTO;
	}

	public void setNombresDTO(String nombresDTO) {
		this.nombresDTO = nombresDTO;
	}

	public String getApellidosDTO() {
		return this.apellidosDTO;
	}

	public void setApellidosDTO(String apellidosDTO) {
		this.apellidosDTO = apellidosDTO;
	}

	public LocalDate getFdnDTO() {
		return this.fdnDTO;
	}

	public void setFdnDTO(LocalDate fdnDTO) {
		this.fdnDTO = fdnDTO;
	}

	public String getTlfDTO() {
		return this.tlfDTO;
	}

	public void setTlfDTO(String tlfDTO) {
		this.tlfDTO = tlfDTO;
	}

	public String getEmailDTO() {
		return this.emailDTO;
	}

	public void setEmailDTO(String emailDTO) {
		this.emailDTO = emailDTO;
	}

	public LocalDate getFdvDTO() {
		return this.fdvDTO;
	}

	public void setFdvDTO(LocalDate fdvDTO) {
		this.fdvDTO = fdvDTO;
	}


    public PersonaDTO() {
        // default constructor
    }

}

package com.exemple.LRcar.LRcar.Model;

import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LRcar")
public class LRcarModel {

    @Id
    private UUID id = UUID.randomUUID(); 

  private String modelo;
  private String anodelancamento;
  private String cor;
  private String status;
  public class Veiculo {
	  
	  
	  
  }
public UUID getId() {
	return id;
}
public void setId(UUID id) {
	this.id = id;
}
public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public String getAnodelancamento() {
	return anodelancamento;
}
public void setAnodelancamento(String anodelancamento) {
	this.anodelancamento = anodelancamento;
}
public String getCor() {
	return cor;
}
public void setCor(String cor) {
	this.cor = cor;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
	 
	  
	    

  }

   
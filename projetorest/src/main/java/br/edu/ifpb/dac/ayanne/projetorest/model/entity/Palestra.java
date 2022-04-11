package br.edu.ifpb.dac.ayanne.projetorest.model.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity

public class Palestra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "palestra" )
	@JoinColumn(name = "palestra_id")
	private List<Palestrante> palestrantes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Palestrante> getPalestrantes() {
		return palestrantes;
	}
	public void setPalestrantes(List<Palestrante> palestrantes) {
		this.palestrantes = palestrantes;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, palestrantes, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Palestra other = (Palestra) obj;
		return Objects.equals(id, other.id) && Objects.equals(palestrantes, other.palestrantes)
				&& Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Palestra [id=" + id + ", title=" + title + ", palestrantes=" + palestrantes + "]";
	}


}

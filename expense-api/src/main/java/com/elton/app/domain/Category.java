package  com.elton.app.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CATEGORY")
@SequenceGenerator(name = "SEQUENCE_CATEGORY", sequenceName = "SEQUENCE_CATEGORY")
@Getter @Setter @EqualsAndHashCode
public class Category implements Serializable {

	private static final long serialVersionUID = -448760385229721893L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE_CATEGORY")
	@Column(name = "ID_CATEGORY", precision = 12, scale = 0)
	private Long id;

	@Column(name = "DESCRIPTION", nullable = false, length = 200)
	private String description;
}
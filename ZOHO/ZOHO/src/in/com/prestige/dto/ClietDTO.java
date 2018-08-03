package in.com.prestige.dto;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "client")
public class ClietDTO {
	@Id
	@Column(name="ClientID")
	private Integer clientId;
	@Column(name="ClientName")
	private String clientName;
	@OneToMany(targetEntity=UserDTO.class,cascade=CascadeType.ALL)
	@JoinColumn(name="ClientId",referencedColumnName="ClientID")
	private Set users;

}

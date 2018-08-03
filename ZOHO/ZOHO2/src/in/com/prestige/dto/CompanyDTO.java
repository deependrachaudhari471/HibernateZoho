package in.com.prestige.dto;

import java.sql.Timestamp;
import java.util.Date;
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
@Table(name="company")
public class CompanyDTO {
	@Id
	@Column(name="RegistrationNo")
	private Integer registrationNo;
	@Column(name="CompanyName")
	private String companyName;
	@Column(name="StartUpDate")
	private Date startUpDate;
	@Column(name="ContactNo")
	private String contactNo;
	@Column(name="Address")
	private String address;
	@Column(name="CompanyType")
	private String CompanyType;
	@OneToMany(targetEntity=ProjectMangagerDTO.class,cascade=CascadeType.ALL)
    @JoinColumn(name="CompanyId",referencedColumnName="RegistrationNo")
	private Set projectManager;

}

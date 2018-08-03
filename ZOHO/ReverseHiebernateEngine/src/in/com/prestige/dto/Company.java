package in.com.prestige.dto;
// Generated May 30, 2018 4:58:22 PM by Hibernate Tools 4.0.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Company generated by hbm2java
 */
@Entity
@Table(name = "company", catalog = "zohotest2")
public class Company implements java.io.Serializable {

	private int registrationNo;
	private String companyType;
	private String address;
	private String companyName;
	private String contactNo;
	private Date startUpDate;
	private Set<ProjectManager> projectManagers = new HashSet<ProjectManager>(0);

	public Company() {
	}

	public Company(int registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Company(int registrationNo, String companyType, String address, String companyName, String contactNo,
			Date startUpDate, Set<ProjectManager> projectManagers) {
		this.registrationNo = registrationNo;
		this.companyType = companyType;
		this.address = address;
		this.companyName = companyName;
		this.contactNo = contactNo;
		this.startUpDate = startUpDate;
		this.projectManagers = projectManagers;
	}

	@Id

	@Column(name = "RegistrationNo", unique = true, nullable = false)
	public int getRegistrationNo() {
		return this.registrationNo;
	}

	public void setRegistrationNo(int registrationNo) {
		this.registrationNo = registrationNo;
	}

	@Column(name = "CompanyType")
	public String getCompanyType() {
		return this.companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	@Column(name = "Address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "CompanyName")
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "ContactNo")
	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "StartUpDate", length = 19)
	public Date getStartUpDate() {
		return this.startUpDate;
	}

	public void setStartUpDate(Date startUpDate) {
		this.startUpDate = startUpDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<ProjectManager> getProjectManagers() {
		return this.projectManagers;
	}

	public void setProjectManagers(Set<ProjectManager> projectManagers) {
		this.projectManagers = projectManagers;
	}

}

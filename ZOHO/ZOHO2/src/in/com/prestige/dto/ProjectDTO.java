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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Project")
public class ProjectDTO {
	@Id
	@Column(name="ProjectId")
    private Integer projectId;
	@Column(name="ProjectName")
	private String projectName;
	@Column(name="StartDate")
	private Date startDate;
	@Column(name="EndDate")
	private Date endDate;
	@Column(name="Overview")
	private String overview;
	@Column(name="BillingMethod")
	private String billingMethod;
	@Column(name="Bugdet")
	private Double bugdetBasedOnHour;
	@Column(name="StatusActive")
	private String statusActive;
	
	@OneToOne(targetEntity=ClietDTO.class,cascade=CascadeType.ALL)
	@JoinColumn(name="ClientId",referencedColumnName="ClientID")
	private ClietDTO client;
	
	@OneToMany(targetEntity=UserDTO.class,cascade=CascadeType.ALL)
	@JoinColumn(name="projectId",referencedColumnName="ProjectId")
	private Set users;
	
	@OneToMany(targetEntity=BugDTO.class,cascade=CascadeType.ALL)
	@JoinColumn(name="projectId",referencedColumnName="ProjectId")
	private Set bugs;
	
	@OneToMany(targetEntity=MilestonDTO.class,cascade=CascadeType.ALL)
	@JoinColumn(name="projectId",referencedColumnName="ProjectId")
	private Set milestone;
	
	@OneToMany(targetEntity=ProjectGroupDTO.class,cascade=CascadeType.ALL)
	@JoinColumn(name="projectId",referencedColumnName="ProjectId")
	private Set projectGroup;
	
	@OneToMany(targetEntity=StatusDTO.class,cascade=CascadeType.ALL)
	@JoinColumn(name="projectId",referencedColumnName="ProjectId")
	private Set status;
	
	@OneToOne(targetEntity=ActivityDTO.class,cascade=CascadeType.ALL)
	@JoinColumn(name="ActivityId",referencedColumnName="ActivityId")
	private ActivityDTO activity;
	
	@OneToOne(targetEntity=DocumentDTO.class,cascade=CascadeType.ALL)
	@JoinColumn(name="DocID",referencedColumnName="DocID")
	private DocumentDTO docs;
}

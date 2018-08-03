package in.com.prestige.dto;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Milestone")
public class MilestonDTO {
	@Id
	@Column(name = "MilestoneId")
	private Integer milstoneId;
	@Column(name = "StartDate")
	private Date startDate;
	@Column(name = "EndDate")
	private Date endDate;
	@Column(name="MileStoneName")
    private String milestoneName;
	
	@OneToOne(targetEntity = ActivityDTO.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ActivityId", referencedColumnName = "ActivityId")
	private ActivityDTO activity;
	
	@ManyToMany(targetEntity = BugDTO.class, cascade = CascadeType.ALL)
	@JoinTable(name = "milestone_bugs", joinColumns = @JoinColumn(name = "Milestone_Id", referencedColumnName = "MilestoneId"), inverseJoinColumns = @JoinColumn(name = "Bug_Id", referencedColumnName = "BugId"))
	private Set bugs;

}

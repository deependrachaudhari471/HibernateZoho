package in.com.prestige.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
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

}

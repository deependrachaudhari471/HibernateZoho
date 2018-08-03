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
@Table(name = "Bug")
public class BugDTO {
	@Id
	@Column(name = "BugId")
	private Integer bugId;
	@Column(name = "BugTitle")
	private String bugTitle;
	@Column(name = "Descrption")
	private String description;
	@Column(name = "DueDate")
	private Date dueDate;
	@Column(name = "Open")
	private Integer open;
	@Column(name = "Closed")
	private Integer closed;

	@OneToOne(targetEntity = ActivityDTO.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ActivityId", referencedColumnName = "ActivityId")
	private ActivityDTO activity;

	@ManyToMany(targetEntity = UserDTO.class, cascade = CascadeType.ALL)
	@JoinTable(name = "user_bugs", joinColumns = @JoinColumn(name = "Bug_Id", referencedColumnName = "BugId"), inverseJoinColumns = @JoinColumn(name = "UserId", referencedColumnName = "userId"))
	private Set users;

	@ManyToMany(targetEntity = MilestonDTO.class, cascade = CascadeType.ALL)
	@JoinTable(name = "milestone_bugs", joinColumns = @JoinColumn(name = "Bug_Id", referencedColumnName = "BugId"), inverseJoinColumns = @JoinColumn(name = "Milestone_Id", referencedColumnName = "MilestoneId"))
	private Set milestone;
}

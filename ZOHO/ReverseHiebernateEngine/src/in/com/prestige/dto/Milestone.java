package in.com.prestige.dto;
// Generated May 30, 2018 4:58:22 PM by Hibernate Tools 4.0.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Milestone generated by hbm2java
 */
@Entity
@Table(name = "milestone", catalog = "zohotest2")
public class Milestone implements java.io.Serializable {

	private int milestoneId;
	private Activity activity;
	private Project project;
	private Date endDate;
	private String mileStoneName;
	private Date startDate;
	private Set<User> users = new HashSet<User>(0);

	public Milestone() {
	}

	public Milestone(int milestoneId) {
		this.milestoneId = milestoneId;
	}

	public Milestone(int milestoneId, Activity activity, Project project, Date endDate, String mileStoneName,
			Date startDate, Set<User> users) {
		this.milestoneId = milestoneId;
		this.activity = activity;
		this.project = project;
		this.endDate = endDate;
		this.mileStoneName = mileStoneName;
		this.startDate = startDate;
		this.users = users;
	}

	@Id

	@Column(name = "MilestoneId", unique = true, nullable = false)
	public int getMilestoneId() {
		return this.milestoneId;
	}

	public void setMilestoneId(int milestoneId) {
		this.milestoneId = milestoneId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ActivityId")
	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "projectId")
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EndDate", length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "MileStoneName")
	public String getMileStoneName() {
		return this.mileStoneName;
	}

	public void setMileStoneName(String mileStoneName) {
		this.mileStoneName = mileStoneName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "StartDate", length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "milestone")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
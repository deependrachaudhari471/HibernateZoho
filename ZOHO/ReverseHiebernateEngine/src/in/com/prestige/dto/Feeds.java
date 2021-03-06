package in.com.prestige.dto;
// Generated May 30, 2018 4:58:22 PM by Hibernate Tools 4.0.1.Final

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

/**
 * Feeds generated by hbm2java
 */
@Entity
@Table(name = "feeds", catalog = "zohotest2")
public class Feeds implements java.io.Serializable {

	private int feedId;
	private ProjectManager projectManager;
	private User user;
	private String post;
	private Set<Activity> activities = new HashSet<Activity>(0);
	private Set<Status> statuses = new HashSet<Status>(0);

	public Feeds() {
	}

	public Feeds(int feedId) {
		this.feedId = feedId;
	}

	public Feeds(int feedId, ProjectManager projectManager, User user, String post, Set<Activity> activities,
			Set<Status> statuses) {
		this.feedId = feedId;
		this.projectManager = projectManager;
		this.user = user;
		this.post = post;
		this.activities = activities;
		this.statuses = statuses;
	}

	@Id

	@Column(name = "feedId", unique = true, nullable = false)
	public int getFeedId() {
		return this.feedId;
	}

	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AdminId")
	public ProjectManager getProjectManager() {
		return this.projectManager;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "Post")
	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "feeds")
	public Set<Activity> getActivities() {
		return this.activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "feeds")
	public Set<Status> getStatuses() {
		return this.statuses;
	}

	public void setStatuses(Set<Status> statuses) {
		this.statuses = statuses;
	}

}

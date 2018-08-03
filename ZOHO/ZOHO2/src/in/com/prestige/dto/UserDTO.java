package in.com.prestige.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "User")
public class UserDTO {
	@Id
	@Column(name = "userId")
	private Integer userId;
	@Column(name = "UserName")
	private String userName;
	@Column(name = "Email")
	private String email;
	@Column(name = "Role")
	private String role;

	@ManyToMany(targetEntity = BugDTO.class, cascade = CascadeType.ALL)
	@JoinTable(name = "user_bugs", joinColumns = @JoinColumn(name = "UserId", referencedColumnName = "userId"), inverseJoinColumns = @JoinColumn(name = "Bug_Id", referencedColumnName = "BugId"))
	private Set bugs;

	@OneToOne(targetEntity = MilestonDTO.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "MilestoneId", referencedColumnName = "MilestoneId")
	private MilestonDTO milestone;

	@ManyToMany(targetEntity = ProjectGroupDTO.class, cascade = CascadeType.ALL)
	@JoinTable(name = "user_projectGroup", joinColumns = @JoinColumn(name = "UserId", referencedColumnName = "userId"), inverseJoinColumns = @JoinColumn(name = "project_group_id", referencedColumnName = "ProjectGroupId"))
	private Set projectGroup;

	@OneToMany(targetEntity = FeedDTO.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private Set feeds;

	@ManyToMany(targetEntity = ShareBugDTO.class, cascade = CascadeType.ALL)
	@JoinTable(name = "user_shareBug", joinColumns = @JoinColumn(name = "UserId", referencedColumnName = "userId"), inverseJoinColumns = @JoinColumn(name = "ShareBug_Id", referencedColumnName = "ShareBugId"))
	private Set shareBug;
	
	@ManyToMany(targetEntity = EventDTO.class, cascade = CascadeType.ALL)
	@JoinTable(name = "user_event", joinColumns = @JoinColumn(name = "UserId", referencedColumnName = "userId"), inverseJoinColumns = @JoinColumn(name = "EventId", referencedColumnName = "EventId"))
	private Set events;

}

package in.com.prestige.dto;

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

	@OneToMany(targetEntity = BugDTO.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private Set bugs;

	@OneToOne(targetEntity = MilestonDTO.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "MilestoneId", referencedColumnName = "MilestoneId")
	private MilestonDTO milestone;

	@OneToMany(targetEntity = ProjectGroupDTO.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private Set projectGroup;

	@OneToMany(targetEntity = FeedDTO.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private Set feeds;

	@OneToMany(targetEntity = ShareBugDTO.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private Set shareBug;

}

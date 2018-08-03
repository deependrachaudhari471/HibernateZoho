package in.com.prestige.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "projectgroup")
public class ProjectGroupDTO {

	@Id
	@Column(name = "ProjectGroupId")
	private Integer projectgroupId;
	@Column(name = "GroupName")
	private String groupName;

	@ManyToMany(targetEntity = UserDTO.class, cascade = CascadeType.ALL)
	@JoinTable(name = "user_projectGroup", joinColumns = @JoinColumn(name = "project_group_id", referencedColumnName = "ProjectGroupId"), inverseJoinColumns = @JoinColumn(name = "UserId", referencedColumnName = "userId"))
	private Set users;
}

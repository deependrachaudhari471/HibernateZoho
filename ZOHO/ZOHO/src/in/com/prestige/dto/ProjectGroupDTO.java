package in.com.prestige.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="projectgroup")
public class ProjectGroupDTO {
	
	   @Id
	   @Column(name="ProjectGroupId")
	   private Integer projectgroupId;
	   @Column(name="GroupName")
	   private String groupName;
	}



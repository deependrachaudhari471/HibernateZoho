package in.com.prestige.dto;

import java.sql.Timestamp;
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
@Table(name="project_manager")
public class ProjectMangagerDTO{
    @Id
    @Column(name="ProjectManagerId")
    private Integer projectManagerId;
    @Column(name="projectManagerName")
    private String projectManagerName;
    @Column(name="Contact")
    private String contactNo;
    @OneToOne(targetEntity=ProjectDTO.class,cascade=CascadeType.ALL)
    @JoinColumn(name="ProjectId",referencedColumnName="ProjectId")
    private ProjectDTO projects;
    
    @OneToMany(targetEntity=FeedDTO.class,cascade=CascadeType.ALL)
	@JoinColumn(name="AdminId",referencedColumnName="ProjectManagerId")
	private Set feeds;
    
    
    @ManyToMany(targetEntity = EventDTO.class, cascade = CascadeType.ALL)
	@JoinTable(name = "project_manager_event", joinColumns = @JoinColumn(name = "ProjectManagerId", referencedColumnName = "ProjectManagerId"), inverseJoinColumns = @JoinColumn(name = "EventId", referencedColumnName = "EventId"))
	private Set events;
}

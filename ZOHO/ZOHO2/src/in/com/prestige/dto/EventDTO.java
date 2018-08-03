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
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Event")
public class EventDTO {
	@Id
	@Column(name = "EventId")
	private Integer eventId;
	@Column(name = "Event_Title")
	private String event_title;
	@Column(name = "ScheduledDate")
	private Date scheduleDate;
	@Column(name = "Location")
	private String location;
	@Column(name="Duartions")
	private String durations;

	@ManyToMany(targetEntity = UserDTO.class, cascade = CascadeType.ALL)
	@JoinTable(name = "user_event", joinColumns = @JoinColumn(name = "EventId", referencedColumnName = "EventId"), inverseJoinColumns = @JoinColumn(name = "UserId", referencedColumnName = "userId"))
	private Set users;

	@ManyToMany(targetEntity = ProjectMangagerDTO.class, cascade = CascadeType.ALL)
	@JoinTable(name = "project_manager_event", joinColumns = @JoinColumn(name = "EventId", referencedColumnName = "EventId"), inverseJoinColumns = @JoinColumn(name = "ProjectManagerId", referencedColumnName = "ProjectManagerId"))
	private Set projectManager;
}

package in.com.prestige.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Activity")
public class ActivityDTO {
	@Id
	@Column(name = "ActivityId")
	private Integer activityId;
	@Column(name = "AddeTime")
	private Timestamp time;
	@Column(name="ActivityName")
	private String activityName;
}

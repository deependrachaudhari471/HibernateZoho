package in.com.prestige.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Bug")
public class BugDTO {
	@Id
	@Column(name="BugId")
	private Integer bugId;
	@Column(name="BugTitle")
	private String bugTitle;
	@Column(name="Descrption")
	private String description;
	@Column(name="DueDate")
	private Date dueDate;
	@Column(name="Open")
	private Integer open;
	@Column(name="Closed")
	private Integer closed;
	
	@OneToOne(targetEntity=ActivityDTO.class,cascade=CascadeType.ALL)
	@JoinColumn(name="ActivityId",referencedColumnName="ActivityId")
	private ActivityDTO activity;

}

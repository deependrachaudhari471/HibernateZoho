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
@Table(name = "Status")
public class StatusDTO {
	@Id
	@Column(name = "StatsuId")
	private Integer statusId;
	@Column(name="StatusCompletedPercent")
	private String statusCompletedPercent;
}

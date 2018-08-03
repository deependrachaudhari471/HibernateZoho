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
@Table(name = "Feeds")
public class FeedDTO {
	@Id
	@Column(name = "feedId")
	private Integer feedId;
    @Column(name="Post")
	private String post;
}

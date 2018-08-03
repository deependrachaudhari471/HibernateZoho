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
@Table(name = "Documents")
public class DocumentDTO {
	@Id
	@Column(name="DocID")
    private Integer docId;
	@Column(name="DcoName")
	private String docName;
}

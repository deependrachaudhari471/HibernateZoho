package in.com.prestige.dto;

import java.sql.Timestamp;
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

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="sharebug")
public class ShareBugDTO {
   @Id
   @Column(name="ShareBugId")
   private Integer shareBugId;
   @Column(name="Date")
   private Date date;
   
  
}

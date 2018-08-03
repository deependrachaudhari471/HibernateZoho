package in.com.prestige.dto;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
    
    @OneToMany(targetEntity=ActivityDTO.class,cascade=CascadeType.ALL)
    @JoinColumn(name="Feed_id",referencedColumnName="feedId")
    private Set activity;
    
    
    @OneToMany(targetEntity=StatusDTO.class,cascade=CascadeType.ALL)
    @JoinColumn(name="Feed_id",referencedColumnName="feedId")
    private Set status;
    
}

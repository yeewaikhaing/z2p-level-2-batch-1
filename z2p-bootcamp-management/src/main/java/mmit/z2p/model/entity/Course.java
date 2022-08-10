package mmit.z2p.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Course
 *
 */
@Entity
@Table(name = "courses")
public class Course implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String content;
	@ManyToOne
	@JoinColumn(name = "level_id")
	private Level level;
	private static final long serialVersionUID = 1L;

	public Course() {
		super();
	}
   
}

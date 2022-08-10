package mmit.z2p.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Level
 *
 */
@Entity
@Table(name = "levels")
public class Level implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int duration;
	private int fees;
	private static final long serialVersionUID = 1L;

	public Level() {
		super();
	}
   
}

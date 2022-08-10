package mmit.z2p.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Batch
 *
 */
@Entity
@Table(name = "batches")
public class Batch implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private LocalDate startDate;
	@ManyToOne
	@JoinColumn(name = "level_id")
	private Level level;
	private static final long serialVersionUID = 1L;

	public Batch() {
		super();
	}
   
}

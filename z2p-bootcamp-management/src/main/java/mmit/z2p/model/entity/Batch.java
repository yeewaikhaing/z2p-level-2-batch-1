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
@NamedQuery(name = "getAllBatch", query = "SELECT b FROM Batch b ORDER BY b.level.id")
@NamedQuery(name = "getBatchByLevelId", query = "SELECT b FROM Batch b WHERE b.level.id = :levelId")
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
   
}

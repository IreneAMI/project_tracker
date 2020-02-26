import javax.persistence.*;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId")
    Integer projectId;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "shortName", nullable = false)
    String shortname;
    @Column(name = "description")
    String description;

    @ManyToOne
    @JoinColumn(name = "statusId")
    Status statusOfProject;
    @OneToMany(mappedBy = "projectIdForThisComment")
    List<Comment> comment;

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", name='" + name + '\'' +
                ", humanId=" + shortname +
                ", description='" + description + '\'' +
                ", statusId=" + statusOfProject +
                '}';
    }
}

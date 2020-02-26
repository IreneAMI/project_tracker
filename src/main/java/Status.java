import javax.persistence.*;
import java.util.List;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer statusId;
    @Column(name = "statusName")
    String name;

    @OneToMany(mappedBy = "statusOfProject")
    List<Project> projects;
    @OneToMany(mappedBy = "statusOfItem")
    List<Item> items;

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", name='" + name + '\'' +
                '}';
    }
}

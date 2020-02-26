import javax.persistence.*;
import java.util.List;

@Entity
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer typeId;
    @Column(name = "name")
    String nume;

    @OneToMany(mappedBy = "typeOfItem")
    List<Item> items;
    
    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", nume='" + nume + '\'' +
                '}';
    }
}




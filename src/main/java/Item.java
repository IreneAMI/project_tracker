import javax.persistence.*;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer itemId;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;


    @ManyToOne
    @JoinColumn(name = "statusId")
    Status statusOfItem;
    @ManyToOne
    @JoinColumn(name = "typeId")
    Type typeOfItem;
    @OneToMany(mappedBy = "itemIdForThisComment")
    List<Comment> comment;

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", statusId=" + statusOfItem +
                ", typeId=" + typeOfItem +
                '}';
    }
}



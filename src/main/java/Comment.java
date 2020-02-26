import javax.persistence.*;
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "itemId")
    Item itemIdForThisComment;
    @ManyToOne
    @JoinColumn(name = "projectId")
    Project projectIdForThisComment;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + itemIdForThisComment +
                ", name='" + name + '\'' +
                '}';
    }
}

package ir.maktab.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @OneToMany(mappedBy = "comment")
    List<Comment> comments = new ArrayList<>();
    int like;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    Date publish;
    @ManyToOne
    Account account;
}

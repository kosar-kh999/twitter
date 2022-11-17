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
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    Date openingDate;
    @ManyToOne
    User user;
    @OneToMany(mappedBy = "tweet")
    List<Tweet> tweets = new ArrayList<>();
    @OneToMany(mappedBy = "comment")
    List<Comment> comments = new ArrayList<>();
}

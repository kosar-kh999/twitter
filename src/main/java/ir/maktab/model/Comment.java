package ir.maktab.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    Date publishDate;
    @Column(length = 280)
    String text;
    @ManyToOne
    Account account;
    @ManyToOne
    Tweet tweet;
}

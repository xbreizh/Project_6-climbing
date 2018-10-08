package org.example.demo.climb.model.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Comment {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id", updatable = false, nullable = false)
private int id;

@NotNull
@Size(min = 1, max = 100)
private String text;

@NotNull
private Date date;

@NotNull
@ManyToOne
private Member memberComment;


@ManyToOne
private Route route;


@ManyToOne
private Spot spot;

public Comment() {
}


}

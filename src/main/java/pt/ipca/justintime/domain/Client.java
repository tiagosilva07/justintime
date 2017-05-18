package pt.ipca.justintime.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CLIENT")
@PrimaryKeyJoinColumn(name="PERSON_ID")
public class Client extends Person {

    @OneToMany
    private List<Project> projectList = new ArrayList<>();
}

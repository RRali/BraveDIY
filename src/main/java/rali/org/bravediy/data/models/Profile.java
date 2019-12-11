package rali.org.bravediy.data.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rali.org.bravediy.data.models.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "profiles")
public class Profile extends BaseEntity {
    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

    @Column
    private String city;

    @OneToMany(mappedBy = "profile")
    private List<Art> arts;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}


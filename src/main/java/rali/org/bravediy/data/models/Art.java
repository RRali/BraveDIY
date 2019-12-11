package rali.org.bravediy.data.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rali.org.bravediy.data.models.base.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "arts")
public class Art extends BaseEntity {
    @Column
    private String name;

    @Column
    private String photo;

    @Column
    private double price;

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id", nullable = false)
    private Profile profile;
}

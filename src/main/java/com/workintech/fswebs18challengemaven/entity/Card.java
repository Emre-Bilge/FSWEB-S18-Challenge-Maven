package com.workintech.fswebs18challengemaven.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="card",schema="public")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private Integer value;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private Color color;

 /*   @PrePersist
    @PreUpdate
    public void validateFirstly() {
        if (type == Type.JOKER) {
            this.value= null ;
            this.color = null ;
        }
        else if(type != null && value != null){
            throw new IllegalArgumentException("card type ve null değerlerini alamaz");
        }else if (type != null) {
            this.value=null ;
        }else if(value != null){
            this.type = null ;
        }
    }*/
}

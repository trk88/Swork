package main.by.trk.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "credit_card")
public class CreditCard implements Serializable {

    private static final long serialVersionUID = 8282L;

    public CreditCard() {
    }

    private Integer id;
    private String type;
    private String number;
    private Person person;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

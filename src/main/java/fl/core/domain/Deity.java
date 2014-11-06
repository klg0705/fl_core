package fl.core.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fl.base.domain.BaseDomain;
import fl.user.domain.Person;

@Entity
@Table
public class Deity extends BaseDomain {

    private String name;

    private String image;

    @OneToMany(mappedBy = "deity")
    private List<Fighter> fighters;

    @OneToOne(optional = false)
    @JoinColumn(name = "personId")
    private Person person;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Fighter> getFighters() {
        return fighters;
    }

    public void setFighters(List<Fighter> fighters) {
        this.fighters = fighters;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}

package homework5.vet;

import homework5.animal.Animal;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Vets")
@MappedSuperclass
public class Vet {
    @Id
    @GeneratedValue
    long id;
    String name;
    String phone;
    String clinic;
    List<Animal> animals = new ArrayList<>();

    public Vet() {
    }

    public Vet(String name, String phone, String clinic) {
        this.name = name;
        this.phone = phone;
        this.clinic = clinic;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Vet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", clinic='" + clinic + '\'' +
                '}';
    }
}



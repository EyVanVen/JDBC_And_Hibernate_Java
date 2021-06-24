package homework5.aviary;

import homework5.animal.Animal;
import homework5.vet.Vet;

import javax.persistence.*;
import java.util.List;


@Entity
@MappedSuperclass
public class Aviary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String biome;
    double size;
    @OneToMany
    List<Animal> animals;

    public Aviary (){}

    public Aviary(String biome, double size, List<Animal> animals) {
        this.biome = biome;
        this.size = size;
        this.animals = animals;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBiome() {
        return biome;
    }

    public void setBiome(String biome) {
        this.biome = biome;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Aviary{" +
                "id=" + id +
                ", biome='" + biome + '\'' +
                ", size=" + size +
                ", animals=" + animals +
                '}';
    }
}



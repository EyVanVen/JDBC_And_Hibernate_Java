package homework5.aviary;

import java.util.List;

public interface Aviary_Dao{
    void add(Aviary  aviary);
    List<Aviary> getAll();
    Aviary  getById(long id);
    void updateById(long id, Aviary  aviary);
    void removeById(long id);
}

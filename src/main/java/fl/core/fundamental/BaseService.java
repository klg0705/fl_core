package fl.core.fundamental;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {

    public T get(Serializable id);

    public void update(T t);

    public void add(T t);

    public void delete(T t);

    public List<T> getAll();

    public void deleteById(Serializable id);

    public void deleteAll();

    public long count();
    
    public BaseDAO<T> getBaseDAO();
}

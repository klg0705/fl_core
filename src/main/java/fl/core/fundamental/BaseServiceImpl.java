package fl.core.fundamental;

import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Override
    public T get(Serializable id) {
        return getBaseDAO().get(id);
    }

    @Override
    public void update(T t) {
        getBaseDAO().update(t);
    }

    @Override
    public void add(T t) {
        getBaseDAO().save(t);
    }

    @Override
    public void delete(T t) {
        getBaseDAO().delete(t);
    }

    @Override
    public List<T> getAll() {
        return getBaseDAO().getAll();
    }

    @Override
    public void deleteById(Serializable id) {
        getBaseDAO().deleteById(id);
    }

    @Override
    public void deleteAll() {
        getBaseDAO().deleteAll();
    }

    @Override
    public long count() {
        return getBaseDAO().count();
    }

}

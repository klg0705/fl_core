package fl.core.fundamental;

import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    private BaseDAO<T> baseDAO;

    public BaseDAO<T> getBaseDAO() {
        return baseDAO;
    }

    public void setBaseDAO(BaseDAO<T> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    public T get(Serializable id) {
        return baseDAO.get(id);
    }

    @Override
    public void update(T t) {
        baseDAO.update(t);
    }

    @Override
    public void add(T t) {
        baseDAO.save(t);
    }

    @Override
    public void delete(T t) {
        baseDAO.delete(t);
    }

    @Override
    public List<T> getAll() {
        return baseDAO.getAll();
    }

    @Override
    public void deleteById(Serializable id) {
        baseDAO.deleteById(id);
    }

    @Override
    public void deleteAll() {
        baseDAO.deleteAll();
    }

    @Override
    public long count() {
        return baseDAO.count();
    }

}

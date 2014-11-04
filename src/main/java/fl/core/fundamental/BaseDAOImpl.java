package fl.core.fundamental;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

public abstract class BaseDAOImpl<T> implements BaseDAO<T> {

    protected SessionFactory sessionFactory;

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public T get(Serializable id) {
        return (T) sessionFactory.getCurrentSession().get(getDomainClass(), id);
    }

    public void update(T t) {
        sessionFactory.getCurrentSession().update(t);
    }

    public void save(T t) {
        sessionFactory.getCurrentSession().persist(t);
    }

    public void delete(T t) {
        sessionFactory.getCurrentSession().delete(t);
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from " + getDomainClass().getName() + " x").list();
    }

    public void deleteById(Serializable id) {
        delete(get(id));
    }

    public void deleteAll() {
        sessionFactory.getCurrentSession().createQuery("delete from " + getDomainClass().getName() + " x")
                .executeUpdate();
    }

    public long count() {
        Number n = (Number) sessionFactory.getCurrentSession()
                .createQuery("select count(*) from " + getDomainClass().getName() + " x").uniqueResult();
        return n.longValue();
    }

}
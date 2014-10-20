package fl.core.fundamental;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class BaseDAOImpl<T> implements BaseDAO<T> {

    @SuppressWarnings("unchecked")
    public T get(Serializable id) {
        Session session = null;
        T result = null;
        try {
            session = HibernateUtil.getSession();
            result = (T) session.get(getDomainClass(), id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    public void update(T t) {
        Session session = null;
        Transaction ts = null;
        try {
            session = HibernateUtil.getSession();
            ts = session.beginTransaction();
            session.update(t);
            ts.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (ts != null) {
                ts.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void save(T t) {
        Session session = null;
        Transaction ts = null;
        try {
            session = HibernateUtil.getSession();
            ts = session.beginTransaction();
            session.save(t);
            ts.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (ts != null) {
                ts.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(T t) {
        Session session = null;
        Transaction ts = null;
        try {
            session = HibernateUtil.getSession();
            ts = session.beginTransaction();
            session.delete(t);
            ts.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (ts != null) {
                ts.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        Session session = null;
        List<T> result = null;
        try {
            session = HibernateUtil.getSession();
            result = session.createQuery("from " + getDomainClass().getName() + " x").list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    public void deleteById(Serializable id) {
        T item = get(id);
        delete(item);
    }

    public void deleteAll() {
        Session session = null;
        Transaction ts = null;
        try {
            session = HibernateUtil.getSession();
            ts = session.beginTransaction();
            session.createQuery("delete from " + getDomainClass().getName() + " x").executeUpdate();
            ts.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (ts != null) {
                ts.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public long count() {
        Session session = null;
        long count = 0;
        try {
            session = HibernateUtil.getSession();
            count = (long) session.createQuery("select count(*) from " + getDomainClass().getName() + " x")
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return count;
    }

}
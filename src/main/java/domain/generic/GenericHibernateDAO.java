package domain.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;


public abstract class GenericHibernateDAO<T, ID extends Serializable>
implements GenericDAO<T, ID> {

	private Class<T> persistentClass;
	private Session session;

	@SuppressWarnings("unchecked")
	public GenericHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}


	public void setSession(Session s) {
		this.session = s;
	}


	protected Session getSession() {
		if (session == null)
			session = HibernateUtil.getSessionFactory().getCurrentSession();
		return session;
	}



	public Class<T> getPersistentClass() {
		return persistentClass;
	}


	@SuppressWarnings({ "unchecked", "deprecation" })
	public T findById(ID id, boolean lock) {
		//                System.out.println("ID = "  + id);
		T entity;
		if (lock)
			entity = (T) getSession().get(getPersistentClass(), id, LockMode.UPGRADE);
		else
			entity = (T) getSession().get(getPersistentClass(), id);

		return entity;
	}


	public List<T> findAll() {
		return findByCriteria();
	}


	@SuppressWarnings("unchecked")
	public List<T> findByExample(T exampleInstance, String... excludeProperty) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		Example example =  Example.create(exampleInstance);
		for (String exclude : excludeProperty) {
			example.excludeProperty(exclude);
		}
		crit.add(example);
		List<T> results = crit.list();

		return results;
	}


	public T makePersistent(T entity) {
		getSession().saveOrUpdate(entity);

		return entity;
	}


	public void makeTransient(T entity) {
		getSession().delete(entity);
	}

	public void deleteBy(ID id) {
		makeTransient(findById(id,false));
	}


	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}


	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		List<T> results = crit.list();

		return results;
	}


	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(List<Criterion> criterion) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}

		List<T> results = crit.list();

		return results;
	}
	@SuppressWarnings("unchecked")
	protected T findUniqueResult(List<Criterion> criterion) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		T results = (T)crit.uniqueResult();


		return results;
	}

}
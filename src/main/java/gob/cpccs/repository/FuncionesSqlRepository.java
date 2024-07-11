/**
 * 
 */
package gob.cpccs.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 * Controlador FuncionesSqlRepository
 *
 * Este archivo contiene métodos para el Repositoy FuncionesSqlRepository
 *
 * @property CPCCS
 * @date 01/12/2018, 11:16:19
 * @uses FuncionesSqlRepository
 * @package gob.cpccs.repository
 * @subpackage
 * 
 */

public abstract class FuncionesSqlRepository<T> {

     private Class<T> entityClass;

     public FuncionesSqlRepository(Class<T> entityClass) {
          this.entityClass = entityClass;
     }

     @PersistenceUnit
     private EntityManagerFactory emf;
     private EntityManager em;
     private EntityTransaction transaccion;

     public void cerrarEntityManager() {
          if (em != null){
               em.close();
          }
     }

     public void crearEntityManager() {
          em = emf.createEntityManager();
     }

     public void crearEntityTransaction() {
          transaccion = em.getTransaction();
     }

     @Transactional
     public void guardar(T entity) {
          crearEntityManager();
          crearEntityTransaction();
          try{
               transaccion.begin();
               em.flush();
               em.persist(entity);
               transaccion.commit();
          } catch (Exception ex){
               if (transaccion.isActive()){
                    transaccion.rollback();
               }
               throw ex;
          } finally{
               cerrarEntityManager();
          }
     }

     @Transactional
     public void editar(T entity) {
          crearEntityManager();
          crearEntityTransaction();
          try{
               transaccion.begin();
               em.merge(entity);
               transaccion.commit();
          } catch (Exception ex){
               if (transaccion.isActive()){
                    transaccion.rollback();
               }
               throw ex;
          } finally{
               cerrarEntityManager();
          }
     }

     @Transactional
     public void eliminar(T entity) {
          crearEntityManager();
          crearEntityTransaction();
          try{
               transaccion.begin();
               em.remove(em.merge(entity));
               transaccion.commit();
          } catch (Exception ex){
               if (transaccion.isActive()){
                    transaccion.rollback();
               }
               throw ex;
          } finally{
               cerrarEntityManager();
          }
     }

     public T find(Object id) {
          crearEntityManager();
          return em.find(entityClass, id);
     }

     public TypedQuery<T> namedSqlQuery(String namedQuery) {
          crearEntityManager();
          TypedQuery<T> query = em.createNamedQuery(namedQuery, entityClass);
          return query;
     }

     public Query SqlQueryNativo(String sql, Class<T> entityClass) {
          crearEntityManager();
          Query query = em.createNativeQuery(sql, entityClass);
          return query;
     }

     public Query SqlQueryNativo(String sql) {
          crearEntityManager();
          Query query = em.createNativeQuery(sql);
          return query;
     }

     public Query SqlCreateQuery(String sql) {
          crearEntityManager();
          Query query = em.createQuery(sql);
          return query;
     }
}


package com.ideiah.gerenciadorpampatec.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pedro
 */
public abstract class Dao {
    
    public static final int SALVOU = 0;
    public static final int ERRO_SALVAR = 1;
    public static final int ARQUIVO_GRANDE = 2;
    
    private Transaction tx = null;
    private Session session = null;

    public  Dao(){
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    // <editor-fold defaultstate="collapsed" desc="INSERT and UPDATE"> 
    /**
     * Salva um objeto mapeado no banco de dados
     *
     * @param obj
     * @return boolean se salvou ou não
     */
    public boolean salvar(Object obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        boolean salvou = false;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(obj);
            salvou = true;
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            salvou = false;
        }
        return salvou;
    }
    
    /**
     * Salva um objeto que contêm um arquivo nele
     * @param obj
     * @return Resultado
     */
    protected int salvarComArquivo(Object obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        int result = SALVOU;
        try {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(obj);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            result = ERRO_SALVAR;
        } catch (OutOfMemoryError error){
            error.printStackTrace();
            session.getTransaction().rollback();
            result = ARQUIVO_GRANDE;
        }
        return result;
    }
        // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="DELETE"> 
    public boolean excluir(int codigo, Class type) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Object object = session.get(type, codigo);
            session.delete(object);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        return true;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SEARCH OBJECT"> 
    public Object buscarObjeto(int codigo, Class<?> classe) {
        Object objeto = null;
        Criteria criteria = getCriteria(classe);
        criteria.add(Restrictions.idEq(codigo));
        return getObject(criteria);
    }

    public Object buscarObjeto(String codigo, Class<?> classe) {
        Criteria criteria = getCriteria(classe);
        criteria.add(Restrictions.idEq(codigo));
        return getObject(criteria);
    }

    public Object buscarObjeto(HashMap<String, Object> filtros, Class<?> classe) {
        Criteria criteria = getCriteria(classe);
        for (Map.Entry<String, Object> entry : filtros.entrySet()) {
            String campo = entry.getKey();
            Object valor = entry.getValue();
            criteria.add(Restrictions.eq(campo, valor));
        }
        criteria.setMaxResults(1);//no maximo 1 resultado
        return getObject(criteria);
    }
        // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="SEARCH OBJECTS"> 
    public Object buscarObjetos(HashMap<String, Object> filtros, Class<?> classe) {
        Object objeto = null;
        Criteria criteria = getCriteria(classe);
        for (Map.Entry<String, Object> entry : filtros.entrySet()) {
            String campo = entry.getKey();
            Object valor = entry.getValue();
            criteria.add(Restrictions.eq(campo, valor));
        }
        return getObjects(criteria);
    }

    public ArrayList<?> buscarObjetos(Class<?> classe) {
        Criteria criteria = getCriteria(classe);
        return getObjects(criteria);
    }
        // </editor-fold>

    private Object getObject(Criteria criteria) {
        Object object = criteria.uniqueResult();
        tx.commit();
        return object;
    }

    private ArrayList<?> getObjects(Criteria criteria) {
        List list = criteria.list();
        ArrayList<?> lista = (ArrayList<?>) list;
        tx.commit();
        return lista;
    }

    private Criteria getCriteria(Class<?> classe) {
        Criteria criteria = null;
        try {
            tx = session.beginTransaction();//cria uma transação para o hibernate conectar no banco
            criteria = session.createCriteria(classe);
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return criteria;
    }
}


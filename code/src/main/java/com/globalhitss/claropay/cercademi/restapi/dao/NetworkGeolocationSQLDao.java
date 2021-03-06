package com.globalhitss.claropay.cercademi.restapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.globalhitss.claropay.cercademi.restapi.model.NetworkGeolocation;


@Repository
@Qualifier("NetworkGeolocationSQLDao")
public class NetworkGeolocationSQLDao implements NetworkGeolocationDao
{ 
  @Autowired
  private EntityManager entityManager;

  private Session getSession() {
      return entityManager.unwrap(Session.class);
  }

  public List<NetworkGeolocation> getLocationByIP(long ip)
  {
    String querySelect = "from NetworkGeolocation as t "
        + "where t.ipFrom<=(:ip) and t.ipTo>=(:ip) "
        + "order by datasource ASC, noNodes ";
    
    Query<NetworkGeolocation> query = getSession().createQuery(querySelect,NetworkGeolocation.class);
    query.setParameter("ip", ip);
    
    return query.getResultList();
  }
}

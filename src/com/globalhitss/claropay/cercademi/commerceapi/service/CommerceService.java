package com.globalhitss.claropay.cercademi.commerceapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globalhitss.claropay.cercademi.commerceapi.dao.CommerceDao;
import com.globalhitss.claropay.cercademi.commerceapi.dao.CommerceSQLDao;
import com.globalhitss.claropay.cercedemi.commerceapi.model.CommerceModel;

@Service
public class CommerceService {

  @Autowired
  private CommerceSQLDao commerceSQLDao;
  
  @Transactional(readOnly = true)
  public CommerceModel commerceById(int id)
  {
    return commerceSQLDao.selectById(id);
  }
  
  @Transactional(readOnly = true)
  public List<CommerceModel> commerceByLatAndLng(double lat, double lng)
  {
    return commerceSQLDao.selectByLatAndLng(lat, lng); 
  }
  
  @Transactional(readOnly = true)
  public List<CommerceModel> commerceByClassName(String className)
  {
    return commerceSQLDao.selectByClass(className); 
  }
  
  @Transactional(readOnly = true)
  public List<CommerceModel> commerceBySpecies(String speciesToken)
  {
    return commerceSQLDao.selectBySpecies(speciesToken);
  }
}

package com.globalhitss.claropay.cercademi.commerceapi.service;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globalhitss.claropay.cercademi.commerceapi.dao.IPCitiesSQLDao;
import com.globalhitss.claropay.cercedemi.commerceapi.model.IPCities;

import static com.globalhitss.claropay.cercademi.commerceapi.util.IPTools.getIPFromHTTPRequest;
import static com.globalhitss.claropay.cercademi.commerceapi.util.IPTools.ip2num;


@Service
public class LocationService 
{
 
  @Autowired
  private IPCitiesSQLDao ipCitiesDao;
  
  public List<IPCities> getLocationByIP(HttpServletRequest rq)
  {
    return getLocationByIP(getIPFromHTTPRequest(rq));
  }
  
  @Transactional(readOnly = true)
  public List<IPCities> getLocationByIP(String ip)
  {
    return ipCitiesDao.getLocationByIP(ip2num(ip));
  }
}
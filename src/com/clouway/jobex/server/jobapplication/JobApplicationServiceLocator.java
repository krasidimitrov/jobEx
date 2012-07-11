package com.clouway.jobex.server.jobapplication;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class JobApplicationServiceLocator implements ServiceLocator {
  @Override
  public Object getInstance(Class<?> clazz) {
    return new JobApplicationServiceImpl();
  }
}

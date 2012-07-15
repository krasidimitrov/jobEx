package com.clouway.jobex.shared;

import com.clouway.jobex.server.applyingforjob.JobApplicationLocator;
<<<<<<< HEAD
import com.clouway.jobex.server.applyingforjob.JobApplication;
=======
>>>>>>> commit
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

/**
 * Client side representation of JobApplication Entity
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
@ProxyFor(value = JobApplication.class,locator = JobApplicationLocator.class)
public interface JobApplicationProxy extends EntityProxy {


  public Long getCvId();

  public Long getJobId();

  public void setCvId(Long cvId);

  public void setJobId(Long jobId);

}

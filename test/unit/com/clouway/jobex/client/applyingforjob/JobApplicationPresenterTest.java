package com.clouway.jobex.client.applyingforjob;

<<<<<<< HEAD
import com.clouway.jobex.server.cv.CV;
=======
import com.clouway.jobex.shared.CVProxy;
>>>>>>> commit
import com.clouway.jobex.shared.JobExRequestFactory;
import com.clouway.jobex.client.security.UsernameProvider;
import com.clouway.jobex.server.applyingforjob.JobApplicationService;
import com.clouway.jobex.server.cv.CvsService;
<<<<<<< HEAD
import com.clouway.jobex.server.applyingforjob.JobApplication;
import com.clouway.jobex.shared.CVProxy;
=======
import com.clouway.jobex.server.entities.CV;
import com.clouway.jobex.server.entities.JobApplication;
>>>>>>> commit
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author Adelin Ghanayem adelin.ghanaem@clouway.com
 */
public class JobApplicationPresenterTest {


  private JobExRequestFactory factory;

  private JobApplicationService jobApplicationService;

  private CvsService cvsService;

  private JobApplicationPresenter presenter;

  private JobExRequestFactory.JobApplicationRequestContext context;

  private String username = "user";

  @Mock
  JobApplicationView view;

  @Mock
  UsernameProvider provider;

  @Captor
  ArgumentCaptor<ArrayList<CVProxy>> returnedCVArgumentCaptures;

  @Before
  public void setUp() throws Exception {

    initMocks(this);

    factory = RequestFactoryHelper.create(JobExRequestFactory.class);

    jobApplicationService = RequestFactoryHelper.getService(JobApplicationService.class);

    cvsService = RequestFactoryHelper.getService(CvsService.class);

    context = factory.jobApplicationContext();

    presenter = new JobApplicationPresenter(factory, view, provider);


  }


  @Test
  public void  applyForJobWithSelectedCV() {

    presenter.applyForJob(1l, 2l);

    ArgumentCaptor<JobApplication> jobApplicationArgumentCaptor = ArgumentCaptor.forClass(JobApplication.class);

    verify(jobApplicationService).applyForJob(jobApplicationArgumentCaptor.capture());

    JobApplication jobApplication = jobApplicationArgumentCaptor.getValue();

    assertThat(jobApplication.getCvId(), is(equalTo(2l)));

    assertThat(jobApplication.getJobId(), is(equalTo(1l)));

    verify(view).notifyUserOfSuccessfulAppliance();

  }


  @Test
  public void notifiesUserOfSystemError() {


    doThrow(new RuntimeException()).when(jobApplicationService).applyForJob(isA(JobApplication.class));

    presenter.applyForJob(1l, 2l);

    ArgumentCaptor<JobApplication> jobApplicationArgumentCaptor = ArgumentCaptor.forClass(JobApplication.class);

    verify(jobApplicationService).applyForJob(jobApplicationArgumentCaptor.capture());

    JobApplication jobApplication = jobApplicationArgumentCaptor.getValue();

    assertThat(jobApplication.getCvId(), is(equalTo(2l)));

    assertThat(jobApplication.getJobId(), is(equalTo(1l)));

    verify(view, never()).notifyUserOfSuccessfulAppliance();

    verify(view).notifyUserOfCommunicationError();

  }


  @Test
  public void showsAllCreatedCVsOnApplyForJob() {

    Long jobId = 1l;

    ArrayList<CV> cvs = new ArrayList<CV>();

    cvs.add(new CV());

    when(cvsService.fetchCreatedCVs(username)).thenReturn(cvs);

    when(provider.getUsername()).thenReturn(username);

    presenter.onApplyForJob(new ApplyForJobEvent(jobId));

    verify(cvsService).fetchCreatedCVs(username);

    verify(view).showCreatedCVs(returnedCVArgumentCaptures.capture());

    assertThat(returnedCVArgumentCaptures.getValue(), is(notNullValue()));

    assertThat(returnedCVArgumentCaptures.getValue().size(), is(equalTo(1)));


  }


  @Test
  public void redirectsUserToCreatingNewCVFormIfReturnedCVListIsEmpty() {

    Long jobId = 1l;

    ArrayList<CV> cvs = new ArrayList<CV>();

    when(cvsService.fetchCreatedCVs(username)).thenReturn(cvs);

    when(provider.getUsername()).thenReturn(username);

    presenter.onApplyForJob(new ApplyForJobEvent(jobId));

    verify(cvsService).fetchCreatedCVs(username);

    verify(view).goToCreateNewCVForm();
  }


}

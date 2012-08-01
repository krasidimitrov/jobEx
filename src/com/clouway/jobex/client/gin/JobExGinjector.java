package com.clouway.jobex.client.gin;

import com.clouway.jobex.client.cv.CreatingNewCVWorkflow;
import com.clouway.jobex.client.cv.EditCvWorkflow;
import com.clouway.jobex.client.cv.UserCVsPresenter;
import com.clouway.jobex.client.cv.UserCVsView;
import com.clouway.jobex.client.cvsreview.SubmittedCVsPresenterImpl;
import com.clouway.jobex.client.job.jobannounce.JobAnnouncePresenterImpl;
import com.clouway.jobex.client.job.jobsearch.JobSearchPresenter;
import com.clouway.jobex.client.jobsreview.ReviewJobsPresenterImpl;
import com.clouway.jobex.client.navigation.MenuItemMapper;
import com.clouway.jobex.client.security.CompanyRegisteredEventHandler;
import com.clouway.jobex.client.security.ConditionalActionDispatcher;
import com.clouway.jobex.client.security.UserAuthorizedEventHandler;
import com.clouway.jobex.client.security.UserCredentialsLocalStorage;
import com.clouway.jobex.client.security.UserIsAuthorizedCondition;
import com.clouway.jobex.client.security.UserPermittedActions;
import com.clouway.jobex.client.useraccess.login.LoginPresenter;
import com.clouway.jobex.client.useraccess.register.RegistrationPresenter;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
@GinModules(JobExGinModule.class)
public interface JobExGinjector extends Ginjector {


  PlaceController injectPlaceController();

  EventBus injectEventBus();

  ActivityMapper injectActivityMapper();

  UserCVsPresenter jobApplicationPresenter();

  UserCVsView jobApplicationView();

  JobSearchPresenter jobSearchPresenter();

  JobAnnouncePresenterImpl jobAnnouncePresenter();

  UserCVsPresenter userCVsPresenter();

  EditCvWorkflow editCvWorkflow();

  CreatingNewCVWorkflow creatingNewCVWorkflow();

  ReviewJobsPresenterImpl jobsReviewPresenter();

  RegistrationPresenter registrationPresenter();

  LoginPresenter loginPresenter();

  SubmittedCVsPresenterImpl submittedCvsPresenter();

  UserAuthorizedEventHandler userAuthorizedEventhandler();

  CompanyRegisteredEventHandler companyRegisteredEventHandler();

  UserIsAuthorizedCondition userIsAuthorizedCondition();

  ConditionalActionDispatcher dispatcher();

  UserCredentialsLocalStorage credentialsStorage();

  UserPermittedActions userPermittedAction();


  MenuItemMapper menuItemMapper();
}

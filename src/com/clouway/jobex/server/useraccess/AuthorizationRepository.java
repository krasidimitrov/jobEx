package com.clouway.jobex.server.useraccess;

/**
 * @author Krasimir Dimitrov (kpackapgo@gmail.com, krasimir.dimitrov@clouway.com)
 */
public interface AuthorizationRepository {

  boolean isNotRegister(String kind, String email);
  
  void register(String kind, String email, String password);

  boolean isAuthorized(String kind, String email, String password);

  void saveAsLogged(String email, String loginType, String id);

  boolean isUserAuthorized(String email, String id);

  boolean isSIDRegistered(String sid);

  void deleteLoggedData(String email);
}

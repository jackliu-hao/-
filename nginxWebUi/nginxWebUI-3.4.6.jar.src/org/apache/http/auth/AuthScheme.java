package org.apache.http.auth;

import org.apache.http.Header;
import org.apache.http.HttpRequest;

public interface AuthScheme {
  void processChallenge(Header paramHeader) throws MalformedChallengeException;
  
  String getSchemeName();
  
  String getParameter(String paramString);
  
  String getRealm();
  
  boolean isConnectionBased();
  
  boolean isComplete();
  
  @Deprecated
  Header authenticate(Credentials paramCredentials, HttpRequest paramHttpRequest) throws AuthenticationException;
}


/* Location:              G:\git\codeReviewLog\nginxWebUi\nginxWebUI-3.4.6.jar!\org\apache\http\auth\AuthScheme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
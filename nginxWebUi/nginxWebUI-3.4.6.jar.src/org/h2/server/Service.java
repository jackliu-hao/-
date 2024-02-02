package org.h2.server;

import java.sql.SQLException;

public interface Service {
  void init(String... paramVarArgs) throws Exception;
  
  String getURL();
  
  void start() throws SQLException;
  
  void listen();
  
  void stop();
  
  boolean isRunning(boolean paramBoolean);
  
  boolean getAllowOthers();
  
  String getName();
  
  String getType();
  
  int getPort();
  
  boolean isDaemon();
}


/* Location:              G:\git\codeReviewLog\nginxWebUi\nginxWebUI-3.4.6.jar!\org\h2\server\Service.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
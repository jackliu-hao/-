package org.apache.http.conn.params;

import org.apache.http.conn.routing.HttpRoute;

@Deprecated
public interface ConnPerRoute {
  int getMaxForRoute(HttpRoute paramHttpRoute);
}


/* Location:              G:\git\codeReviewLog\nginxWebUi\nginxWebUI-3.4.6.jar!\org\apache\http\conn\params\ConnPerRoute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
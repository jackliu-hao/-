package org.apache.http.conn;

import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;

public interface ConnectionKeepAliveStrategy {
  long getKeepAliveDuration(HttpResponse paramHttpResponse, HttpContext paramHttpContext);
}


/* Location:              G:\git\codeReviewLog\nginxWebUi\nginxWebUI-3.4.6.jar!\org\apache\http\conn\ConnectionKeepAliveStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
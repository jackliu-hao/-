package org.apache.http.io;

public interface HttpMessageWriterFactory<T extends org.apache.http.HttpMessage> {
  HttpMessageWriter<T> create(SessionOutputBuffer paramSessionOutputBuffer);
}


/* Location:              G:\git\codeReviewLog\nginxWebUi\nginxWebUI-3.4.6.jar!\org\apache\http\io\HttpMessageWriterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
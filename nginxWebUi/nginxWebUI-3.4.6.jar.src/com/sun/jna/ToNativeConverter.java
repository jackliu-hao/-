package com.sun.jna;

public interface ToNativeConverter {
  Object toNative(Object paramObject, ToNativeContext paramToNativeContext);
  
  Class<?> nativeType();
}


/* Location:              G:\git\codeReviewLog\nginxWebUi\nginxWebUI-3.4.6.jar!\com\sun\jna\ToNativeConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
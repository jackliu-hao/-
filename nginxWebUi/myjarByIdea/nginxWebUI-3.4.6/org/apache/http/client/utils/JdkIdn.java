package org.apache.http.client.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;

/** @deprecated */
@Deprecated
@Contract(
   threading = ThreadingBehavior.IMMUTABLE
)
public class JdkIdn implements Idn {
   private final Method toUnicode;

   public JdkIdn() throws ClassNotFoundException {
      Class<?> clazz = Class.forName("java.net.IDN");

      try {
         this.toUnicode = clazz.getMethod("toUnicode", String.class);
      } catch (SecurityException var3) {
         throw new IllegalStateException(var3.getMessage(), var3);
      } catch (NoSuchMethodException var4) {
         throw new IllegalStateException(var4.getMessage(), var4);
      }
   }

   public String toUnicode(String punycode) {
      try {
         return (String)this.toUnicode.invoke((Object)null, punycode);
      } catch (IllegalAccessException var4) {
         throw new IllegalStateException(var4.getMessage(), var4);
      } catch (InvocationTargetException var5) {
         Throwable t = var5.getCause();
         throw new RuntimeException(t.getMessage(), t);
      }
   }
}

package org.noear.solon.socketd;

import org.noear.solon.Solon;

public class SocketProps {
   private static int readBufferSize = 0;
   private static int writeBufferSize = 0;
   private static int connectTimeout = 0;
   private static int socketTimeout = 0;

   public static int readBufferSize() {
      return readBufferSize;
   }

   public static int writeBufferSize() {
      return writeBufferSize;
   }

   public static int connectTimeout() {
      return connectTimeout;
   }

   public static int socketTimeout() {
      return socketTimeout;
   }

   private static int loadBufferSize(String cfgKey) {
      String tmp = Solon.cfg().get(cfgKey, "").toLowerCase();
      if (tmp.length() > 2) {
         if (tmp.endsWith("kb")) {
            return Integer.parseInt(tmp.substring(0, tmp.length() - 2)) * 1024;
         }

         if (tmp.endsWith("mb")) {
            return Integer.parseInt(tmp.substring(0, tmp.length() - 2)) * 1024 * 1024;
         }

         if (tmp.indexOf("b") < 0) {
            return Integer.parseInt(tmp);
         }
      }

      return 0;
   }

   private static int loadTimeout(String cfgKey) {
      String tmp = Solon.cfg().get(cfgKey, "").toLowerCase();
      if (tmp.length() > 2) {
         if (tmp.endsWith("ms")) {
            return Integer.parseInt(tmp.substring(0, tmp.length() - 2));
         }

         if (tmp.endsWith("s")) {
            return Integer.parseInt(tmp.substring(0, tmp.length() - 1)) * 1000;
         }

         if (tmp.indexOf("s") < 0) {
            return Integer.parseInt(tmp);
         }
      }

      return 0;
   }

   static {
      readBufferSize = loadBufferSize("solon.socketd.readBufferSize");
      writeBufferSize = loadBufferSize("solon.socketd.writeBufferSize");
      connectTimeout = loadTimeout("solon.socketd.connectTimeout");
      socketTimeout = loadTimeout("solon.socketd.socketTimeout");
   }
}

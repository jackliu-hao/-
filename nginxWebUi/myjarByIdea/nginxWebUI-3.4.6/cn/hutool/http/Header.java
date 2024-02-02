package cn.hutool.http;

public enum Header {
   AUTHORIZATION("Authorization"),
   PROXY_AUTHORIZATION("Proxy-Authorization"),
   DATE("Date"),
   CONNECTION("Connection"),
   MIME_VERSION("MIME-Version"),
   TRAILER("Trailer"),
   TRANSFER_ENCODING("Transfer-Encoding"),
   UPGRADE("Upgrade"),
   VIA("Via"),
   CACHE_CONTROL("Cache-Control"),
   PRAGMA("Pragma"),
   CONTENT_TYPE("Content-Type"),
   HOST("Host"),
   REFERER("Referer"),
   ORIGIN("Origin"),
   USER_AGENT("User-Agent"),
   ACCEPT("Accept"),
   ACCEPT_LANGUAGE("Accept-Language"),
   ACCEPT_ENCODING("Accept-Encoding"),
   ACCEPT_CHARSET("Accept-Charset"),
   COOKIE("Cookie"),
   CONTENT_LENGTH("Content-Length"),
   WWW_AUTHENTICATE("WWW-Authenticate"),
   SET_COOKIE("Set-Cookie"),
   CONTENT_ENCODING("Content-Encoding"),
   CONTENT_DISPOSITION("Content-Disposition"),
   ETAG("ETag"),
   LOCATION("Location");

   private final String value;

   private Header(String value) {
      this.value = value;
   }

   public String getValue() {
      return this.value;
   }

   public String toString() {
      return this.getValue();
   }
}

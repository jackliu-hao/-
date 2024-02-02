package org.apache.http.impl.cookie;

import java.util.Date;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.cookie.CommonCookieAttributeHandler;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.util.Args;

@Contract(
   threading = ThreadingBehavior.IMMUTABLE
)
public class BasicExpiresHandler extends AbstractCookieAttributeHandler implements CommonCookieAttributeHandler {
   private final String[] datepatterns;

   public BasicExpiresHandler(String[] datepatterns) {
      Args.notNull(datepatterns, "Array of date patterns");
      this.datepatterns = datepatterns;
   }

   public void parse(SetCookie cookie, String value) throws MalformedCookieException {
      Args.notNull(cookie, "Cookie");
      if (value == null) {
         throw new MalformedCookieException("Missing value for 'expires' attribute");
      } else {
         Date expiry = org.apache.http.client.utils.DateUtils.parseDate(value, this.datepatterns);
         if (expiry == null) {
            throw new MalformedCookieException("Invalid 'expires' attribute: " + value);
         } else {
            cookie.setExpiryDate(expiry);
         }
      }
   }

   public String getAttributeName() {
      return "expires";
   }
}

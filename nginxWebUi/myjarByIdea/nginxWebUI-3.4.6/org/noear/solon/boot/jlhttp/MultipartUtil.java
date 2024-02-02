package org.noear.solon.boot.jlhttp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.noear.solon.boot.ServerProps;
import org.noear.solon.boot.io.LimitedInputStream;
import org.noear.solon.core.handle.UploadedFile;

class MultipartUtil {
   public static void buildParamsAndFiles(JlHttpContext context) throws IOException {
      HTTPServer.Request request = (HTTPServer.Request)context.request();
      HTTPServer.MultipartIterator parts = new HTTPServer.MultipartIterator(request);

      while(parts.hasNext()) {
         HTTPServer.MultipartIterator.Part part = parts.next();
         if (!isFile(part)) {
            context.paramSet(part.name, part.getString());
         } else {
            doBuildFiles(context, part);
         }
      }

   }

   private static void doBuildFiles(JlHttpContext context, HTTPServer.MultipartIterator.Part part) throws IOException {
      List<UploadedFile> list = (List)context._fileMap.get(part.getName());
      if (list == null) {
         list = new ArrayList();
         context._fileMap.put(part.getName(), list);
      }

      UploadedFile f1 = new UploadedFile();
      f1.contentType = part.getHeaders().get("Content-Type");
      f1.content = read(new LimitedInputStream(part.getBody(), (long)ServerProps.request_maxFileSize));
      f1.contentSize = (long)f1.content.available();
      f1.name = part.getFilename();
      int idx = f1.name.lastIndexOf(".");
      if (idx > 0) {
         f1.extension = f1.name.substring(idx + 1);
      }

      ((List)list).add(f1);
   }

   private static boolean isField(HTTPServer.MultipartIterator.Part filePart) {
      return filePart.getFilename() == null;
   }

   private static boolean isFile(HTTPServer.MultipartIterator.Part filePart) {
      return !isField(filePart);
   }

   private static ByteArrayInputStream read(InputStream input) throws IOException {
      ByteArrayOutputStream output = new ByteArrayOutputStream();
      byte[] buffer = new byte[4096];
      int n = false;

      int n;
      while(-1 != (n = input.read(buffer))) {
         output.write(buffer, 0, n);
      }

      return new ByteArrayInputStream(output.toByteArray());
   }
}

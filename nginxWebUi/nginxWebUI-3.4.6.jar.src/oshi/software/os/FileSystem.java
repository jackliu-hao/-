package oshi.software.os;

import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface FileSystem {
  List<OSFileStore> getFileStores();
  
  List<OSFileStore> getFileStores(boolean paramBoolean);
  
  long getOpenFileDescriptors();
  
  long getMaxFileDescriptors();
}


/* Location:              G:\git\codeReviewLog\nginxWebUi\nginxWebUI-3.4.6.jar!\oshi\software\os\FileSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
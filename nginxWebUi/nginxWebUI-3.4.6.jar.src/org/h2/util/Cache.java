package org.h2.util;

import java.util.ArrayList;

public interface Cache {
  ArrayList<CacheObject> getAllChanged();
  
  void clear();
  
  CacheObject get(int paramInt);
  
  void put(CacheObject paramCacheObject);
  
  CacheObject update(int paramInt, CacheObject paramCacheObject);
  
  boolean remove(int paramInt);
  
  CacheObject find(int paramInt);
  
  void setMaxMemory(int paramInt);
  
  int getMaxMemory();
  
  int getMemory();
}


/* Location:              G:\git\codeReviewLog\nginxWebUi\nginxWebUI-3.4.6.jar!\org\h\\util\Cache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
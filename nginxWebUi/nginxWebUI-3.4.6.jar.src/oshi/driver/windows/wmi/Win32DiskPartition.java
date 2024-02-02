/*    */ package oshi.driver.windows.wmi;
/*    */ 
/*    */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.util.platform.windows.WmiQueryHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ThreadSafe
/*    */ public final class Win32DiskPartition
/*    */ {
/*    */   private static final String WIN32_DISK_PARTITION = "Win32_DiskPartition";
/*    */   
/*    */   public enum DiskPartitionProperty
/*    */   {
/* 44 */     INDEX, DESCRIPTION, DEVICEID, DISKINDEX, NAME, SIZE, TYPE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static WbemcliUtil.WmiResult<DiskPartitionProperty> queryPartition() {
/* 56 */     WbemcliUtil.WmiQuery<DiskPartitionProperty> partitionQuery = new WbemcliUtil.WmiQuery("Win32_DiskPartition", DiskPartitionProperty.class);
/*    */     
/* 58 */     return WmiQueryHandler.createInstance().queryWMI(partitionQuery);
/*    */   }
/*    */ }


/* Location:              G:\git\codeReviewLog\nginxWebUi\nginxWebUI-3.4.6.jar!\oshi\driver\windows\wmi\Win32DiskPartition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
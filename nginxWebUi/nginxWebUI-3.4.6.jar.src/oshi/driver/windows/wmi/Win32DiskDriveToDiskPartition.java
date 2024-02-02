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
/*    */ public final class Win32DiskDriveToDiskPartition
/*    */ {
/*    */   private static final String WIN32_DISK_DRIVE_TO_DISK_PARTITION = "Win32_DiskDriveToDiskPartition";
/*    */   
/*    */   public enum DriveToPartitionProperty
/*    */   {
/* 44 */     ANTECEDENT, DEPENDENT;
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
/*    */   public static WbemcliUtil.WmiResult<DriveToPartitionProperty> queryDriveToPartition() {
/* 56 */     WbemcliUtil.WmiQuery<DriveToPartitionProperty> driveToPartitionQuery = new WbemcliUtil.WmiQuery("Win32_DiskDriveToDiskPartition", DriveToPartitionProperty.class);
/*    */     
/* 58 */     return WmiQueryHandler.createInstance().queryWMI(driveToPartitionQuery);
/*    */   }
/*    */ }


/* Location:              G:\git\codeReviewLog\nginxWebUi\nginxWebUI-3.4.6.jar!\oshi\driver\windows\wmi\Win32DiskDriveToDiskPartition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
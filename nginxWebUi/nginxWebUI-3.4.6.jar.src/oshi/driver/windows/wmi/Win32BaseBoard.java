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
/*    */ public final class Win32BaseBoard
/*    */ {
/*    */   private static final String WIN32_BASEBOARD = "Win32_BaseBoard";
/*    */   
/*    */   public enum BaseBoardProperty
/*    */   {
/* 44 */     MANUFACTURER, MODEL, VERSION, SERIALNUMBER;
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
/*    */   public static WbemcliUtil.WmiResult<BaseBoardProperty> queryBaseboardInfo() {
/* 56 */     WbemcliUtil.WmiQuery<BaseBoardProperty> baseboardQuery = new WbemcliUtil.WmiQuery("Win32_BaseBoard", BaseBoardProperty.class);
/* 57 */     return WmiQueryHandler.createInstance().queryWMI(baseboardQuery);
/*    */   }
/*    */ }


/* Location:              G:\git\codeReviewLog\nginxWebUi\nginxWebUI-3.4.6.jar!\oshi\driver\windows\wmi\Win32BaseBoard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
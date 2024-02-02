/*    */ package oshi.software.os.windows;
/*    */ 
/*    */ import com.sun.jna.platform.win32.Kernel32;
/*    */ import com.sun.jna.platform.win32.WinBase;
/*    */ import com.sun.jna.platform.win32.WinNT;
/*    */ import com.sun.jna.ptr.IntByReference;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
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
/*    */ public class WindowsOSSystemInfo
/*    */ {
/* 38 */   private static final Logger LOG = LoggerFactory.getLogger(WindowsOSSystemInfo.class);
/*    */ 
/*    */   
/* 41 */   private WinBase.SYSTEM_INFO systemInfo = null;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public WindowsOSSystemInfo() {
/* 47 */     init();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public WindowsOSSystemInfo(WinBase.SYSTEM_INFO si) {
/* 57 */     this.systemInfo = si;
/*    */   }
/*    */   
/*    */   private void init() {
/* 61 */     WinBase.SYSTEM_INFO si = new WinBase.SYSTEM_INFO();
/* 62 */     Kernel32.INSTANCE.GetSystemInfo(si);
/*    */     
/*    */     try {
/* 65 */       IntByReference isWow64 = new IntByReference();
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 70 */       WinNT.HANDLE hProcess = Kernel32.INSTANCE.GetCurrentProcess();
/* 71 */       if (Kernel32.INSTANCE.IsWow64Process(hProcess, isWow64) && isWow64.getValue() > 0)
/*    */       {
/* 73 */         Kernel32.INSTANCE.GetNativeSystemInfo(si);
/*    */       }
/* 75 */     } catch (UnsatisfiedLinkError e) {
/*    */       
/* 77 */       LOG.trace("No WOW64 support: {}", e.getMessage());
/*    */     } 
/*    */     
/* 80 */     this.systemInfo = si;
/* 81 */     LOG.debug("Initialized OSNativeSystemInfo");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getNumberOfProcessors() {
/* 90 */     return this.systemInfo.dwNumberOfProcessors.intValue();
/*    */   }
/*    */ }


/* Location:              G:\git\codeReviewLog\nginxWebUi\nginxWebUI-3.4.6.jar!\oshi\software\os\windows\WindowsOSSystemInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
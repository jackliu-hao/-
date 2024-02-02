/*    */ package oshi.jna.platform.unix.freebsd;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.Structure;
/*    */ import com.sun.jna.Structure.FieldOrder;
/*    */ import com.sun.jna.ptr.IntByReference;
/*    */ import oshi.jna.platform.unix.CLibrary;
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
/*    */ public interface FreeBsdLibc
/*    */   extends CLibrary
/*    */ {
/* 39 */   public static final FreeBsdLibc INSTANCE = (FreeBsdLibc)Native.load("libc", FreeBsdLibc.class);
/*    */   public static final int UTX_USERSIZE = 32;
/*    */   public static final int UTX_LINESIZE = 16;
/*    */   public static final int UTX_IDSIZE = 8;
/*    */   public static final int UTX_HOSTSIZE = 128;
/*    */   
/*    */   @FieldOrder({"ut_type", "ut_tv", "ut_id", "ut_pid", "ut_user", "ut_line", "ut_host", "ut_spare"})
/*    */   public static class FreeBsdUtmpx
/*    */     extends Structure {
/*    */     public short ut_type;
/*    */     public FreeBsdLibc.Timeval ut_tv;
/* 50 */     public byte[] ut_id = new byte[8];
/*    */     public int ut_pid;
/* 52 */     public byte[] ut_user = new byte[32];
/* 53 */     public byte[] ut_line = new byte[16];
/* 54 */     public byte[] ut_host = new byte[128];
/* 55 */     public byte[] ut_spare = new byte[64];
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 62 */   public static final int UINT64_SIZE = Native.getNativeSize(long.class);
/*    */   
/* 64 */   public static final int INT_SIZE = Native.getNativeSize(int.class);
/*    */   
/*    */   public static final int CPUSTATES = 5;
/*    */   public static final int CP_USER = 0;
/*    */   public static final int CP_NICE = 1;
/*    */   public static final int CP_SYS = 2;
/*    */   public static final int CP_INTR = 3;
/*    */   public static final int CP_IDLE = 4;
/*    */   
/*    */   int sysctl(int[] paramArrayOfint, int paramInt1, Pointer paramPointer1, IntByReference paramIntByReference, Pointer paramPointer2, int paramInt2);
/*    */   
/*    */   int sysctlbyname(String paramString, Pointer paramPointer1, IntByReference paramIntByReference, Pointer paramPointer2, int paramInt);
/*    */   
/*    */   int sysctlnametomib(String paramString, Pointer paramPointer, IntByReference paramIntByReference);
/*    */   
/*    */   FreeBsdUtmpx getutxent();
/*    */   
/*    */   @FieldOrder({"tv_sec", "tv_usec"})
/*    */   public static class Timeval
/*    */     extends Structure
/*    */   {
/*    */     public long tv_sec;
/*    */     public long tv_usec;
/*    */   }
/*    */   
/*    */   @FieldOrder({"cpu_ticks"})
/*    */   public static class CpTime
/*    */     extends Structure
/*    */   {
/* 93 */     public long[] cpu_ticks = new long[5];
/*    */   }
/*    */ }


/* Location:              G:\git\codeReviewLog\nginxWebUi\nginxWebUI-3.4.6.jar!\oshi\jna\platfor\\unix\freebsd\FreeBsdLibc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
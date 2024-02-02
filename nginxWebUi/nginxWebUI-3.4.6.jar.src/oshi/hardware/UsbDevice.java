package oshi.hardware;

import java.util.List;
import oshi.annotation.concurrent.Immutable;

@Immutable
public interface UsbDevice extends Comparable<UsbDevice> {
  String getName();
  
  String getVendor();
  
  String getVendorId();
  
  String getProductId();
  
  String getSerialNumber();
  
  String getUniqueDeviceId();
  
  List<UsbDevice> getConnectedDevices();
}


/* Location:              G:\git\codeReviewLog\nginxWebUi\nginxWebUI-3.4.6.jar!\oshi\hardware\UsbDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
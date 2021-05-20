/*
 * 轉接器模式
 */


public class AdapterPattern {
	 public static void main(String[] args) {
		 HDMI adapterHDMItoVGA = new AdapterHDMItoVGA();
		 adapterHDMItoVGA.isHDMI();
	    }
}

/* Target  HDMI接口*/
abstract class HDMI {
	
	void isHDMI() {
		System.out.println("is HDMI");
	}
}

/* Adaptee VGA接口*/
class VGA  {
	
	void isVGA() {
		System.out.println("is VGA");
	}
}

/* Adapter 因為不能修改Adaptee 宣告另一個類別繼承Target 包含Adaptee物件  轉接器*/
class AdapterHDMItoVGA extends HDMI{
	
	private VGA vga =new VGA();
	
	@Override
	public void isHDMI() {
		vga.isVGA();
	}
}










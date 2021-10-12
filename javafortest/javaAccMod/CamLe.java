package javaAccMod;

/**
 * Package chứa 2 Class A & B Class A có biến là public thì class B có thể dùng
 * biến có trong cùng 1 package
 * 
 * @author AN
 */
public class CamLe {
	/**
	 * Cái này là biến Thuộc tính public
	 */
	public String stateSize;

	/**
	 * Hàm public
	 * 
	 * @return
	 */
	public String getstateSize() {

		return stateSize;
	}

	/**
	 * Default
	 */
	String stateZipcode = "55000";

	// Protected
	protected String stateGDP = "100000";

	/**
	 * Hàm default
	 * 
	 * @return
	 */
	String getStateZipcode() {

		return this.stateZipcode;

	}

	// Hàm protected
			protected String getstateGDP() {
				return stateGDP;
			}
	/**
	 * Nested-Class
	 * 
	 * @author AN
	 *
	 */
	class HoaPhat {
		public void showStateSize() {
			System.out.println(stateSize);
			System.out.println(stateZipcode);
			System.out.println(stateGDP);
			getStateZipcode();
			getstateGDP();
		}

		
	}

}
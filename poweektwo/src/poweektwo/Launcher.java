package poweektwo;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Actual Size: " + realSize("32GB"));
		System.out.println("Actual Size: " + realSize("2GB"));
		System.out.println("Actual Size: " + realSize("512MB"));
		System.out.println("Actual Size: " + realSize("0.5GB"));

	}
	
	static String realSize(String s) {
		String type = "";
		int index = s.length();
		double val = 0;
		String out = "";
		
		
		
		if((s.charAt(index-2))  == 'G') {
			type = "GB";
			
			val = Double.parseDouble(removeLastChars(s, 2));
			val -= val * 0.07;
			if (val < 1) {
				type = "MB";
				val = val*1000;
				int x = (int) val;
				out = String.valueOf(x);
			}else {
				out = String.format("%.2f", val);
			}
		}else if((s.charAt(index-2)) == 'M'){
			type = "MB";
			
			val = Double.parseDouble(removeLastChars(s, 2));
			val -= val * 0.07;
			val= Math.round(val);
			out = String.valueOf((int)val);
		}
		
		
		
		
		return ( out + type );
	}
	
	 static String removeLastChars(String str, int chars) {
        return str.substring(0, str.length() - chars);
    }

}

package chapter5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;


public class MLPData {
	
	private String[] classtype = new String[] {"Bike","Car","Bus","Truck"};
	
	public static void main(String[] args) {
		MLPData lp = new MLPData();
	}

	public MLPData() {
		// TODO Auto-generated constructor stub
		Random rand  = new Random(System.nanoTime());
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("./vehicledata2.csv"));
			out.write("wheels,chassis,pax,vtype\n");
			
			for (int i = 0; i < 100000; i++) {
				StringBuilder sb = new StringBuilder();
				switch (rand.nextInt(4)) {
				case 0:
					sb.append((rand.nextInt(1)+1)+","); //¹ÙÄûÀÇ °³¼ö
					sb.append((rand.nextInt(1)+1)+","); //¼¨½ÃÀÇ ±æÀÌ
					sb.append((rand.nextInt(1)+1)+","); //½ÂÂ÷ ÀÎ¿ø¼ö
					sb.append(classtype[0]+"\n");
					break;
				case 1:
					sb.append((rand.nextInt(2)+4)+","); //¹ÙÄûÀÇ °³¼ö
					sb.append((rand.nextInt(4)+1)+","); //¼¨½ÃÀÇ ±æÀÌ
					sb.append((rand.nextInt(4)+1)+","); //½ÂÂ÷ ÀÎ¿ø¼ö
					sb.append(classtype[1]+"\n");
					break;
				case 2:
					sb.append((rand.nextInt(6)+4)+","); //¹ÙÄûÀÇ °³¼ö
					sb.append((rand.nextInt(12)+12)+","); //¼¨½ÃÀÇ ±æÀÌ
					sb.append((rand.nextInt(30)+10)+","); //½ÂÂ÷ ÀÎ¿ø¼ö
					sb.append(classtype[2]+"\n");
					break;
				case 3:
					sb.append("18,"); //¹ÙÄûÀÇ °³¼ö
					sb.append((rand.nextInt(10)+20)+","); //¼¨½ÃÀÇ ±æÀÌ
					sb.append((rand.nextInt(2)+1)+","); //½ÂÂ÷ ÀÎ¿ø¼ö
					sb.append(classtype[3]+"\n");
					break;

				default:
					break;
				}
				out.write(sb.toString());
			}
			out.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	
	}
}

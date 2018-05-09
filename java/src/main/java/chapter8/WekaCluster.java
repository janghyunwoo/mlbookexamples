package chapter8;

import java.util.Random;

import weka.clusterers.SimpleKMeans;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class WekaCluster {

	public WekaCluster(String filepath, int clusters) {
		try {
			Instances data = DataSource.read(filepath);
			
			//clusters = calculateRuleOfThumb(data.numInstances());
			System.out.println("Rule of Thumb Clusters = "+ clusters);
			
			SimpleKMeans kMeans = new SimpleKMeans();
			kMeans.setNumClusters(clusters);
			kMeans.setSeed(42);
			kMeans.buildClusterer(data);
			
			Instances centroids = kMeans.getClusterCentroids();
			for (int i = 0; i < centroids.numInstances(); i++) {
				System.out.println("Centroid: "+ i + ": " + centroids.instance(i));
			}
			
			for (int i = 0; i < data.numInstances(); i++) {
				System.out.println("Instance "+ i + " in cluster" + kMeans.clusterInstance(data.instance(i)));
			}
			
			testRandomInstances(kMeans);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static int pridictCluster(SimpleKMeans kMeans, double x, double y) {
		int clusterNumber = -1;
		try {
			double[] newdata = new double[] {x,y};
			Instance testInstance = new Instance(1.0,newdata);
			clusterNumber = kMeans.clusterInstance(testInstance);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return clusterNumber;
	}
	
	public static void testRandomInstances(SimpleKMeans kMeans) {
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			double x = rand.nextInt(200);
			double y = rand.nextInt(200);
			System.out.println(x+"/"+y+" test in cluster "+pridictCluster(kMeans,x,y));
			
		}
	}
	
	public static int calculateRuleOfThumb(int rows) {
		return (int)Math.sqrt(rows/2);
	}
	
	public static void main(String[] args) {
		// Pass the arff location and the number of clusters we want
		WekaCluster wc = new WekaCluster("kmeansdata.arff", 6);

	}

}

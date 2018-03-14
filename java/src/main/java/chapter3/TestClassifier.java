package chapter3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import weka.core.Instances;

public class TestClassifier {
	public static void main(String[] args) {
		WekaWrapper ww = new WekaWrapper();
		try {
			Instances unlabeled = new Instances(new BufferedReader(new FileReader("./lg2.arff")));

			unlabeled.setClassIndex(unlabeled.numAttributes() - 1);
			Instances trained = new Instances(unlabeled);

			for (int i = 0; i < unlabeled.numInstances(); i++) {
				double clsLabel = ww.classifyInstance(unlabeled.instance(i));
				trained.instance(i).setClassValue(clsLabel);
				System.out.println(clsLabel + " -> " + unlabeled.classAttribute().value((int) clsLabel));
			}

			BufferedWriter writer = new BufferedWriter(new FileWriter("./labeled2.txt"));
			writer.write(trained.toString());
			writer.newLine();
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

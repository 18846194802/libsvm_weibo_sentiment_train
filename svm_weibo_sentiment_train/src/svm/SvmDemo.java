package svm;

import java.io.IOException;

public class SvmDemo {
	// "-c","9.0", "-g","1.0",
	public static void svm_start() throws IOException {
		
		  String[] arg = {"train.txt", //ѵ����  
          "model.txt" }; // ���SVMѵ��ģ��  
		System.out.println("........SVM���п�ʼ..........");
		long start = System.currentTimeMillis();
		
		 svm_train.main(arg); //ѵ��
		
		System.out.println("������ʱ:" + (System.currentTimeMillis() - start));
	}

	

}

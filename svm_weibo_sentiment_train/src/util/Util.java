package util;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Util {

	
	public static void Sta() throws Exception{   
        // ���ָ���ļ�����  
        File file = new File("./_data");   
        // ��ø��ļ����ڵ������ļ�   
        File[] array = file.listFiles();   
        	Set  set=new HashSet();
        for(int i=0;i<array.length;i++)
        {   
            if(array[i].isFile())//������ļ�
            {   
                   
                // ֻ����ļ�����  
                System.out.println(array[i].getName());   
                if(array[i].getName().equals("pos60000.txt")){
                	TestStep1Pos.sta();
                }else if(array[i].getName().equals("neg60000.txt")){
                	TestStep1Neg.sta();
                	
                }
              
            }
          
        }
	
    }   

}

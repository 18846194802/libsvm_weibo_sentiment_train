package nlp;

import util.OSInfo;
import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * �ִ������Java�ӿڣ�����JNA������ʵ��
 * 
 * @author move
 * 
 */
public interface NlpirLib extends Library {
	// ���岢��ʼ���ӿڵľ�̬������ͨ��JNA����NLPIR.dll;
	NlpirLib Instance = (NlpirLib) Native.loadLibrary(OSInfo.getModulePath("NLPIR"), NlpirLib.class);

	/**
	 * �����ʼ��
	 * 
	 * @param sDataPath
	 *            Data�ļ��еĸ�Ŀ¼�����Ϊ���ַ���������""������ô�������Զ�����Ŀ�ĸ�Ŀ¼��Ѱ��
	 * @param encoding
	 *            �����ʽ������ı���������£� 0��GBK��1��UTF8��2��BIG5��3��GBK���������������
	 * @param sLicenceCode
	 *            ��Ȩ�룬Ϊ���ַ���������""���Ϳ�����
	 * @return true����ʼ���ɹ���false����ʼ��ʧ��
	 */
	public boolean NLPIR_Init(String sDataPath, int encoding, String sLicenceCode);

	/**
	 * �ִ�
	 * 
	 * @param sSrc
	 *            �ı�����
	 * @param bPOSTagged
	 *            1����ʾ���ԣ�0������ʾ����
	 * @return �ִʽ��
	 */
	public String NLPIR_ParagraphProcess(String sParagraph, int bPOSTagged);

	/**
	 * �ִ�
	 * 
	 * @param sSourceFilename
	 *            �ı��ļ���·��
	 * @param sResultFilename
	 *            ����ļ���·��
	 * @param bPOStagged
	 *            1����ʾ���ԣ�0������ʾ����
	 * @return
	 */
	public double NLPIR_FileProcess(String sSourceFilename, String sResultFilename, int bPOStagged);

	
	/**
	 * ϸ���ȷִ�
	 * 
	 * @param lenWords
	 *            �ı�����
	 * @return �ִʽ��
	 */
	public String NLPIR_FinerSegment(String lenWords);

	/**
	 * �ؼ���
	 * 
	 * @param sLine
	 *            �ı�����
	 * @param nMaxKeyLimit
	 *            ���ɹؼ��ʵĸ�������
	 * @param bWeightOut
	 *            true����ʾ���ԣ�false������ʾ����
	 * @return �ؼ�����ɵ��ַ��� ��ע���������г��ֵĴʣ�������Ϊ�ؼ��ʳ���
	 */
	public String NLPIR_GetKeyWords(String sLine, int nMaxKeyLimit, boolean bWeightOut);

	/**
	 * �ؼ���
	 * 
	 * @param sFilename
	 *            �ı��ļ���·��
	 * @param nMaxKeyLimit
	 *            ���ɵĹؼ��ʵĸ�������
	 * @param bWeightOut
	 *            true����ʾ���ԣ�false������ʾ����
	 * @return �ؼ�����ɵ��ַ��� ��ע���������г��ֵĴʣ�������Ϊ�ؼ��ʳ���
	 */
	public String NLPIR_GetFileKeyWords(String sFilename, int nMaxKeyLimit, boolean bWeightOut);

	/**
	 * �´�
	 * 
	 * @param sLine
	 *            �ı�����
	 * @param nMaxKeyLimit
	 *            ���ɵ��´ʵĸ�������
	 * @param bWeightOut
	 *            true����ʾ���ԣ�false������ʾ����
	 * @return �´���ɵ��ַ���
	 */
	public String NLPIR_GetNewWords(String sLine, int nMaxKeyLimit, boolean bWeightOut);

	/**
	 * �´�
	 * 
	 * @param string
	 *            �ı��ļ���·��
	 * @param nMaxKeyLimit
	 *            ���ɵ��´ʵĸ�������
	 * @param bWeightOut
	 *            true:��ʾ������Ϣ��false:����ʾ������Ϣ
	 * @return �´���ɵ��ַ���
	 */
	public String NLPIR_GetFileNewWords(String sFilename, int nMaxKeyLimit, boolean bWeightOut);

	/**
	 * ����û��Զ����
	 * 
	 * @param userWord
	 *            �û��� ��ʽ������+�ո�+���ԣ����磺��� v
	 * @return 1���ڴ��в����ڣ�2���ڴ����Ѵ��� ��ע�����浽�ڴ��У��´γ�ʼ����ʧЧ����Ҫ��save���浽�ļ���
	 */
	public int NLPIR_AddUserWord(String userWord);

	/**
	 * �����û��Զ����(���浽�ļ���)
	 * 
	 * @return 1���ɹ���0��ʧ��
	 */
	public int NLPIR_SaveTheUsrDic();

	/**
	 * ɾ���û��Զ����
	 * 
	 * @param sWord
	 *            ��Ҫɾ���ĵ���
	 * @return ��ɾ���������ڴ��е�λ�ã�-1��ʾ������ ��ע��ɾ���ڴ��е��Զ���ʣ��´γ�ʼ����ʧЧ����Ҫ��save���浽�ļ���
	 */
	public int NLPIR_DelUsrWord(String sWord);

	/**
	 * �����û��Զ���ʵ�
	 * 
	 * @param dictFileName
	 *            �û��ʵ��·��
	 * @param bOverwrite
	 *            �Ƿ�ɾ��ԭ�е��Զ����û��ʵ䣬true��ɾ����false����ɾ��
	 * @return �����û����ʸ��� ��ע��ϵͳ���Զ������ظ��ʵ�����
	 */
	public int NLPIR_ImportUserDict(String dictFileName, boolean bOverwrite);

	/**
	 * ����ؼ��ʺ�����
	 * 
	 * @param sFilename
	 *            �ļ���·��
	 * @return ��ע���ɹ�����󣬺������г��ֵĴʣ�������Ϊ�ؼ��ʳ���
	 */
	public int NLPIR_ImportKeyBlackList(String sFilename);

	/**
	 * ����ָ����
	 * 
	 * @param sLine
	 *            �ı�����
	 * @return ָ����
	 */
	public long NLPIR_FingerPrint(String sLine);

	/**
	 * ���ʵĴ���
	 * 
	 * @param sWords
	 *            ���ʣ����磺�л����񹲺͹�
	 * @return ���ʵĴ��ԣ����磺�л����񹲺͹�/ns/607#
	 */
	public String NLPIR_GetWordPOS(String sWords);

	/**
	 * �жϵ����Ƿ��ں��Ĵʿ���
	 * 
	 * @param word
	 *            ����ĵ���
	 * @return ������ʲ����ھͷ���-1�����򷵻ص����ڴʵ��еľ��
	 */
	public int NLPIR_IsWord(String word);

	/**
	 * ��ȡ�����ı��Ĵʣ����ԣ�Ƶͳ�ƽ�������մ�Ƶ��С����
	 * 
	 * @param sText
	 *            �ı�����
	 * @return ��Ƶͳ�ƽ����ʽ���£��Ż�ƽ/nr/10#��ʿ/n/9#�ִ�/n/8
	 */
	public String NLPIR_WordFreqStat(String sText);

	/**
	 * ��ȡ�����ı��ļ��Ĵʣ����ԣ�Ƶͳ�ƽ�������մ�Ƶ��С����
	 * 
	 * @param sFilename
	 *            �ı��ļ���ȫ·��
	 * @return ��Ƶͳ�ƽ����ʽ���£��Ż�ƽ/nr/10#��ʿ/n/9#�ִ�/n/8
	 */
	public String NLPIR_FileWordFreqStat(String sFilename);

	/**
	 * ��ȡ����Ӣ�ĵ��ʵ�ԭ�ͣ������˹�ȥ�ִʡ������������
	 * 
	 * @param sWord
	 *            ����ĵ���
	 * @return ��ԭ����ʽ�����磺driven->drive drives->drive drove-->drive
	 */
	public String NLPIR_GetEngWordOrign(String sWord);

	/**
	 * �������һ�εĳ�����Ϣ
	 * 
	 * @return ���һ�εĳ�����Ϣ
	 */
	public String NLPIR_GetLastErrorMsg();

	/**
	 * �˳����ͷ���Դ
	 * 
	 * @return
	 */
	public boolean NLPIR_Exit();
}

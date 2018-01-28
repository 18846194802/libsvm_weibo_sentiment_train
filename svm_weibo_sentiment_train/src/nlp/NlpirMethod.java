package nlp;

import nlp.NlpirLib;

/**
 * �ִ����������
 * 
 * @author move
 *
 */
public class NlpirMethod {
	// ��ʼ��
	static {
		boolean flag = NlpirLib.Instance.NLPIR_Init("", 1, "");

		if (flag) {
			System.out.println("nlpir��ʼ���ɹ�");
		} else {
			System.out.println("nlpir��ʼ��ʧ�ܣ�" + NlpirLib.Instance.NLPIR_GetLastErrorMsg());
			System.exit(1);
		}
	}

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
	public static boolean NLPIR_Init(String sDataPath, int encoding, String sLicenceCode) {
		return NlpirLib.Instance.NLPIR_Init(sDataPath, 1, sLicenceCode);
	}

	/**
	 * �ִ�
	 * 
	 * @param sSrc
	 *            �ı�����
	 * @param bPOSTagged
	 *            1����ʾ���ԣ�0������ʾ����
	 * @return �ִʽ��
	 */
	public static String NLPIR_ParagraphProcess(String sParagraph, int bPOSTagged) {
		return NlpirLib.Instance.NLPIR_ParagraphProcess(sParagraph, bPOSTagged);
	}

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
	public static double NLPIR_FileProcess(String sSourceFilename, String sResultFilename, int bPOStagged) {
		return NlpirLib.Instance.NLPIR_FileProcess(sSourceFilename, sResultFilename, bPOStagged);
	}

	/**
	 * ϸ���ȷִ�
	 * 
	 * @param lenWords
	 *            �ı�����
	 * @return �ִʽ��
	 */
	public static String NLPIR_FinerSegment(String lenWords) {
		return NlpirLib.Instance.NLPIR_FinerSegment(lenWords);
	}

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
	public static String NLPIR_GetKeyWords(String sLine, int nMaxKeyLimit, boolean bWeightOut) {
		return NlpirLib.Instance.NLPIR_GetKeyWords(sLine, nMaxKeyLimit, bWeightOut);
	}

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
	public static String NLPIR_GetFileKeyWords(String sFilename, int nMaxKeyLimit, boolean bWeightOut) {
		return NlpirLib.Instance.NLPIR_GetFileKeyWords(sFilename, nMaxKeyLimit, bWeightOut);
	}

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
	public static String NLPIR_GetNewWords(String sLine, int nMaxKeyLimit, boolean bWeightOut) {
		return NlpirLib.Instance.NLPIR_GetNewWords(sLine, nMaxKeyLimit, bWeightOut);
	}

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
	public static String NLPIR_GetFileNewWords(String sFilename, int nMaxKeyLimit, boolean bWeightOut) {
		return NlpirLib.Instance.NLPIR_GetFileNewWords(sFilename, nMaxKeyLimit, bWeightOut);
	}

	/**
	 * ����û��Զ����
	 * 
	 * @param userWord
	 *            �û��� ��ʽ������+�ո�+���ԣ����磺��� v
	 * @return 1���ڴ��в����ڣ�2���ڴ����Ѵ��� ��ע�����浽�ڴ��У��´γ�ʼ����ʧЧ����Ҫ��save���浽�ļ���
	 */
	public static int NLPIR_AddUserWord(String userWord) {
		return NlpirLib.Instance.NLPIR_AddUserWord(userWord);
	}

	/**
	 * �����û��Զ����(���浽�ļ���)
	 * 
	 * @return 1���ɹ���0��ʧ��
	 */
	public static int NLPIR_SaveTheUsrDic() {
		return NlpirLib.Instance.NLPIR_SaveTheUsrDic();
	}

	/**
	 * ɾ���û��Զ����
	 * 
	 * @param sWord
	 *            ��Ҫɾ���ĵ���
	 * @return ��ɾ���������ڴ��е�λ�ã�-1��ʾ������ ��ע��ɾ���ڴ��е��Զ���ʣ��´γ�ʼ����ʧЧ����Ҫ��save���浽�ļ���
	 */
	public static int NLPIR_DelUsrWord(String sWord) {
		return NlpirLib.Instance.NLPIR_DelUsrWord(sWord);
	}

	/**
	 * �����û��Զ���ʵ�
	 * 
	 * @param dictFileName
	 *            �û��ʵ��·��
	 * @param bOverwrite
	 *            �Ƿ�ɾ��ԭ�е��Զ����û��ʵ䣬true��ɾ����false����ɾ��
	 * @return �����û����ʸ��� ��ע��ϵͳ���Զ������ظ��ʵ�����
	 */
	public static int NLPIR_ImportUserDict(String dictFileName, boolean bOverwrite) {
		return NlpirLib.Instance.NLPIR_ImportUserDict(dictFileName, bOverwrite);
	}

	/**
	 * ����ؼ��ʺ�����
	 * 
	 * @param sFilename
	 *            �ļ���·��
	 * @return ��ע���ɹ�����󣬺������г��ֵĴʣ�������Ϊ�ؼ��ʳ���
	 */
	public static int NLPIR_ImportKeyBlackList(String sFilename) {
		return NlpirLib.Instance.NLPIR_ImportKeyBlackList(sFilename);
	}

	/**
	 * ����ָ����
	 * 
	 * @param sLine
	 *            �ı�����
	 * @return ָ����
	 */
	public static long NLPIR_FingerPrint(String sLine) {
		return NlpirLib.Instance.NLPIR_FingerPrint(sLine);
	}

	/**
	 * ���ʵĴ���
	 * 
	 * @param sWords
	 *            ���ʣ����磺�л����񹲺͹�
	 * @return ���ʵĴ��ԣ����磺�л����񹲺͹�/ns/607#
	 */
	public static String NLPIR_GetWordPOS(String sWords) {
		return NlpirLib.Instance.NLPIR_GetWordPOS(sWords);
	}

	/**
	 * �жϵ����Ƿ��ں��Ĵʿ���
	 * 
	 * @param word
	 *            ����ĵ���
	 * @return ������ʲ����ھͷ���-1�����򷵻ص����ڴʵ��еľ��
	 */
	public static int NLPIR_IsWord(String word) {
		return NlpirLib.Instance.NLPIR_IsWord(word);
	}

	/**
	 * ��ȡ�����ı��Ĵʣ����ԣ�Ƶͳ�ƽ�������մ�Ƶ��С����
	 * 
	 * @param sText
	 *            �ı�����
	 * @return ��Ƶͳ�ƽ����ʽ���£��Ż�ƽ/nr/10#��ʿ/n/9#�ִ�/n/8
	 */
	public static String NLPIR_WordFreqStat(String sText) {
		return NlpirLib.Instance.NLPIR_WordFreqStat(sText);
	}

	/**
	 * ��ȡ�����ı��ļ��Ĵʣ����ԣ�Ƶͳ�ƽ�������մ�Ƶ��С����
	 * 
	 * @param sFilename
	 *            �ı��ļ���ȫ·��
	 * @return ��Ƶͳ�ƽ����ʽ���£��Ż�ƽ/nr/10#��ʿ/n/9#�ִ�/n/8
	 */
	public static String NLPIR_FileWordFreqStat(String sFilename) {
		return NlpirLib.Instance.NLPIR_FileWordFreqStat(sFilename);
	}

	/**
	 * ��ȡ����Ӣ�ĵ��ʵ�ԭ�ͣ������˹�ȥ�ִʡ������������
	 * 
	 * @param sWord
	 *            ����ĵ���
	 * @return ��ԭ����ʽ�����磺driven->drive drives->drive drove-->drive
	 */
	public static String NLPIR_GetEngWordOrign(String sWord) {
		return NlpirLib.Instance.NLPIR_GetEngWordOrign(sWord);
	}

	/**
	 * �������һ�εĳ�����Ϣ
	 * 
	 * @return ���һ�εĳ�����Ϣ
	 */
	public static String NLPIR_GetLastErrorMsg() {
		return NlpirLib.Instance.NLPIR_GetLastErrorMsg();
	}

	/**
	 * �˳����ͷ���Դ
	 * 
	 * @return
	 */
	public static boolean NLPIR_Exit() {
		return NlpirLib.Instance.NLPIR_Exit();
	}
}

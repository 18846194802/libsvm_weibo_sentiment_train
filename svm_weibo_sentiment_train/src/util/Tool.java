package util;

public class Tool {
	private static boolean isNotEmojiCharacter(char codePoint) {
		return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) || (codePoint == 0xD)
				|| ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
				|| ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
	}

	/**
	 * ����emoji ���� �������������͵��ַ�
	 * 
	 * @param source
	 * @return
	 */
	public static String filterEmoji(String source) {
		int len = source.length();
		StringBuilder buf = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char codePoint = source.charAt(i);
			if (isNotEmojiCharacter(codePoint)) {
				buf.append(codePoint);
			} else {

				buf.append("");

			}
		}
		return buf.toString();
	}
	
	public static String deletExtraWord(String string) {
		//ȥhttp,ȥ@ ��ȥ# ȥ:
		if(string.length()>1){
			String a = filterEmoji(string);
			
			a = a.substring(1);
			String r = null;
			if(a.contains("#")){
				 r = a.replaceAll("#.*.#", "");
			}else{
				r=a;
			}
			while(r.contains("@")){
				int i = r.indexOf("@");
				String str = r.substring(i, r.indexOf(" ", i));
				r = r.replace(str, "");	
			}
			
			String all = a.replaceAll("http.*.[0-9]|[a-z]|[A-Z]", "");
			String end = all.replaceAll(" ", "");
			return end;
		}else{
			return string;
		}
	}
	public static String DeleteAtPraise(String string) {
		String s = filterEmoji(string.substring(5));
		String end="";
		if(s.contains("��[")){
			if(s.contains("@")){
				end=s.substring(0, s.indexOf("@"));
			}else{
				end=s.substring(0, s.indexOf("��["));
			}
		}else{
			end=s;
		}
		
		return end;
	}
	public static String deletOne(String string) {
		string = string.substring(1);
		return string;
		
	}
	public static String deletHttpSping(String string) {
		//ȥhttp,ȥ@ ��ȥ# ȥ:
		String end = null;
		if(string.length()>1){
			String a = filterEmoji(string);
			
			String r = null;
			if(a.contains("#")){
				 r = a.replaceAll("#.*.#", "");
			}else{
				r=a;
			}
			if(r.contains("http")){
				String all = r.replaceAll("http.*.[0-9]|[a-z]|[A-Z]", "");
				end = all.replaceAll(" ", "");
			}else{
				end=r;
			}
			
			
			return end;
		}else{
			return string;
		}
	}
	}

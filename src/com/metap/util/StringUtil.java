package com.metap.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtil {
	public static boolean isNumber(char a) {
		if (a >= '0' && a <= '9') {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isChar(char a) {
		if (a >= 0 && a <= 255) {
			return true;
		} else {
			return false;
		}
	}

	public static String getSysFileSeparator() {
		return System.getProperty("file.separator");
	}

	public static String getFileNameWithSuffix(String fileName) {
		return getFileName(fileName) + getSuffixName(fileName);
	}

	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getSuffixName(String fileName) {
		int sidx1 = fileName.lastIndexOf("/");
		int sidx2 = fileName.lastIndexOf("\\");

		int sidx = (sidx1 > sidx2) ? sidx1 : sidx2;
		if ((++sidx) < 0)
			sidx = 0;

		int idx = fileName.indexOf(".");

		if (idx != -1 && idx > sidx) {
			return fileName.substring(idx);
		} else {
			return "";
		}
	}

	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFileName(String fileName) {
		int sidx1 = fileName.lastIndexOf("/");
		int sidx2 = fileName.lastIndexOf("\\");

		int sidx = (sidx1 > sidx2) ? sidx1 : sidx2;
		if ((++sidx) < 0)
			sidx = 0;

		int idx = fileName.indexOf(".");

		if (idx > 0 && sidx >=0) {
			return fileName.substring(sidx, idx);
		} else {
			return fileName.substring(sidx);
		}
	}

	public static String getFilePath(String filePathAndName) {
		int sidx1 = filePathAndName.lastIndexOf("/");
		int sidx2 = filePathAndName.lastIndexOf("\\");

		int sidx = (sidx1 > sidx2) ? sidx1 : sidx2;
		if ((sidx) < 0)
			sidx = 0;

		return filePathAndName.substring(0, sidx);
	}

	public static boolean contain(ArrayList<String> strs, String data) {
		boolean result = false;

		if (strs != null) {
			for (String str : strs) {
				if (str != null && str.trim().equals(data)) {
					result = true;
				}
			}
		}

		return result;
	}

	/**
	 * 
	 * @param fileName
	 * @param str
	 * @return
	 */
	public static String addSuffix2Tail(String fileName, String str) {
		str = str.replace('/', '_');
		str = str.replace('\\', '_');
		str = str.replace(' ', '_');
		int index = fileName.lastIndexOf(".");
		if (index >= 0) {
			String s = fileName.substring(0, index) + str;
			if (index != (fileName.length() - 1)) {
				s += fileName.substring(index);
			}

			return s;
		} else {
			return fileName + str;
		}
	}

	public static String doubleArray2String(Double[] doubles) {
		return doubleArray2String(doubles, 16);
	}

	public static String stringArray2String(String... strs) {
		return stringArray2String(strs, 16);
	}

	public static String stringArray2String(ArrayList<String> strs) {
		return StringArray2String(strs, 16);
	}

	public static String StringArray2String(ArrayList<String> strs, int len) {
		StringBuffer sb = new StringBuffer();

		if (strs != null) {
			String format = "%" + len + "s";
			for (String str : strs) {
				sb.append(String.format(format, str));
			}
		}
		return sb.toString();
	}

	public static String doubleArray2String(ArrayList<Double> strs, int len) {
		StringBuffer sb = new StringBuffer();

		if (strs != null) {
			String format = "%" + len + "f";
			for (Double str : strs) {
				sb.append(String.format(format, str));
			}
		}
		return sb.toString();
	}

	public static String stringArray2String(String[] strs, int len) {
		StringBuffer sb = new StringBuffer();

		String format = "%" + len + "s";
		for (String str : strs) {
			sb.append(String.format(format, str));
		}

		return sb.toString();
	}

	public static String doubleArray2String(Double[] strs, int len) {
		StringBuffer sb = new StringBuffer();

		String format = "%" + len + "s";
		for (Double str : strs) {
			sb.append(String.format(format, str));
		}

		return sb.toString();
	}

	/**
	 * 
	 * @param fileName
	 * @param otherFileName
	 * @return
	 */
	public static String appendFileName2Tail(String fileName,
			String otherFileName) {
		int sidx1 = otherFileName.lastIndexOf("/");
		int sidx2 = otherFileName.lastIndexOf("\\");

		int sidx = (sidx1 > sidx2) ? sidx1 : sidx2;
		if ((++sidx) < 0)
			sidx = 0;

		int idx = otherFileName.indexOf(".");

		if (idx != -1) {
			return addSuffix2Tail(fileName,
					"_" + otherFileName.substring(sidx, idx));
		} else {
			return addSuffix2Tail(fileName, "_" + otherFileName.substring(sidx));
		}
	}

	public static String[] split(String str, String separator) {
		StringTokenizer token = new StringTokenizer(str, separator);
		int count = token.countTokens();
		String[] result = null;

		if (count > 0) {
			result = new String[count];
			for (int i = 0; i < result.length && token.hasMoreTokens(); i++) {
				result[i] = token.nextToken();
			}
		}

		return result;
	}

	public static String addPre(String str, char prechar, int length) {
		if (str.length() >= length) {
			return str;
		}

		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < length - str.length(); i++) {
			bf.append(prechar);
		}
		bf.append(str);

		return bf.toString();
	}

	public static String getAbsolute(String dir, String fileName) {
		String targetDir = dir;
		String fileSeparator = System.getProperty("file.separator");
		boolean idx = dir.endsWith("\\");
		if (!idx) {
			dir.endsWith("/");
		}

		if (!idx) {
			targetDir = dir + fileSeparator;
		}
		return targetDir + fileName;
	}

	public static String getDirEndWithSeparator(String dir) {
		String fileSeparator = System.getProperty("file.separator");
		if (dir.endsWith(fileSeparator)) {
			dir = dir.substring(0, dir.length() - 1);
		}

		return dir + fileSeparator;
	}



	public static String getLetterString(String str) {
		str = str.trim();
		StringBuffer sb = new StringBuffer();

		if (str != null) {
			for (int i = 0; i < str.length(); i++) {
				char a = str.charAt(i);

				if (isLetter(a)) {
					sb.append(a);
				} else {
					if (a == ' ') {
						sb.append('_');
					}
				}
			}
		}

		return sb.toString();
	}

	private static boolean isLetter(char a) {
		boolean result = false;

		if (a >= 'a' && a <= 'z') {
			result = true;
		}
		if (a >= 'A' && a <= 'Z') {
			result = true;
		}
		return result;
	}

	public static int comareList(ArrayList<String> a, ArrayList<String> b) {
		StringBuffer sba = new StringBuffer();
		StringBuffer sbb = new StringBuffer();

		for (String str : a) {
			sba.append(str);
		}

		for (String str : b) {
			sbb.append(str);
		}

		return sba.toString().compareTo(sbb.toString());
	}

	public static boolean isBlank(String id) {
		return (id != null && id.trim().length() != 0) ? false : true;
	}

	public static boolean isNotBlank(String value) {
		return !isBlank(value);
	}

	public static String firstCharacterLower(String daoName) {
		if (daoName != null && daoName.trim().length() > 0) {
			String strFirst = daoName.substring(0, 1);
			daoName = strFirst.toLowerCase() + daoName.substring(1);
		}

		return new String(daoName);
	}

	public static String firstCharacterUpper(String daoName) {
		if (daoName != null && daoName.trim().length() > 0) {
			String strFirst = daoName.substring(0, 1);
			daoName = strFirst.toUpperCase() + daoName.substring(1);
		}

		return new String(daoName);
	}

	public static String trim(String source, String trimValue) {
		String str = source.trim();

		if (str.startsWith(trimValue)) {
			str = str.substring(trimValue.length());
		}
		if (str.endsWith(trimValue)) {
			str = str.substring(0, str.length() - trimValue.length());
		}

		return str;
	}

	public static String leftTrim(String source, String trim) {
		String str = source.trim();
		while (str.startsWith(trim)) {
			str = str.substring(trim.length());
		}

		return str;
	}

	public static String arrayToString(List<String> msg) {
		StringBuffer sb = new StringBuffer();

		if (msg != null) {
			for (String str : msg) {
				sb.append(str);
			}
		}
		return sb.toString();
	}

	public static String addLike(String sanctionName) {
		String result = sanctionName;
		if (result != null && result.indexOf("%") < 0) {
			result = "%" + result + "%";
		}
		return result;
	}

	public static String arrayToString(Object... os) {
		StringBuffer sb = new StringBuffer();
		if (os != null) {
			for (Object o : os) {
				if (o != null) {
					sb.append(o.toString());
				}
			}
		}
		return sb.toString();
	}

	public static String arrayToString(String... os) {
		StringBuffer sb = new StringBuffer();
		if (os != null) {
			for (String o : os) {
				if (o != null) {
					sb.append(o);
				}
			}
		}
		return sb.toString();
	}

	public static boolean checkEquals(String str1, String str2) {
		boolean result = false;

		if (str1 != null) {
			result = str1.equals(str2);
		} else if (str1 == null && str2 == null) {
			result = true;
		}

		return result;
	}

	public static boolean checkEquals(BigDecimal b1, BigDecimal b2) {
		boolean result = false;

		if (b1 != null && b2 != null) {
			result = b1.doubleValue() == b2.doubleValue();
			if(!result){
				result = b1.toString().equals(b2.toString());
			}
		} else if (b1 == null && b2 == null) {
			result = true;
		}

		return result;
	}
	
	public static int letter2Int(String letter) {
		int length = letter.length();
		int result = 0;
		for (int i = 0; i < length; i++) {
			int num = letter.charAt(i) - 64;
			result += num * Math.pow(26, length - i - 1);
		}
		return result;
	}

	public static void int2Letter(int sum, StringBuffer sb) {
		int z = sum / 26;
		int y = sum % 26;
		if (y == 0) {
			y = 26;
			z--;
		}
		if (z > 26) {
			sb.insert(0, (char) (y + 64));
			int2Letter(z, sb);
		} else {
			sb.insert(0, (char) (y + 64));
			if (z > 0) {
				sb.insert(0, (char) (z + 64));
			}
		}
	}

	public static int letterIndex(String letter){
		return letter2Int(letter) - 1;
	}
	
	public static String int2Letter(int sum){
		StringBuffer sb = new StringBuffer();
		int2Letter(sum, sb);
		
		return sb.toString();
	}
	
	public static int findCount(String str, String sub){
		int count=0;

		for(int j=0; j<str.length();){
		    int idx = str.indexOf(sub, j);
		    if(idx >=0){
		    	count++;
		    	j = idx + 1;
		    }
		    else{
		    	break;
		    }
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(int2Letter(27));
		System.out.println(letter2Int("AA"));
		System.out.println(letter2Int("aa".toUpperCase()));
	}

	public static boolean checkSQLKeywords(String text) {
		boolean result = false;
		if (text != null) {
			String[] keywords = new String[] { "delete", "update", "select" };
			String lowcaseStr = text.toLowerCase();
			
			for(String key : keywords){
				if(lowcaseStr.contains(key)){
					result = true;
				}
			}
		}
		
		return result;
	}

	public static String getLettterString(String str) {
		// TODO Auto-generated method stub
		
		return null;
	}


}

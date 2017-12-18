package utils;

public class StringUtils {
	//왜 static? 클래스마다 변하지 않을 경우
	public static final String NEWLINE = System.getProperty("line.separator");
	
	private StringUtils() {}
	
	public static StringBuilder appendNewLine(StringBuilder sb) {
		return sb.append(NEWLINE);
	}
}

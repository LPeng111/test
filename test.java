package Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	private static final String TIME_REGEX = "((:|>|\\s)?20[0-9]{2}-(1[0-2]|0?[1-9])-([1-2][0-9]|3[0-1]|0?[1-9])T\\d{1,2}:\\d{1,2}(:\\d{1,2})?(\\.\\d{3})?\\+\\d{1,2}(:)?\\d{2})|((:|>|\\s)?20[0-9]{2}-(1[0-2]|0?[1-9])-([1-2][0-9]|3[0-1]|0?[1-9])T\\d{1,2}:\\d{1,2}(:\\d{1,2})?(\\.\\d{3})?\\-\\d{1,2}(:)?\\d{2})|((:|>|\\s)?20[0-9]{2}-(1[0-2]|0?[1-9])-([1-2][0-9]|3[0-1]|0?[1-9])T\\d{1,2}:\\d{1,2}(:\\d{1,2})?(\\.\\d{3})?Z)|((:|>|\\s)?20[0-9]{2}-(1[0-2]|0?[1-9])-([1-2][0-9]|3[0-1]|0?[1-9])T\\d{1,2}:\\d{1,2}(:\\d{1,2})?(\\.\\d{3})?EDT)|((:|>|\\s)?(Jan(uary)?|Ma(r(ch)?|y)|Apr(il)?|Ju((ly?)|(ne?))|Aug(ust)?|Oct(ober)?|(Sept|Nov|Dec)(ember)?|Feb(ruary)?)\\.?\\,?\\s?(([2|3]?1(st)?)|([2|22](nd)?)|([3|23](rd)?)|([11-13]|([1|2]?[4-9])|([1-3]0)(th)?))\\,?\\s?20[0-9]{2}\\s?\\d{1,2}:\\d{1,2}(:\\d{1,2})?\\s?GMT)|((:|>|\\s)?(([2|3]?1(st)?)|([2|22](nd)?)|([3|23](rd)?)|([11-13]|([1|2]?[4-9])|([1-3]0)(th)?))\\,?\\s?(Jan(uary)?|Ma(r(ch)?|y)|Apr(il)?|Ju((ly?)|(ne?))|Aug(ust)?|Oct(ober)?|(Sept|Nov|Dec)(ember)?|Feb(ruary)?)\\.?\\,?\\s?20[0-9]{2}\\s?\\d{1,2}:\\d{1,2}(:\\d{1,2})?\\s?GMT)|((:|>|\\s)?20[0-9]{2}-(1[0-2]|0?[1-9])-([1-2][0-9]|3[0-1]|0?[1-9])\\s?\\d{1,2}:\\d{1,2}(:\\d{1,2})?(\\.\\d{3})?\\s?(\\+|\\-)\\d{1,2}(:)?\\d{2})|((:|>|\\s)?(Jan(uary)?|Ma(r(ch)?|y)|Apr(il)?|Ju((ly?)|(ne?))|Aug(ust)?|Oct(ober)?|(Sept|Nov|Dec)(ember)?|Feb(ruary)?)\\.?\\,?\\s?(([2|3]?1(st)?)|([2|22](nd)?)|([3|23](rd)?)|([11-13]|([1|2]?[4-9])|([1-3]0)(th)?))\\,?\\s?20[0-9]{2}\\s?\\d{1,2}:\\d{1,2}(:\\d{1,2})?)|((:|>|\\s)?(Jan(uary)?|Ma(r(ch)?|y)|Apr(il)?|Ju((ly?)|(ne?))|Aug(ust)?|Oct(ober)?|(Sept|Nov|Dec)(ember)?|Feb(ruary)?)\\.?\\,?\\s?(([2|3]?1(st)?)|([2|22](nd)?)|([3|23](rd)?)|([11-13]|([1|2]?[4-9])|([1-3]0)(th)?))\\,\\s?20[0-9]{2})|((:|>|\\s)?(([2|3]?1(st)?)|([2|22](nd)?)|([3|23](rd)?)|([11-13]|([1|2]?[4-9])|([1-3]0)(th)?))\\,?\\s?(Jan(uary)?|Ma(r(ch)?|y)|Apr(il)?|Ju((ly?)|(ne?))|Aug(ust)?|Oct(ober)?|(Sept|Nov|Dec)(ember)?|Feb(ruary)?)\\.?\\,?\\s?20[0-9]{2}\\s?\\d{1,2}:\\d{1,2}(:\\d{1,2})?)|((:|>|\\s)?(([2|3]?1(st)?)|([2|22](nd)?)|([3|23](rd)?)|([11-13]|([1|2]?[4-9])|([1-3]0)(th)?))\\,?\\s?(Jan(uary)?|Ma(r(ch)?|y)|Apr(il)?|Ju((ly?)|(ne?))|Aug(ust)?|Oct(ober)?|(Sept|Nov|Dec)(ember)?|Feb(ruary)?)\\.?\\,?\\s?20[0-9]{2})|((:|>|\\s)?20[0-9]{2}(-|\\.|/)(1[0-2]|0?[1-9])(-|\\.|/)([1-2][0-9]|3[0-1]|0?[1-9])\\s?\\d{1,2}:\\d{1,2}(:\\d{1,2})?(\\.\\d{3})?\\s?(AM|PM))|((:|>|\\s)?20[0-9]{2}(-|\\.|/)(1[0-2]|0?[1-9])(-|\\.|/)([1-2][0-9]|3[0-1]|0?[1-9])\\s?\\d{1,2}:\\d{1,2}(:\\d{1,2})?(\\.\\d{3})?)|((:|>|\\s)?20[0-9]{2}(-|\\.|/)(1[0-2]|0?[1-9])(-|\\.|/)([1-2][0-9]|3[0-1]|0?[1-9]))";
	private static Pattern pattern = Pattern.compile(TIME_REGEX);

	public static void main(String[] args) {
		//格式化日期时间对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String str = "<time datetJuly 1, 1859.Ome>\r\n" + 
				"" ;
		
		Matcher m = pattern.matcher(str);
		String matcherStr = null;
		while(m.find()) {
			matcherStr = m.group();
			matcherStr = matcherStr.trim();
			
			if(matcherStr == null) {
				continue;
			}
			
			if(matcherStr.startsWith(":"))
				matcherStr = matcherStr.replaceFirst(":", "");
			
			System.out.println(matcherStr);
			
		}
		if(matcherStr == null)
			System.out.println("找不到呀");
	}

}

package chap3.Hangul;

/**
 * 8859_1 캐릭터 셋으로 이루어진 문자열을 파라미터로 받은 후 캐릭터 셋을 euc-kr로 변경해서
 * 문자열을 리턴해준다.
 */
public class HangulUtil {
    public static String toKor(String eng) {
        try {
            return new String(eng.getBytes("8859_1"), "euc-kr");
        } catch (Exception e) {
            return null;
        }
    }
}

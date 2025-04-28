import StringReverserApp.StringReverserPOA;

public class StringReverserImpl extends StringReverserPOA {
    public String reverse_string(String input_str) {
        return new StringBuilder(input_str).reverse().toString();
    }
}

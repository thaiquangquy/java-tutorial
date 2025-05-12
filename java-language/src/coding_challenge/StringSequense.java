package coding_challenge;

public class StringSequense {
    // giving string "te4st 3a i2s Thi1s", word position is embedded in the string
    // write function takes string above as input and returns the string with correct order
    
    public static String arrangeString(String str) {
        String[] words = str.split(" ");
        String[] completeWords = new String[words.length];
        for(String word : words) {
            int index = 0;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isDigit(c)) {
                    index = c - '0';
                } else {
                    sb.append(c);
                }
            }
            sb.append(" ");
            completeWords[index - 1] = sb.toString();
        }
        StringBuilder resultSB = new StringBuilder();
        for (String word : completeWords) {
            resultSB.append(word);
        }
        
        return resultSB.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(arrangeString("te4st 3a i2s Thi1s"));
        System.out.println(arrangeString("intel5lij 4suggestion 3code tu1rn off2"));
    }
}

class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
						//15的二进制：1111
            int lastDigit = num & 15;
            if (lastDigit < 10) {
                sb.append((char) ('0' + lastDigit));
            } else {
                sb.append((char) ('a' + lastDigit - 10));
            }
						//位运算，对二进制的num右移4位相当于除以16
            num = (num >>> 4);
        }
        
        return sb.reverse().toString();
    }
}

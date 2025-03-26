//Time Complexity - O(n) n - s.length()
//Space Complexity - O(n)
class ValidParanthesis {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && (c == '}' || c == ']' || c == ')')) {
                char sc = stack.peek();
                if (c == '}' && sc != '{') {
                    return false;
                } else if (c == ')' && sc != '(') {
                    return false;
                } else if (c == ']' && sc != '[') {
                    return false;
                }
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.isEmpty() ? true : false;
    }
}

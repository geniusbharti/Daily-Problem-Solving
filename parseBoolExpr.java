class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ',' || ch == '(') {
                // Ignore commas and opening parentheses
                continue;
            }

            if (ch == 't' || ch == 'f') {
                // Push 't' (true) or 'f' (false) to stack
                stack.push(ch);
            } else if (ch == ')') {
                // When encountering a closing parenthesis, pop elements and evaluate
                Set<Character> seen = new HashSet<>();
                while (stack.peek() == 't' || stack.peek() == 'f') {
                    seen.add(stack.pop()); // Collect true/false in the current scope
                }
                
                // Pop the operator, since the current expression is done
                char operator = stack.pop();

                // Evaluate based on the operator
                if (operator == '&') {
                    // AND operator, if all are 't', result is true, otherwise false
                    stack.push(seen.contains('f') ? 'f' : 't');
                } else if (operator == '|') {
                    // OR operator, if any is 't', result is true, otherwise false
                    stack.push(seen.contains('t') ? 't' : 'f');
                } else if (operator == '!') {
                    // NOT operator, negate the only value in seen
                    stack.push(seen.contains('t') ? 'f' : 't');
                }
            } else {
                // Push the operator to the stack ('&', '|', '!')
                stack.push(ch);
            }
        }

        // The result should be the only item left in the stack
        return stack.pop() == 't';
    }
}

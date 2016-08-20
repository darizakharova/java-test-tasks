package calc;

class Evaluate {
    int i;
    String source;
    
    public Evaluate(String s) {
        source = s.replaceAll(" ", "");
    }
    
    public String eval() {
        try {
            i = 0;
            Double x = expression();
            if (i != source.length()) {
                return null;
            }
            return String.format("%.4f",x);
        }
        catch (Throwable e) {
            return null;
        }
    }
    
    private char getChar() {
        return i < source.length() ? source.charAt(i) : 0;
    }
    
    private double number(){ 
        double result = 0;
        while(Character.isDigit(getChar())) {
            result *= 10  ; 
            result += Character.getNumericValue(getChar());
            ++i;
        }        
        if ( getChar() == '.' ) {
            ++i;
            double exp = 0.1;
            while(Character.isDigit(getChar())) {
                result += Character.getNumericValue(getChar()) * exp;
                exp *= 0.1;
                ++i;
            }
        }
        return result;
    }
    
    
    private double expression() {
        double left = term();
        while (true) {
            char binop =  getChar();
            if (!((binop == '+') || (binop == '-'))) {
                break;
            }
            ++i;
            double right = term();
            if (binop == '+') {
                left += right;
            }
            else {
                left -= right;
            }
            
        }    
        return left;
    }
    
    
    private double factor() {
        if (getChar() == '(') {
            ++i;
            double res = expression();
            if (getChar() == ')') {
                ++i;
                return res;
            } 
            else { throw new UnknownError();}
        }
        else if (Character.isDigit(getChar()) ) {
            return number();
        }
        else { throw new UnknownError();}
    }
    
    private double term() {
        double Left = factor();
        while (true) {
            char binop =  getChar();
            if (!((binop == '*') || (binop == '/'))) {
                break;
            }
            ++i;
            double Right = factor();
            if (binop == '*') {
                Left *= Right;
            }
            else {
                Left /= Right;
            }
        }    
        return Left;
    }
}

public class Calc {
    public static void main(String[] args) {
        System.out.println(evaluate("12+4/4")); // 13
        System.out.println(evaluate("7 + 8"));  // 15
        System.out.println(evaluate("12.4 + 17.8 / 2")); //21.3
        System.out.println(evaluate("12( + 4/4")); // null 
        System.out.println(evaluate("3+")); // null
        System.out.println(evaluate("((12.4 + 2.6) / (3) * (2) * ((0.5) + "
                + "(1.5)))")); // 20
        System.out.println(evaluate("5 / 3")); // 1.6667
        System.out.println(evaluate("grege")); // null
    }
    static String evaluate(String str) {
        Evaluate s = new Evaluate(str);
        return(s.eval());
    }
}

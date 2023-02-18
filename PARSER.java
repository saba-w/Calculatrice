public class PARSER {
    private static String src;
    private static int idx;

    private static char last_char;
    private static int last_cst;

    private static boolean read_char(char c) {
        if ((idx < src.length()) && (src.charAt(idx) == c)) {
            idx++;
            last_char = c;
            System.out.println("Read " + last_char);
            return true;
        }
        return false;
    }

    private static boolean read_cst() {
        boolean flag = false;
        while ((idx < src.length()) && (src.charAt(idx) >= '0')
                && (src.charAt(idx) <= '9')) {
            last_cst *= 10;
            last_cst += src.charAt(idx) - '0';
            System.out.println("Read " + last_cst);
            idx++;
            flag = true;
        }
        return flag;
    }

    private static EXPR read_e() {
        EXPR result, right;
        char op;
        result = read_e_mul();
        if (result != null) {
            while (read_char('+') || read_char('-')) {
                op = last_char;
                right = read_e_mul();
                if (right == null) error("RIGHT EXPR IS NULL WHEN READ_E()");
                if (op == '+') {
                    System.out.println("ADD OK");
                    result = new ADD(result, right);
                }
                if (op == '-') {
                    System.out.println("SUB OK");
                    result = new SUB(result, right);
                }
            }
        }
        return result;
    }

    private static EXPR read_e_mul() {
        EXPR result, right;
        char op;
        result = read_e_unary();
        if (result != null) {
            while (read_char('*') || read_char('/')) {
                op = last_char;
                right = read_e_mul();
                if (right == null) error("RIGHT EXPR IS NULL WHEN read_e_mul()");
                if (op == '*') {
                    System.out.println("MUL OK");
                    result = new MUL(result, right);
                }
                if (op == '/') {
                    System.out.println("DIV OK");
                    result = new DIV(result, right);
                }
            }
        }
        return result;
    }

    private static EXPR read_e_unary() {
        EXPR result;
        char op;
        result = read_e_cst();
        if (result == null) {
            if (read_char('+') || read_char('-')) {
                result = read_e_cst();
                op = last_char;
                if (op == '-') {
                    System.out.println("NEG OK");
                    result = new NEG(result);
                }
                if (op == '+') {
                    System.out.println("NEUTRAL OK");
                    result = new NEUTRAL(result);
                }
            }
        }
        return result;
    }

    private static CST read_e_cst() {
        CST result;
        if (read_cst() == true) {
            result = new CST(last_cst);
            last_cst = 0;
            return result;
        } else
            return null;
    }

    private static void error(String error) {
        int j;
        System.out.println(src);
        for (j = 0; j < idx; j++) {
            System.out.print(' ');
        }
        System.err.println(error);
        System.exit(1);
    }

    static EXPR parse_on(String txt) {
        EXPR e;
        src = txt;
        idx = 0;
        e = read_e();
        if ((e == null) || (idx < src.length()))
			error("EXPR IS NULL");
        return e;
    }
}

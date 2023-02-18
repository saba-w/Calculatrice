public class DIV extends EXPR_BINARY {
    DIV(EXPR l, EXPR r){
        left = l;
        right = r;
    }

    int eval(){
        return left.eval() / right.eval();
    }
}

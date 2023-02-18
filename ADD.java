public class ADD extends EXPR_BINARY {
    ADD(EXPR l, EXPR r){
        left = l;
        right = r;
    }
    int eval(){
        return left.eval() + right.eval();
    }
}

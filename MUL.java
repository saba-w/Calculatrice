public class MUL extends EXPR_BINARY{
    MUL(EXPR l, EXPR r){
        left = l;
        right = r;
    }

    int eval(){
        return left.eval() * right.eval();
    }
}

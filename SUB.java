public class SUB extends EXPR_BINARY{
    SUB(EXPR l, EXPR r){
        left = l;
        right = r;
    }

    int eval(){
        return left.eval() - right.eval();
    }
}

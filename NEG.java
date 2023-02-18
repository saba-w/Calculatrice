public class NEG extends EXPR_UNARY{

    public NEG(EXPR r){
        result = r;
    }

    @Override
    int eval(){
        return -result.eval();
    }
}

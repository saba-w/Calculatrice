public class NEUTRAL extends EXPR_UNARY {

    public NEUTRAL(EXPR r){
        result = r;
    }

    @Override
    int eval(){
        return result.eval();
    }
}

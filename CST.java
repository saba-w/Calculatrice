public class CST extends EXPR{
    int value;

    CST(int v){
        value = v;
    }
    int eval(){
        return value;
    }
}

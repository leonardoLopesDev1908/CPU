public class Alu {

    private static boolean zeroFlag;
    private static boolean overFlowFlag;
    private static boolean signalFlag;

    public Alu(){
        zeroFlag = false;
        overFlowFlag = false;
        signalFlag = false;
    }

    public static int operate(InstructionSet inst, int src1, int src2){
        int result;
        resetFlags();

        switch (inst) {
            case InstructionSet.ADD -> {
                result = src1 + src2;
                if(result > 2.147483647 || result < -2147483648){
                    overFlowFlag = true;
                }
                if(result < 0){
                    signalFlag = true;
                }
                if(result == 0){
                    zeroFlag = true;
                }
                return result;
            }
            case InstructionSet.SUB -> {
                result = src1 - src2;
                if(result > 2.147483647 || result < -2147483648){
                    overFlowFlag = true;
                }
                if(result < 0){
                    signalFlag = true;
                }
                if(result == 0){
                    zeroFlag = true;
                }
                return result;
            }
            default -> {
                throw new AssertionError();
            }
        }
    }

    private static void resetFlags(){
        Alu.zeroFlag = false;
        Alu.signalFlag = false;
        Alu.overFlowFlag = false;
    }
}

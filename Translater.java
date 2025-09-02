public class Translater {

    public String intToBinary(int integer){
        return Integer.toBinaryString(integer);
    }

    public int binaryToInt(String binary){
        int integer = 0;

        for(int i = 0; i < binary.length(); i++){
            int current = Integer.parseInt(binary);
            integer += Math.pow(current, i);    
        }
        return integer;
    }

    public String intToHex(int integer){
        return Integer.toHexString(integer);
    }
}


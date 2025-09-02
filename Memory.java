import java.util.Random;

public class Memory{
    private int[] memory;
    private Random random;

    public Memory(){
        random = new Random();
        fillMemory();
    }

    public int readMemory(int address){
        return memory[address];
    }

    public void writeMemory(int address, int newValue){
        memory[address] = newValue;
    }

    private void fillMemory(){
        memory = new int[16];
        for(int i = 0; i < 16; i++){
            memory[i] = random.nextInt();
        }
    }

    protected void seeMemory(){
        System.out.println("----------Memory---------");
        for(int i = 0; i < memory.length; i++){
            System.out.print("|  ");
            System.out.printf("0x%03X", i);
            System.out.print(" |  ");
            System.out.printf("0x%08X", memory[i]);
            System.out.print("  |");
            System.out.println();
            System.out.print("------------------------");
            System.out.println();
        }
    }
}

class Main{
    public static void main(String[] args) {
        Memory memory = new Memory();

        memory.seeMemory();
        // Translater t = new Translater();
        // System.out.println(t.intToBinary(13));
        // System.out.println(t.binaryToInt("1010"));
    }
}
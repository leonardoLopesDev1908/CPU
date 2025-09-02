
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cpu{

    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readMemory = lock.readLock();
    Lock writeMemory = lock.writeLock();

    private RegisterFile registerFile;
    private Alu alu;
    private DataMemory dataMemory;
    private int programCounter;

    private Memory memory;
    
    private boolean zeroFlag;
    private boolean overFlowFlag;
    private boolean signalFlag;
    
    public Cpu(){
        programCounter = 0;
        zeroFlag = false;
        overFlowFlag = false;
        signalFlag = false;
    }

    public void fetch(){
        try{
            readMemory.lock();
            int instruction = memory.readMemory(programCounter);
            int opcode = (instruction >> 26) & 0x3F;
            int instr = instruction & 0x3FFFFFF;
            decode(opcode, instr);
        }finally{
            readMemory.unlock();
        }
    }
    
    public void decode(int opcode, int instruction){
        int funct, shamt, vl1, vl2, vl3;

        switch (opcode) {
            case 0 -> {
                //R-Type
                int rs = (instruction >> 21) & 0x1F;
                int rt = (instruction >> 16) & 0x1F;
                int rd = (instruction >> 11) & 0x1F;
                shamt = (instruction >> 6) & 0x1F;
                funct = instruction & 0x3F;

                vl1 = registerFile.readRegisterValue(rs);
                vl2 = registerFile.readRegisterValue(rt);
                vl3 = registerFile.readRegisterValue(rd);

                execute(funct, shamt, vl1, vl2, vl3);
            }
            case 2, 3 -> {
                //J-Type
                int address = (instruction & 0x3FFFFFF) % 16;
                execute(opcode, 0, address, 0, 0);
            }
            default -> {
                //I-Type
                int rs = (instruction >> 21) & 0x1F;
                int rt = (instruction >> 16) & 0x1F;
                int immediate = instruction & 0xFFFF;

                vl1 = registerFile.readRegisterValue(rs);
                vl2 = registerFile.readRegisterValue(rt);

                execute(opcode, 0, vl1, vl2, immediate);
            }
        }
    }
    
    public void execute(int funct, int shamt, int a, int b, int c){
        try {
            writeMemory.lock();
            switch(funct){
                case 0x0001 -> {

                    break;
                }
                case 0x0010-> {
                  
                    break;
                }
                case 0x0011-> {
                   
                    break;
                }
                case 0x0100-> {
                   
                    break;
                }
                case 0x0101-> {
                 
                    break;
                }
                case 0x0111-> {
                    
                    break;
                }
                default -> {
                    throw new IllegalArgumentException("Invalid instruction");
                }
            }
        } finally {
            writeMemory.unlock();
        }
    }
    
    public void dataMemory(){
        try {
            writeMemory.lock();




        } finally{
            writeMemory.unlock();
        }
    }
    
    public void writeBack(){
        try {
            writeMemory.lock();
            
        } catch (Exception e) {
        }
    }
    
    public void incrementPc(){
        programCounter++;
    }
    
}
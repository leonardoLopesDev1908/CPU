
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class RegisterFile{
    private HashMap<String, Integer> registers = new HashMap<>();
    private List<String> registersList = new ArrayList<>();

    public RegisterFile(){
        fillRegisterFile();
    }

    public HashMap<String, Integer> getRegisters(List<String> registerNames){
        HashMap<String, Integer> fetchedRegisters = new HashMap<>();
        for(int i = 0; i < registerNames.size(); i++){
            String register = registerNames.get(i);
            if(registers.containsKey(register)){
                fetchedRegisters.put(register, registers.get(register));
            }
        }
        return fetchedRegisters;
    }

    public int readRegisterValue(int rX){
        String register = registersList.get(rX);
        return registers.get(register);
    }

    public void writeRegisterValue(int rX, int value){
        String register = registersList.get(rX);
        registers.put(register, value);
    }

    private void fillRegisterFile(){
        registers.put("%rax", 0x00000000);
        registers.put("%eax", 0x00000000);
        registers.put("%ebp", 0x00000000);
        registers.put("%ebx", 0x00000000);
        registers.put("%esp", 0x00000000);
        registers.put("%bsp", 0x00000000);
        registers.put("%rbp", 0x00000000);

        registersList = registers.keySet().stream().collect(Collectors.toList());
    }
}
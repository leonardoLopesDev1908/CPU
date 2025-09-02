//     HashMap<Integer, String> instructions = new HashMap<>();

//     public InstructionSet(){
//         fillInstruction();
//     }

//     private void fillInstruction(){
//         instructions.put(0x01, "ADD");
//         instructions.put(0x02, "SUB");
//         instructions.put(0x03, "MOV");
//         instructions.put(0x04, "IMULL");
//         instructions.put(0x05, "JE");
//         instructions.put(0x06, "JZ");
//         instructions.put(0x07, "JS");
//         instructions.put(0x08, "JMP");
//         instructions.put(0x09, "LEAL");
//         instructions.put(0x0A, "");
//     }
// }

public enum InstructionSet {
    ADD, SUB, MOV, IMULL, /*JE, JZ, JS, JMP,*/ LEAL, STR
}

/*
 * ADD = 0x0001
 * SUB = 0x0010
 * MOV = 0x0011
 * IMULL = 0x0100
 * JE = 0x0101
 * JZ = 0x0110
 * JS = 0x0111
 * JMP = 0x1000
 * LD = 0x1001
 * STR = 0x1010
 */
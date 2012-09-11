package com.jclarity.anim.memory;

/**
 * The point of this class is to allocate a predictable amount of memory.
 * We should allocate twice as much as we free.
 * 
 * So the class should return ALLOC ALLOC FREE (repeat)
 * 
 */
class MemoryPatternMaker implements IMemoryInterpreter {

    private volatile int seq = 1;
    
    private volatile int alloc_seq = 0;
    
    private volatile int free_seq = 0;
    
    public MemoryPatternMaker() {
    }

    @Override
    public MemoryInstruction getNextStep() {
        seq++;
        
        if ((seq % 5 == 0) || (seq % 5 == 3)) {
            return new MemoryInstruction(OpCode.KILL, free_seq++);
        } else {
            return new MemoryInstruction(OpCode.ALLOC, alloc_seq++);
        }
        
    }

}
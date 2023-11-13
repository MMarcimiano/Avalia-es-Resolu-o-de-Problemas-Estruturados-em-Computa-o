/**
 *
 * @author mateu
 */
public class HashMapFNV1 extends HashMap {

    public HashMapFNV1(int size) {
        super(size);
    }

    @Override
    public int hash(int value) {
        final int FNV_PRIME = 16777619;
        final long FNV_OFFSET_BASIS = 2166136261L; // Use long em vez de int
        
        int hash = (int) FNV_OFFSET_BASIS; // Converter de long para int
        
        while (value != 0) {
            hash ^= (value & 0xFF);
            hash *= FNV_PRIME;
            value >>>= 8;
        }
        
        return hash;
    }
}



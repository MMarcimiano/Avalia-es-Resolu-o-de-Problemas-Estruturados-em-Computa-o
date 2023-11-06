/**
 *
 * @author mateu
 */
public class HashMapMultiplicao extends HashMap {

	public HashMapMultiplicao(int size) {
		super(size);
	}

	@Override
	public int hash(int value) {
        return value * 5381;
	}

}

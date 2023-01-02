package eviction;

// eviction package having method for evication rules
public interface Rules<Key> {

    // having latest key used
	void keyUsed(Key key);

	// tells about key we have to remove
    Key removeKey();
}

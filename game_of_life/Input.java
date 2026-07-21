
/**
 * 
 */
public class Input<T> {
    private final T value;
    
    Input(T value) {
        this.value = value;
    }
    
    T value() {
        return value;
    }
}
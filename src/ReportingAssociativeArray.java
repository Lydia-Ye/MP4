import java.io.PrintWriter;
import structures.AssociativeArray;
import structures.KeyNotFoundException;

/**
 * An extension of the AssociativeArray class that reports each
 * step it takes.
 *
 * @author Samuel A. Rebelsky
 */
public class ReportingAssociativeArray<K,V> extends AssociativeArray<K,V> {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The "name" of this associative array (at least as reported to the user).
   */
  String name;

  /**
   * Where we print reports.
   */
  PrintWriter pen;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new ReportingAssociativeArray named `name` that 
   * prints reports of all actions using `pen`.
   */
  public ReportingAssociativeArray(String name, PrintWriter pen) {
    super();
    this.name = name;
    this.pen = pen;
  } // ReportingAssociativeArray

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Set a value.
   */
  public void set(K key, V value) {
    pen.println(name + ".set(" + key + ", " + value + ")");
    super.set(key, value);
    pen.println("  " + name + ": " + this.toString());
  } // set (K,V)

  /**
   * Get the value associated with key.
   *
   * @throws KeyNotFoundException
   *   when the key does not appear in the associative array.
   */
  public V get(K key) throws KeyNotFoundException {
    pen.print(name + ".get(" + key + ") = ");
    pen.flush();
    try {
      V value = super.get(key);
      pen.println(value);
      return value;
    } catch (KeyNotFoundException knfe) {
      pen.println("** ERROR **");
      throw knfe;
    } // try/catch
  } // get(K)

  /**
   * Determine if key appears in the associative array.
   */
  public boolean hasKey(K key) {
    pen.print(name + ".hasKey(" + key + ") = ");
    pen.flush();
    boolean result = super.hasKey(key);
    pen.println(result);
    return result;
  } // hasKey(K)

  /**
   * Remove the key/value pair associated with a key.  Future calls
   * to get(key) will throw an exception.  If the key does not appear
   * in the associative array, does nothing.
   */
  public void remove(K key) {
    pen.println(name + ".remove(" + key + ")");
    super.remove(key);
    pen.println("  " + name + ": " + this.toString());
  } // remove(K)

  /**
   * Determine how many values are in the associative array.
   */
  public int size() {
    pen.print(name + ".size() = ");
    int size = super.size();    // No, not your soda
    pen.println(size);
    return size;
  } // size()
} // ReportingAssociativeArray

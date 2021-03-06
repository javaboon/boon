package org.boon;


/**
 * This is more for documentation then actually using.
 * Nothing will likely implement this.
 * It is more conceptional.
 *
 * There are examples in the documentation.
 *
 * The following is a basis for many of the examples.
 *
 * <blockquote>
 * <pre>
 *
 *
 //Works with lists, arrays, sets, maps, sorted maps, etc.
 List<String> fruitList;
 String [] fruitArray;
 Set<String> veggiesSet;
 char [] letters;
 byte [] bytes;
 NavigableMap <Integer, String> favoritesMap;
 Map<String, Integer> map;

 // These helper methods are used to create common Java types.
 // Sets and lists have concurrent and non concurrent variants
 // Set also has sorted and non sorted variants
 // This makes safeList, listStream, set, sortedSet, safeSet, safeSortedSet
 veggiesSet  =  set( "salad", "broccoli", "spinach");
 fruitList   =  listStream( "apple", "oranges", "pineapple");
 fruitArray  =  array( "apple", "oranges", "pineapple");
 letters     =  array( 'a', 'b', 'c');
 bytes       =  array( new byte[]{0x1, 0x2, 0x3, 0x4});

 //You add up name / value pairs as a pseudo literal for map
 favoritesMap = sortedMap(
        2, "pineapple",
        1, "oranges",
        3, "apple"
 );


 // You add up name / value pairs as a pseudo literal for map
 // map, sortedMap, safeMap (thread safe concurrent), and sortedSafeMap are
 // supported.
 map =    map (
        "pineapple",  2,
        "oranges",    1,
        "apple",      3
 );


 * </pre>
 * </blockquote>
 */
public interface UniversalOperations <ITEM, INDEX> {

    public enum Returns {
         VARIES
    };

    /**
     * Get the item at the index.
     * This works with Maps, TreeSets, Strings, Object arrays, primitive arrays,
     * etc.
     *
     * Implemented by:
     * <pre>
     * org.boon.primitive.Byt
     * org.boon.primitive.Chr
     * org.boon.primitive.Int (in progress)
     * org.boon.primitive.Lng (in progress)
     * org.boon.Arrays
     * org.boon.core.Strings (planned)
     * org.boon.core.StrBuf (planned)
     * org.boon.Lists
     * org.boon.Maps
     * org.boon.Sets
     * </pre>
     *
     * Works with maps and sets
     *
     * <pre>
     *     Map<String,Dog> dogMap; //map of dogs
     *
     *     Dog dog = new Dog("dog");
     *
     *     NavigableSet<String> set; //set of strings
     *
     *     List<String> listStream;
     *
     *     char[] letters;
     *
     *
     *
     * </pre>
     * Initialize our examples
     *  <pre>
     *        dogMap = map("dog", dog);
     *        set = sortedSet("apple", "kiwi", "oranges", "pears", "pineapple");
     *        listStream = listStream("apple", "oranges", "pears");
     *        letters = array('a', 'b', 'c', 'd');
     *
     * </pre>
     *        The methods map, listStream, sortedSet, arrays
     *        are utility methods for creating Maps, lists sets, etc.
     * <br />
     *
     * Using
     * <pre>
     *
     *              //Get the dog at the index "dog" in the map
     *              assertEquals(
     *
     *                  dog, idx(dogMap, "dog")
     *
     *              );
     *
     *              //Get the string "oranges" at index "ora"
     *              assertEquals(
     *
     *                  "oranges",
     *                  idx(set, "ora")
     *
     *              );
     *
     *              //Get the string "oranges" at index "o"
     *              assertEquals(
     *
     *                  "oranges",
     *                  idx(set, "o")
     *
     *               );
     *
     *               //Get the string "oranges" at index 1 of the listStream.
     *               assertEquals(
     *                   "oranges",
     *                   idx(listStream, 1)
     *               );
     *
     *               // Get the string "pears" at index -1 (using Python style slice notation)
     *               // of the listStream.
     *               assertEquals(
     *                   "pears",
     *                   idx(listStream, -1)
     *                );
     *
     *               //oranges are two from the back
     *               assertEquals(
     *               "oranges",
     *               idx(listStream, -2));
     *
     *
     *               //apple are two from the back
     *               assertEquals(
     *               "apple",
     *               idx(listStream, -3));
     *
     *
     *
     * </pre>
     *
     * Based on the example at top {@link UniversalOperations}:
     * <blockquote>
     * <pre>
     *
     //Using idx to access a value.

     assert idx( veggiesSet, "b").equals("broccoli");

     assert idx( fruitList, 1 ).equals("oranges");

     assert idx( fruitArray, 1 ).equals("oranges");

     assert idx( letters, 1 ) == 'b';

     assert idx( bytes, 1 )      == 0x2;

     assert idx( favoritesMap, 2 ).equals("pineapple");

     assert idx( map, "pineapple" )  == 2;

     </pre>
     </blockquote>

     * Negative index works with listStream like, array like things.
     *
     * <blockquote>
     * <pre>
     *
     *          //Negative indexes
     *
     *          assert idx( fruitList, -2 ).equals("oranges");
     *
     *          assert idx( fruitArray, -2 ).equals("oranges");
     *
     *          assert idx( letters, -2 ) == 'b';
     *
     *          assert idx( bytes, -3 )   == 0x2;
     * </pre>
     * </blockquote>
     * @see org.boon.primitive.Byt
     * @see org.boon.primitive.Chr
     * @see org.boon.primitive.Int
     * @see Arrays
     * @see Lists
     * @see Maps
     *
     * @see Sets#idx(java.util.NavigableSet, Object)
     * @see org.boon.primitive.Byt#idx(byte[], int)
     * @see org.boon.primitive.Chr#idx(char[], int)
     * @see org.boon.primitive.Int
     * @see Arrays#idx(Object[], int)
     * @see Lists
     * @see Maps
     * @see Sets
     *
     *
     *
     * @param index the index of the item
     * @return the item at the index
     */
    ITEM idx(INDEX index);

    /**
     * Sets the value at an index.
     *
     * @param index index
     * @param item  item you are setting
     */
    void idx(INDEX index, ITEM item);

    /**
     * Gets the length
     * This works with Maps, TreeSets, Strings, Object arrays, primitive arrays,
     * etc.
     *
     *
     * <br />
     * Building from the example at top ({@link UniversalOperations}).
     * <blockquote>
     * <pre>

     // Getting the length
     assert len( veggiesSet )        == 3;
     assert len( fruitList )         == 3;
     assert len( fruitArray )        == 3;
     assert len( letters )           == 3;
     assert len( bytes )             == 4;
     assert len( favoritesMap )      == 3;
     assert len( map )               == 3;



     * </pre>
     * </blockquote>
     *
     * Implemented by:
     * <pre>
     * org.boon.primitive.Byt
     * org.boon.primitive.Chr
     * org.boon.primitive.Int (in progress)
     * org.boon.primitive.Lng (in progress)
     * org.boon.Arrays
     * org.boon.core.Strings (planned)
     * org.boon.core.StrBuf (planned)
     * org.boon.Lists
     * org.boon.Maps
     * org.boon.Sets
     * </pre>
     *
     * @see org.boon.primitive.Byt
     * @see org.boon.primitive.Chr
     * @see org.boon.primitive.Int
     * @see Arrays
     * @see Lists
     * @see Maps
     * @see Sets
     *
     *
     * @return the length
     */
     int len();



    /**
     * Adds something to a collection, map or array
     *
     * For maps you add an entry
     *
     *
     * Implemented by:
     * <pre>
     * org.boon.primitive.Byt
     * org.boon.primitive.Chr
     * org.boon.primitive.Int (in progress)
     * org.boon.primitive.Lng (in progress)
     * org.boon.Arrays
     * org.boon.core.Strings (planned)
     * org.boon.core.StrBuf (planned)
     * org.boon.Lists
     * org.boon.Maps
     * org.boon.Sets
     * </pre>
     *
     * @see org.boon.primitive.Byt
     * @see org.boon.primitive.Chr
     * @see org.boon.primitive.Int
     * @see Arrays
     * @see Lists
     * @see Maps
     * @see Sets
     *
     *
     * @return for arrays, this will return the new array,
     * for all other collection like things, it returns void.
     */
    Returns add(ITEM item);




    /**
     * Copies something.
     * This does a shallow copy.
     * There will be a clone that does a deep invasive copy.
     *
     *
     *
     * Implemented by:
     * <pre>
     * org.boon.primitive.Byt
     * org.boon.primitive.Chr
     * org.boon.primitive.Int (in progress)
     * org.boon.primitive.Lng (in progress)
     * org.boon.Arrays
     * org.boon.core.Strings (planned)
     * org.boon.core.StrBuf (planned)
     * org.boon.Lists
     * org.boon.Maps
     * org.boon.Sets
     * </pre>
     *
     * @see org.boon.primitive.Byt
     * @see org.boon.primitive.Chr
     * @see org.boon.primitive.Int
     * @see Arrays
     * @see Lists
     * @see Maps
     * @see Sets
     *
     *
     * @return the copied object
     */
    UniversalOperations copy(UniversalOperations thing);



    /**
     * NOT IMPLEMENTED YET.
     * Clone does a deep recursive copy.
     *
     *
     *
     * Implemented by:
     * <pre>
     * org.boon.primitive.Byt
     * org.boon.primitive.Chr
     * org.boon.primitive.Int (in progress)
     * org.boon.primitive.Lng (in progress)
     * org.boon.Arrays
     * org.boon.core.Strings (planned)
     * org.boon.core.StrBuf (planned)
     * org.boon.Lists
     * org.boon.Maps
     * org.boon.Sets
     * </pre>
     *
     * @see org.boon.primitive.Byt
     * @see org.boon.primitive.Chr
     * @see org.boon.primitive.Int
     * @see Arrays
     * @see Lists
     * @see Maps
     * @see Sets
     *
     *
     * @return the length
     */
    UniversalOperations clone(UniversalOperations thing);




    /**
     *
     *  This does not work with Sets or Maps (use idx for those)
     *
     * Implemented by:
     * <pre>
     * org.boon.primitive.Byt
     * org.boon.primitive.Chr
     * org.boon.primitive.Int (in progress)
     * org.boon.primitive.Lng (in progress)
     * org.boon.Arrays
     * org.boon.core.Strings (planned)
     * org.boon.core.StrBuf (planned)
     * org.boon.Lists
     * </pre>
     *
     * @see org.boon.primitive.Byt
     * @see org.boon.primitive.Chr
     * @see org.boon.primitive.Int
     * @see Arrays
     * @see Lists
     * @see Maps
     * @see Sets

     * @see org.boon.primitive.Byt#insert
     * @see org.boon.primitive.Chr#insert
     * @see org.boon.primitive.Int
     * @see Arrays#insert
     * @see Lists#insert
     *
     */
    void insert(ITEM item);


    /**
     *  Slice a string, array, TreeSet, or TreeMap.
     *  Works like python slice notation
     *
     * <pre>
     *     >>> string [0:3]
     *     'foo'
     *     >>> string [-3:7]
     *     'bar'
     * </pre>
     *
     * What follows is derived from
     * <a href="http://stackoverflow.com/questions/509211/pythons-slice-notation">
     * Python's slice notation
     * </a>.
     *
     * <br /> <br />
     * It's pretty simple really (Python):
     * <pre>
     *
     *      a[ start : end ] # items start through end-1
     *      a[ start : ]     # items start through the rest of the array
     *      a[ : end ]       # items from the beginning through end-1
     *      a[ : ]           # a copy of the whole array
     *
     * </pre>
     *
     * Boon would be  (Java):
     * <pre>
     *
     *      slc( a, start, end ) // items start through end-1
     *      slc( a, start )      // items start through the rest of the array
     *      slcEnd( a, end )     // items from the beginning through end-1
     *      copy( a )            // a copy of the whole array
     * </pre>
     *
     * NOT IMPLEMENTED YET: <br />
     *
     * There is also the step value, which can be used with any of the above:
     *
     * <br />
     * Python
     * <pre>
     *
     *      a[ start : end : step] # start through not past end, by step
     *
     * </pre>
     * Boon
     * <pre>
     *
     *      slc(a, start , end, step) // start through not past end, by step
     *
     * </pre>
     * The key point to remember is that the :end value represents the
     * first value that is not in the selected slice. So, the difference
     * between end and start is the number of elements selected
     * (if step is 1, the default).
     * <br />
     * The other feature is that start or end may be a
     * negative number, which means it counts from the end of the
     * array instead of the beginning. So:
     *
     * <br/>
     * Python slice notation
     * <pre>
     *          a[ -1 ]    # last item in the array
     *          a[ -2: ]   # last two items in the array
     *          a[ :-2 ]   # everything except the last two items
     * </pre>
     * Boon slice notation
     * <pre>
     *          slc( a, -1)     # last item in the array
     *          slc( -2 )       # last two items in the array
     *          slcEnd( -2 )    # everything except the last two items
     * </pre>
     *
     * Python and boon are kind to the programmer
     * if there are fewer items than you ask for.
     * For example, if you ask for a[:-2] and a only contains one element,
     * you get an empty listStream instead of an error.
     * Sometimes you would prefer the error, so you have to
     * be aware that this may happen.
     *
     * Implemented by:
     * <pre>
     *
     * org.boon.primitive.Byt
     * org.boon.primitive.Chr
     * org.boon.primitive.Int (in progress)
     * org.boon.primitive.Lng (in progress)
     * org.boon.Arrays
     * org.boon.core.Strings (planned)
     * org.boon.core.StrBuf (planned)
     * org.boon.Lists
     * </pre>
     *
     * @see org.boon.primitive.Byt
     * @see org.boon.primitive.Chr
     * @see org.boon.primitive.Int
     * @see Arrays
     * @see Lists
     * @see Maps
     * @see Sets
     *
     * @see org.boon.primitive.Byt#slc
     * @see org.boon.primitive.Chr#slc
     * @see org.boon.primitive.Int
     * @see Arrays#slc
     * @see Lists#slc
     * @see Maps#slc
     * @see Sets#slc

     *
     */
    void slc(INDEX start, INDEX end);

    /**
     *
     * @see UniversalOperations#slc(Object, Object)
     *
     * @param start index start
     */
    void slc(INDEX start);

    /**
     * @see UniversalOperations#slc(Object, Object)
     *
     * @param end index end
     */
    void slcEnd(INDEX end);



}

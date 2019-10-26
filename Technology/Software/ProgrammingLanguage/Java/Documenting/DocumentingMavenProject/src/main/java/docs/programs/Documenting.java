package docs.programs;

/**
 * Describes how to properly document a class. <br>
 * 
 * since _version  : When this part of the program was first added.  <br>
 * version _version: Current version of the program.  <br>
 * author _name    : Name (and contact information such as email) of the author(s).  <br>
 * 
 * @since 0.9.0
 * @version 1.0.0
 * @author I am the Author!
 */
public class Documenting {

    /**
     * A sample method that adds two numbers. <br>
     * 
     * param _name _desc    : For describing the different parameters for a method.  <br>
     * return _desc         : For describing what the method returns.  <br>
     * exception _name _desc: For describing exceptions.  <br>
     * see _construct       : For linking to another part of the documentation or a website.  
     * 
     * @param a Any integer.
     * @param b Any integer except zero.
     * @return A float, a result of the division.
     * @exception ArithmeticException If b is zero.
     * @see <a href="https:// docs.oracle.com/javase/8/docs/api/">Java 8 API</a>
     * @see docs.programs.Documenting#Division(float, float)
     */
    public float Division(int a, int b) {
        return a / b;
    }
    
    public float Division(float a, float b) {
        return a / b;
    }
    /*
    * Other javadoc keywords: <br>
    * @deprecated _version: For showing the code is outdated or shouldn't be used.  
    */
}

/**
 * Main class demonstrating the use of RSA encryption and decryption with the
 * GestorCifradoRSA class.
 */
public class Main {

    /**
     * Main method that runs when the program starts.
     * 
     * @param args Command-line arguments (not used in this program).
     * @throws Exception Propagates any exception thrown during encryption,
     *                   decryption, or the initialization of the RSA manager.
     */
    public static void main(String[] args) throws Exception {
        // Create an instance of GestorCifradoRSA, which handles RSA encryption and
        // decryption.
        GestorCifradoRSA gestor = new GestorCifradoRSA();

        // Encrypt the message "hola" using the RSA public key.
        // Converts the string "hola" to bytes and then encrypts it.
        byte[] bufferCifrado = gestor.cifrar("hola".getBytes(), gestor.getPublica());

        // Display the encrypted bytes in the console to verify the encryption result.
        gestor.mostrarBytes(bufferCifrado);

        // Decrypt the encrypted message using the RSA private key.
        byte[] bufferClaro = gestor.descifrar(bufferCifrado, gestor.getPrivada());

        // Display the decrypted bytes in the console to verify that the decryption was
        // successful
        // and that the original message matches the decrypted output.
        gestor.mostrarBytes(bufferClaro);
    }
}

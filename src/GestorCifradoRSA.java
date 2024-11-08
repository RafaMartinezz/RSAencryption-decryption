import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Class GestorCifradoRSA manages RSA encryption and decryption of data.
 * It generates a public-private key pair using the RSA algorithm and
 * performs encryption and decryption using these keys.
 */
public class GestorCifradoRSA {
    // RSA key pair for encryption and decryption
    private KeyPair claves;
    // Key pair generator for RSA
    private KeyPairGenerator generadorClaves;
    // Cipher object for encryption and decryption
    private Cipher cifrador;

    /**
     * Constructor for GestorCifradoRSA that initializes the key generator and
     * cipher.
     *
     * @throws NoSuchAlgorithmException if the RSA algorithm is not available.
     * @throws NoSuchPaddingException   if the specified padding is not available.
     */
    public GestorCifradoRSA() throws NoSuchAlgorithmException, NoSuchPaddingException {
        // Initialize the RSA key pair generator
        this.generadorClaves = KeyPairGenerator.getInstance("RSA");
        this.generadorClaves.initialize(1024); // Set the key size to 1024 bits
        this.claves = this.generadorClaves.generateKeyPair(); // Generate the key pair
        // Initialize the Cipher for RSA encryption/decryption
        cifrador = Cipher.getInstance("RSA");
    }

    /**
     * Returns the public key from the RSA key pair.
     *
     * @return PublicKey RSA public key.
     */
    public PublicKey getPublica() {
        return this.claves.getPublic();
    }

    /**
     * Returns the private key from the RSA key pair.
     *
     * @return PrivateKey RSA private key.
     */
    public PrivateKey getPrivada() {
        return this.claves.getPrivate();
    }

    /**
     * Encrypts data using the provided key.
     *
     * @param paraCifrar   Data to be encrypted.
     * @param claveCifrado Key to be used for encryption.
     * @return Encrypted data as a byte array.
     * @throws InvalidKeyException       if the key is invalid for RSA encryption.
     * @throws IllegalBlockSizeException if the block size is not suitable for RSA.
     * @throws BadPaddingException       if there is a padding issue with the data.
     */
    public byte[] cifrar(byte[] paraCifrar, Key claveCifrado)
            throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // Initialize the cipher in encryption mode with the provided key
        cifrador.init(Cipher.ENCRYPT_MODE, claveCifrado);
        // Encrypt the data
        byte[] bytesCifrados = cifrador.doFinal(paraCifrar);
        return bytesCifrados;
    }

    /**
     * Decrypts data using the provided key.
     *
     * @param paraDescifrar   Data to be decrypted.
     * @param claveDescifrado Key to be used for decryption.
     * @return Decrypted data as a byte array.
     * @throws InvalidKeyException       if the key is invalid for RSA decryption.
     * @throws IllegalBlockSizeException if the block size is not suitable for RSA.
     * @throws BadPaddingException       if there is a padding issue with the data.
     */
    public byte[] descifrar(byte[] paraDescifrar, Key claveDescifrado)
            throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // Initialize the cipher in decryption mode with the provided key
        cifrador.init(Cipher.DECRYPT_MODE, claveDescifrado);
        // Decrypt the data
        byte[] bytesDescifrados = cifrador.doFinal(paraDescifrar);
        return bytesDescifrados;
    }

    /**
     * Prints the given byte array as text to the console.
     *
     * @param buffer Array of bytes to be printed as text.
     * @throws IOException if an error occurs while converting bytes to text.
     */
    public void mostrarBytes(byte[] buffer) throws IOException {
        // Convert byte array to a string and print to console
        String texto = new String(buffer);
        System.out.println(texto);
    }
}

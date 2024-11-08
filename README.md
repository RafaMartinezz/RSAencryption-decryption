# RSA encryption and decryption with Java

## Project Overview
This project demonstrates the usage of RSA encryption and decryption using Java’s `Cipher` class. The project consists of two main classes:
1. **`GestorCifradoRSA`**: A class that manages RSA key generation, encryption, and decryption processes.
2. **`Main`**: A driver class that showcases the functionality of `GestorCifradoRSA` by encrypting and decrypting a sample message.

## Features
- **RSA Key Generation**: The project generates a pair of public and private RSA keys with a key size of 1024 bits.
- **Data Encryption**: It encrypts a sample plaintext message using the RSA public key.
- **Data Decryption**: The encrypted message is then decrypted using the RSA private key to retrieve the original message.
- **Byte Display**: Outputs encrypted and decrypted data in bytes to verify the integrity of the operations.

## Requirements
- **Java 17** or higher.
- **Maven** (if using as a Maven project).

## Usage
The main encryption and decryption functionality is encapsulated in `GestorCifradoRSA`. The `Main` class demonstrates this process:
1. Initializes an instance of `GestorCifradoRSA`, which generates a public and private key pair.
2. Encrypts a sample message ("hola") using the public key.
3. Decrypts the encrypted message using the private key.
4. Displays the results in the console.

### Sample Output
Upon running `Main`, you should see the following:
- Encrypted message in bytes.
- Decrypted message, which should match the original input if decryption is successful.

## Code Overview
### `GestorCifradoRSA`
- **Key Generation**: Generates a 1024-bit RSA key pair.
- **Encryption (`cifrar`)**: Encrypts data using the provided RSA public key.
- **Decryption (`descifrar`)**: Decrypts data using the provided RSA private key.
- **Display (`mostrarBytes`)**: Converts byte data to a string and outputs it to the console.

### `Main`
- A simple class demonstrating the `GestorCifradoRSA` functionality with a sample message.
  
## Exception Handling
The project includes robust exception handling for encryption/decryption, providing detailed output for issues such as:
- Invalid key usage
- Block size or padding errors
- General encryption exceptions

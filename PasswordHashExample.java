import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordHashExample {

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = digest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "MySecurePass123";
        String hashed = hashPassword(password);
        System.out.println("Original: " + password);
        System.out.println("Hashed:   " + hashed);
    }
}
/*
Where it's used
    Password hashing (usually combined with salting,
    or replaced by BCrypt/Argon2/PBKDF2 for that specific use case)

    Digital signatures

    Blockchain (e.g., Bitcoin uses SHA-256 for mining/proof-of-work)

    File integrity checks (verifying a downloaded file hasn't been tampered with)

    SSL/TLS certificates

SHA — Secure Hash Algorithm
AES — Advanced Encryption Standard
PBKDF2 — Password-Based Key Derivation Function 2

SHA    (e.g., SHA-256) is a hashing algorithm — one-way, used for integrity checks
       and (with care) password storage.

AES    is a symmetric encryption standard — same key encrypts and decrypts,
       used for securing data that needs to be recovered later.

PBKDF2 is a key derivation function — it repeatedly applies a hash
       (often SHA-256) along with a salt and
       many iterations, specifically to slow down brute-force attempts
       on passwords. It's built into Java's javax.crypto
*/
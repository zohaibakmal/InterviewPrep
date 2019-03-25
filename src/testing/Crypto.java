package testing;

import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Crypto {
    private static final String PROVIDER = "AES/CBC/PKCS5Padding";
    private static final String IV_ALGORITHM = "SHA1PRNG";
    private static final String UNIQUE_FACTORY_ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final String UNIQUE_ALGORITHM = "AES";
    private static final String ALGORITHM = "HmacSHA1";
    private static final int IV_SIZE = 16;
    private static final int SALT_SIZE = 32;
    private static final int KEY_SIZE = 128;
    private static final int ITERATION_COUNT = 10000;
    // Used for encrypting the clear text
    private SecretKeySpec secretKey;
    private SecretKeyFactory secretKeyFactory;
    private SecureRandom secureRandom;
    private Cipher cipher;
    private int iterationCount;

    public Crypto(String encryptionKey) {
        this(encryptionKey, ITERATION_COUNT);
    }

    public Crypto(String encryptionKey, int iterationCount) {
        try {
            this.secretKey = new SecretKeySpec(Base64.getDecoder().decode(encryptionKey), ALGORITHM);
            this.secretKeyFactory = SecretKeyFactory.getInstance(UNIQUE_FACTORY_ALGORITHM);
            this.secureRandom = SecureRandom.getInstance(IV_ALGORITHM);
            this.cipher = Cipher.getInstance(PROVIDER);
            this.iterationCount = iterationCount;
        } catch (Throwable e) {

        }
    }

    public String encrypt(String clearText) {
        try {



            byte[] salt = generateSalt();
            SecretKey sk = generateUniqueKey(salt);
            byte[] iv = generateIV();
            IvParameterSpec ivs = new IvParameterSpec(iv);

            // encrypted the clear text
            byte[] textEncrypted = null;
            synchronized (cipher) {
                cipher.init(Cipher.ENCRYPT_MODE, sk, ivs);
                textEncrypted = cipher.doFinal(clearText.getBytes());
            }


            // but 3 things together:  salt + hash + encrypted data
            byte[] cipherText = new byte[SALT_SIZE + IV_SIZE + textEncrypted.length];
            System.arraycopy(salt, 0, cipherText, 0, SALT_SIZE);
            System.arraycopy(iv, 0, cipherText, SALT_SIZE, IV_SIZE);
            System.arraycopy(textEncrypted, 0, cipherText, SALT_SIZE + IV_SIZE, textEncrypted.length);


            String finalEncrypted = Base64.getEncoder().encodeToString(cipherText);

            return finalEncrypted;
        } catch (Throwable t) {
            return null;
        }
    }

    public String decrypt(String base64encrypted) {
        return decrypt(base64encrypted, false);
    }

    public String decrypt(String base64encrypted, boolean suppressError) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(base64encrypted);
            if (decodedBytes.length <= SALT_SIZE + IV_SIZE) {
                // something is wrong if the size of the encrypted string is equal or smaller than the IV and SALT by itself...
                return null;
            }
            byte[] salt = Arrays.copyOfRange(decodedBytes, 0, SALT_SIZE);
            byte[] iv = Arrays.copyOfRange(decodedBytes, SALT_SIZE, SALT_SIZE + IV_SIZE);
            byte[] cipherText = Arrays.copyOfRange(decodedBytes, SALT_SIZE + IV_SIZE, decodedBytes.length);
            if ((cipherText.length % 16) != 0) {
                // with padded cipher length has to be multiple of 16



                return null;
            }

            // decrypt
            SecretKey sk = generateUniqueKey(salt);
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            byte[] textDecrypted = null;
            synchronized (cipher) {
                cipher.init(Cipher.DECRYPT_MODE, sk, ivspec);
                textDecrypted = cipher.doFinal(cipherText);
            }

            String finalDecrypted = new String(textDecrypted);


            return finalDecrypted;
        } catch (BadPaddingException ignore) {


        } catch (Throwable t) {
            if (!suppressError) {

            } else {

            }
        }
        return null;
    }

    private byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_SIZE];
        random.nextBytes(salt);
        return salt;
    }

    private byte[] generateIV() throws Exception{
        byte[] byteIV = new byte[IV_SIZE];
        byteIV = secureRandom.generateSeed(IV_SIZE);
        return byteIV;
    }

    private SecretKey generateUniqueKey(byte[] salt) throws Exception{
        try {
            String key = Base64.getEncoder().encodeToString(this.secretKey.getEncoded());
            KeySpec spec = new PBEKeySpec(key.toCharArray(), salt, this.iterationCount, KEY_SIZE);
            SecretKey tmp = secretKeyFactory.generateSecret(spec);
            byte[] encoded = tmp.getEncoded();
            return new SecretKeySpec(encoded, UNIQUE_ALGORITHM);
        } catch (InvalidKeySpecException e) {
            // should never happen...

            throw new Exception(e.getMessage());
        }
    }

    public static void main(String [] args){
        String sessionKey = "PiJkY+Rk4KokWnsCynDVTUOOMcaWwW8WP3XXvph92ac=";
        Crypto crypto = new Crypto(sessionKey, 10000);
//
//        String hs = "My32BitsLongUniqueServerSideSalt";
//        String encryptedHs =crypto.encrypt(hs);
//        System.out.println("************Encrypted Hs***************");
//        System.out.println(encryptedHs);
//        System.out.println("************Encrypted Hs End ***************");

        String deCryptedHs = crypto.decrypt("30uy/BLri5tunRUsxCYPlg2O0XrjrjTRfbF1MLkyqaPenG7uZ6ToNN/WeCETDqihTc+Lcy/ZtLAYuQ+S7VRuew==");
        System.out.println("************Decrypted Hs***************");
        System.out.println(deCryptedHs);
        System.out.println("************Decrypted Hs End ***************");

    }
}

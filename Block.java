import java.security.MessageDigest;
import java.time.Instant;

public class Block {
    public int index;
    public long timestamp;
    public String data;
    public String previousHash;
    public String hash;

    public Block(int index, String data, String previousHash) {
        this.index = index;
        this.timestamp = Instant.now().getEpochSecond();
        this.data = data;
        this.previousHash = previousHash;
        this.hash = calculateHash();
    }

    public String calculateHash() {
        try {
            String input = index + Long.toString(timestamp) + data + previousHash;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Block #" + index + " [data=" + data + ", hash=" + hash + "]";
    }
}

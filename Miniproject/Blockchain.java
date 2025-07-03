import java.util.ArrayList;

public class Blockchain {
    public ArrayList<Block> chain;

    public Blockchain() {
        chain = new ArrayList<>();
        chain.add(createGenesisBlock());
    }

    private Block createGenesisBlock() {
        return new Block(0, "Genesis Block", "0");
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public void addBlock(String data) {
        Block latest = getLatestBlock();
        Block newBlock = new Block(latest.index + 1, data, latest.hash);
        chain.add(newBlock);
    }

    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block curr = chain.get(i);
            Block prev = chain.get(i - 1);

            if (!curr.hash.equals(curr.calculateHash())) return false;
            if (!curr.previousHash.equals(prev.hash)) return false;
        }
        return true;
    }

    public void printBlockchain() {
        for (Block block : chain) {
            System.out.println(block);
        }
    }
}

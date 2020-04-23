package top.lazyyy.tether;

import java.util.ArrayList;

public class Tether {

    private ArrayList<Block> blockChain = new ArrayList<Block>();
    private int difficulty = 1;

    public Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        //loop through blockchain to check hashes:
        for(int i=1; i < blockChain.size(); i++) {
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.getHash().equals(currentBlock.calculateHash()) ){
                System.out.println("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.getHash().equals(currentBlock.getPreviousHash()) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public boolean addBlock(Block block) {
        return blockChain.add(block);
    }

    public Block getBlock(int index) {
        return blockChain.get(index);
    }

    public int size() {
        return blockChain.size();
    }

    public ArrayList<Block> getBlockChain() {
        return blockChain;
    }
}

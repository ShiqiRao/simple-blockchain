package top.lazyyy.tether;

import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;

public class TestTether {

    @Test
    public void testHash() {
        Block genesisBlock = new Block("Hi im the first block", "0");
        System.out.println("Hash for block 1 : " + genesisBlock.getHash());

        Block secondBlock = new Block("Yo im the second block", genesisBlock.getHash());
        System.out.println("Hash for block 2 : " + secondBlock.getHash());

        Block thirdBlock = new Block("Hey im the third block", secondBlock.getHash());
        System.out.println("Hash for block 3 : " + thirdBlock.getHash());
    }

    @Test
    public void testAddBlock() {
        Tether tether = new Tether();
        tether.addBlock(new Block("Hi im the first block", "0"));
        tether.addBlock(new Block("Yo im the second block", tether.getBlock(tether.size() - 1).getHash()));
        tether.addBlock(new Block("Hey im the third block", tether.getBlock(tether.size() - 1).getHash()));
        String bcJson = new GsonBuilder().setPrettyPrinting().create().toJson(tether.getBlockChain());
        System.out.println(bcJson);
    }

    @Test
    public void testMineBlock() {
        //add our blocks to the blockchain ArrayList:
        Tether tether = new Tether();
        tether.getBlockChain().add(new Block("Hi im the first block", "0"));
        System.out.println("Trying to Mine block 1... ");
        tether.getBlockChain().get(0).mineBlock(tether.getDifficulty());

        tether.getBlockChain().add(new Block("Yo im the second block", tether.getBlockChain().get(tether.size() - 1).getHash()));
        System.out.println("Trying to Mine block 2... ");
        tether.getBlockChain().get(1).mineBlock(tether.getDifficulty());

        tether.getBlockChain().add(new Block("Hey im the third block", tether.getBlockChain().get(tether.size() - 1).getHash()));
        System.out.println("Trying to Mine block 3... ");
        tether.getBlockChain().get(2).mineBlock(tether.getDifficulty());

        System.out.println("\nBlockchain is Valid: " + tether.isChainValid());
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(tether.getBlockChain());
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);
    }

    @Test
    public void testMineBlockInDifferentDifficulty() {
        long start = System.currentTimeMillis();
        int difficulty = 1;
        testMineBlock(difficulty);
        System.out.println("Difficulty：" + difficulty + "，花费时间：" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        difficulty = 2;
        testMineBlock(difficulty);
        System.out.println("Difficulty：" + difficulty + "，花费时间：" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        difficulty = 4;
        testMineBlock(difficulty);
        System.out.println("Difficulty：" + difficulty + "，花费时间：" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        difficulty = 6;
        testMineBlock(difficulty);
        System.out.println("Difficulty：" + difficulty + "，花费时间：" + (System.currentTimeMillis() - start));
    }

    private void testMineBlock(int difficulty) {
        //add our blocks to the blockchain ArrayList:
        Tether tether = new Tether();
        tether.setDifficulty(difficulty);
        tether.getBlockChain().add(new Block("Hi im the first block", "0"));
        System.out.println("Trying to Mine block 1... ");
        tether.getBlockChain().get(0).mineBlock(tether.getDifficulty());

        tether.getBlockChain().add(new Block("Yo im the second block", tether.getBlockChain().get(tether.size() - 1).getHash()));
        System.out.println("Trying to Mine block 2... ");
        tether.getBlockChain().get(1).mineBlock(tether.getDifficulty());

        tether.getBlockChain().add(new Block("Hey im the third block", tether.getBlockChain().get(tether.size() - 1).getHash()));
        System.out.println("Trying to Mine block 3... ");
        tether.getBlockChain().get(2).mineBlock(tether.getDifficulty());

        System.out.println("\nBlockchain is Valid: " + tether.isChainValid());
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(tether.getBlockChain());
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);
    }
}

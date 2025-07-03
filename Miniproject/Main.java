public class Main {
    public static void main(String[] args) {
        Blockchain myBlockchain = new Blockchain();

        System.out.println("Adicionando blocos à blockchain...");
        myBlockchain.addBlock("Transação: Alice paga 10 a Gustavo");
        myBlockchain.addBlock("Transação: Gustavo paga 5 a Charlie");
        myBlockchain.addBlock("Transação: Charlie paga 2 a Alice");

        System.out.println("\nBlockchain atual:");
        myBlockchain.printBlockchain();

        System.out.println("\nA blockchain é válida? " + myBlockchain.isChainValid());
    }
}

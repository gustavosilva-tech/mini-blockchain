public class Main {
    public static void main(String[] args) {
        Blockchain myBlockchain = new Blockchain();

        System.out.println("A adicionar blocos à blockchain...");
        myBlockchain.addBlock("Transação: Alice paga 10 a Gustavo");
        myBlockchain.addBlock("Transação: Gustavo paga 5 a Jorge");
        myBlockchain.addBlock("Transação: Jorge paga 2 a Alice");

        System.out.println("\nBlockchain atual:");
        myBlockchain.printBlockchain();

        System.out.println("\nA blockchain é válida? " + myBlockchain.isChainValid());
    }
}

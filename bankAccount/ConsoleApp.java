package bankAccount;

public class ConsoleApp {
    static String DisplayBar(int i)
    {
        StringBuilder sb = new StringBuilder();

        int x = i / 2;
        sb.append("");
        for (int k = 0; k < 50; k++)
            sb.append(String.format("%s", ((x <= k) ? " " : "█")));
        sb.append("");

        return sb.toString();
    }

    static String progressBar(int progressBarSize, long currentPosition, long startPositoin, long finishPosition) {
        String bar = "";
        int nPositions = progressBarSize;
        char pb = '░';
        char stat = '█';
        for (int p = 0; p < nPositions; p++) {
            bar += pb;
        }
        int ststus = (int) (100 * (currentPosition - startPositoin) / (finishPosition - startPositoin));
        int move = (nPositions * ststus) / 100;
        return "[" + bar.substring(0, move).replace(pb, stat) + ststus + "%" + bar.substring(move, bar.length()) + "]";
    }

    public static void loader() throws InterruptedException {
        System.out.println("\u001B[32mdeposit is in progress.");
        for (int i = 0; i <= 100; i++)
        {
            Thread.sleep(30);
            System.out.printf("\r%s %s ", DisplayBar(i), i + "%");
        }

        progressBar(100,0,0,100);
    }
}
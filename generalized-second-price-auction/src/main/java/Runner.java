import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

    public static BidCalculater takeInput() {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(System.in);
        Scanner scanner = new Scanner(bufferedInputStream);

        List<Bid> bids = new ArrayList<Bid>();

        String input = scanner.nextLine();
        String amount = input.substring(input.lastIndexOf(" ") + 1);

        int itemsAvailable = Integer.valueOf(amount);

        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            String name = input.substring(0, input.lastIndexOf(" "));
            amount = input.substring(input.lastIndexOf(" ") + 1);
            bids.add(new Bid(name, Integer.valueOf(amount)));
        }

        BidCalculater bidCalculater = new BidCalculater(bids, itemsAvailable);
        return bidCalculater;
    }

    public static void printResults(List<String> result) {
        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
    }

    public static void main(String args[]) {

        BidCalculater bidCalculater = takeInput();
        List<String> result = bidCalculater.calculateBidResults();
        printResults(result);

    }
}

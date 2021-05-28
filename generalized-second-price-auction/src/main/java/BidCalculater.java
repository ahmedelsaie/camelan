import lombok.AllArgsConstructor;

import java.util.*;


@AllArgsConstructor
public class BidCalculater {

    public static final String LOST_THE_AUCTION = "Lost";
    public static final String NO_WINNERS = "No Winners";

    private List<Bid> bids;

    private int itemsAvailable;

    private static Comparator<Bid> bidComparator = new Comparator<Bid>() {

        public int compare(Bid x, Bid y) {

            if (x.getAmount() > y.getAmount())
                return -1;
            else if (x.getAmount() < y.getAmount())
                return 1;
            else {
                return x.getUserName().compareTo(y.getUserName());
            }
        }
    };



    public List<String> calculateBidResults() {
        Collections.sort(bids, BidCalculater.bidComparator);

        List<String> result = new ArrayList<String>();

        if (itemsAvailable == 0) {
            result.add(NO_WINNERS);
            return result;
        }

        int i = 0;
        for (i = 0; i < bids.size(); i++) {

            if (itemsAvailable > 0) {
                if (i + 1 < bids.size())
                    result.add(bids.get(i).getUserName() + " " + bids.get(i + 1).getAmount());
                else
                    result.add(bids.get(i).getUserName() + " " + bids.get(i).getAmount());

                itemsAvailable--;
            } else
                break;
        }

        for (; i < bids.size(); i++) {
            result.add(bids.get(i).getUserName() + " " + LOST_THE_AUCTION);
        }

        return result;
    }




}

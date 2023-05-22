import java.util.ArrayList;

class Posting {
    int docId;
    int dtf;
    ArrayList<Integer> positions;
    Posting next;

    public Posting(int doc) {
        docId = doc;
        dtf = 1;
        positions = new ArrayList<Integer>();
        next = null;
    }
}
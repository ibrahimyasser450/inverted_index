
import java.io.*;
import java.util.*;
public class InvertedIndex {
    private HashMap<String, DictEntry> index;
    private int docCount;

    public InvertedIndex() {
        index = new HashMap<String, DictEntry>();
        docCount = 1;
    }

    public void buildIndex(String fileName) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = in.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int position = -1;
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    position++;
                    if (!index.containsKey(token)) {
                        index.put(token, new DictEntry());
                    }
                    DictEntry entry = index.get(token);
                    if (entry.pList != null && entry.pList.docId == docCount) {
                        entry.pList.dtf++;
                        entry.pList.positions.add(position);
                    } else {
                        Posting p = new Posting(docCount);
                        p.positions.add(position);
                        p.next = entry.pList;
                        entry.pList = p;
                        entry.doc_freq++;
                    }
                    entry.term_freq++;
                }
            }
            docCount++;
            in.close(); 
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName);
        }
    }
    public void search(String query) {
        DictEntry entry = index.get(query);
        if (entry == null) {
            System.out.println("No documents contain the word " + query);
        } else {
            Posting p = entry.pList;
            while (p != null) {
                //int dnum= p.docId;
                System.out.println("Document " + (p.docId) + " contains the word " + "[ " + query + " ]" + " => " + p.dtf + " times" + " => " + "Positions: " + p.positions);
                p = p.next;
            }
        }
    }
}

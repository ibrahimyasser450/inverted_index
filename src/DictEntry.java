class DictEntry {
    int doc_freq;
    int term_freq;
    Posting pList;

    public DictEntry() {
        doc_freq = 0;
        term_freq = 0;
        pList = null;
    }
}
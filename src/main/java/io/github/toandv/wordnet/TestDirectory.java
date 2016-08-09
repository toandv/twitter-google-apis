package io.github.toandv.wordnet;

import java.net.URL;
import java.util.List;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;

/**
 * The library for working with wordnet is from
 * http://projects.csail.mit.edu/jwi.
 *
 */
public class TestDirectory {

    public static void main(String[] args) throws Exception {
        // The dict folder containing all wordnet's database files:
        // http://wordnetcode.princeton.edu/3.0/WNdb-3.0.tar.gz.
        URL url = new URL("file", null, "/home/toan/Work/prism/dict");

        // Construct the dictionary object and open it.
        IDictionary dict = new Dictionary(url);
        dict.open();

        // Look up first sense of the word "dog" as a noun.
        IIndexWord idxWord = dict.getIndexWord("dog", POS.NOUN);
        IWordID wordID = idxWord.getWordIDs().get(0);
        IWord word = dict.getWord(wordID);
        System.out.println("Id = " + wordID);
        System.out.println("Lemma = " + word.getLemma());
        System.out.println("Gloss = " + word.getSynset().getGloss());

        List<IWord> words = word.getSynset().getWords();

        // Get all the synonyms.
        for (IWord iWord : words) {
            System.out.println(iWord.getLemma());
        }
    }
}

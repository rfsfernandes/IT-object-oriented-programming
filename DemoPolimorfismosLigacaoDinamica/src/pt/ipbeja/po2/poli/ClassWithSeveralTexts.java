package pt.ipbeja.po2.poli;

import java.util.ArrayList;
import java.util.List;

/**
 * @author João Paulo Barros
 * @version 2020/05/12
 */
class ClassWithSeveralTexts {

    List<Quotable> excerpts;

    public ClassWithSeveralTexts() {
        this.excerpts = new ArrayList<>();
    }

    public void addText(Quotable text) {
        this.excerpts.add(text);
    }

    public List<String> getTexts() {
        List<String> texts = new ArrayList<>();
        for (Quotable qt : this.excerpts) {
            texts.add(qt.text());
        }
        return texts;
    }

    public List<String> getQuotedTexts() {
        List<String> quotedTexts = new ArrayList<>();
        for (Quotable qt : this.excerpts) {
            quotedTexts.add(qt.quotedText());
        }
        return quotedTexts;
    }

}

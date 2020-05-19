package pt.ipbeja.po2.iftype;

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
        List<String> quotedTexts = new ArrayList<>();
        for (Quotable qt : this.excerpts) {
            quotedTexts.add(qt.text());
        }
        return quotedTexts;
    }

    /**
     * method using if statements to test class type
     * should use dynamic binding!
     *
     * @return list with all texts quoted
     */
    public List<String> getQuotedTexts() {
        List<String> texts = new ArrayList<>();
        for (Quotable qt : this.excerpts) {
            if (qt.getClass() == QuotedSingle.class) {
                texts.add("'" + qt.text() + "'");
            } else if (qt.getClass() == QuotedNormal.class) {
                texts.add("\"" + qt.text() + "\"");
            } else if (qt.getClass() == QuotedFancy.class) {
                String leftMark = Character.toString((char) 0x00AB);
                String rightMark = Character.toString((char) 0x00BB);
                texts.add(leftMark + qt.text() + rightMark);
            }
        }
        return texts;
    }
}

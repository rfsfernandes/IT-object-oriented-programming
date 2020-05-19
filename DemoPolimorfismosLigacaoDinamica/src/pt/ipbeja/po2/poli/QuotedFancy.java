package pt.ipbeja.po2.poli;

/**
 * @author João Paulo Barros
 * @version 2020/05/12
 */
class QuotedFancy extends Quote {

    public QuotedFancy(String text, String author) {
        super(text, author);
    }

    @Override
    public String quotedText() {
        String leftMark = Character.toString((char) 0x00AB);
        String rightMark = Character.toString((char) 0x00BB);
        return leftMark + this.text() + rightMark;
    }
}

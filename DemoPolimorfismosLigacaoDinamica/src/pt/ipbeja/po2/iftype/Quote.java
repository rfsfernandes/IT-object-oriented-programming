package pt.ipbeja.po2.iftype;

/**
 * @author João Paulo Barros
 * @version 2020/05/12
 */
abstract class Quote implements Quotable {
    private final String text;
    private final String author;

    public Quote(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public String text() {
        return text;
    }

    public String author() {
        return author;
    }
}

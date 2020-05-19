package pt.ipbeja.po2.iftype;


/**
 * @author João Paulo Barros
 * @version 2020/05/12
 */
class RunDemoIfType {

    public static void main(String[] args) {
        ClassWithSeveralTexts texts = new ClassWithSeveralTexts();
        texts.addText(new QuotedSingle("Why do we never have time to do it right, but always have time to " +
                "do it over?",
                "anonymous"));
        texts.addText(new QuotedNormal("To iterate is human, to recurse divine.",
                "L. Peter Deutsch"));
        texts.addText(new QuotedFancy("The question of whether computers can think is like the question " +
                "of whether submarines can swim.",
                "Edsger W. Dijkstra"));

        for (String s : texts.getQuotedTexts()) {
            System.out.println(s);
        }
    }
}

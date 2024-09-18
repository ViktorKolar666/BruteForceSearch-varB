public class BruteForceSearch {
    private String text;
    private String pattern;

    public BruteForceSearch(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
    }

    public int find() {
        int textLength = text.length();
        int patternLength = pattern.length();
        int i = 0; // index aktuálního znaku v textu
        int j; // index aktuálního znaku ve vzorku

        while (i <= textLength - patternLength) {  // vnější cyklus
            j = 0;  // nastavení indexu vzorku na začátek

            // vnitřní cyklus pro porovnání jednotlivých znaků
            while (j < patternLength && text.charAt(i + j) == pattern.charAt(j)) {
                j++;  // zvýšení indexu ve vzorku a textu
            }

            // pokud jsme prošli celý vzorek, vzorek byl nalezen
            if (j == patternLength) {
                return i;  // vrací index, kde vzorek začíná
            }

            i++;  // pokud vzorek nebyl nalezen, posuň se v textu
        }

        return -1;  // pokud vzorek nebyl nalezen v textu
    }

    public static void main(String[] args) {
        BruteForceSearch search = new BruteForceSearch("Hello world!", "world");
        int index = search.find();
        if (index != -1) {
            System.out.println("Vzorek byl nalezen na indexu: " + index);
        } else {
            System.out.println("Vzorek nebyl nalezen.");
        }
    }
}

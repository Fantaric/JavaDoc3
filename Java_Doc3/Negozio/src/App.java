public class App {
    public static void main(String[] args) throws Exception {
        
        Alimentare al1 = new Alimentare(2022, 04, "pane", 100, "albania");
        NonAlimentare nal1 = new NonAlimentare("plastica", true, "bottiglia", 100, "italia");

        System.out.println(al1.isScaduto());
        al1.applicaSconto();
        nal1.applicaSconto();
        System.out.println(al1.getPrezzo());
        System.out.println(nal1.getPrezzo());

    }
}

import java.util.Dictionary;

public class Mission implements DisplayElement, Observer{
    Dictionary<String, Integer> eq;
    String name;
    Integer howMuch;
    private Subject eqData;

    public Mission(Subject eqData, String name, Integer howMuch) {
        this.eqData = eqData;
        eqData.registerObserver(this);
        this.name = name;
        this.howMuch = howMuch;
    }

    @Override
    public void update(Dictionary<String, Integer> eq) {
        this.eq = eq;
        Integer eqValue = eq.get(this.name);
        if (eqValue != null && eqValue.equals(this.howMuch)) {
            display();
        }

    }

    @Override
    public void display() {
        System.out.println(this.name + " added");
        eqData.removeObserver(this);
    }
}

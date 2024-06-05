import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class EqData implements Subject {
    Dictionary<String, Integer> eq= new Hashtable<>();
    int howMuch;
    String name;
    ArrayList<Observer> observers;

    public EqData(){
        observers = new ArrayList<>();
    }


    public void setEq(String name, int howMuch){
        Integer currentValue = eq.get(name);
        if (currentValue != null) {
            eq.put(name, currentValue + howMuch);
        } else {
            eq.put(name, howMuch);
        }

        eqChanged();
    }
    public void removeEq(String name, int howMuch){
        Integer currentValue = eq.get(name);
        eq.put(name, currentValue - howMuch);
        eqChanged();
    }

    private void eqChanged() {
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        try{
            for (Observer o : observers){
                o.update(eq);
            }
        }catch(Exception e){}

    }
}

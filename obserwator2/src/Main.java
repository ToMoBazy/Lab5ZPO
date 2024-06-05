public class Main {
    public static void main(String[] args) {
        EqData eqData = new EqData();
        Mission stm = new Mission(eqData, "Stick", 50);
        Mission swm = new Mission(eqData, "Sword", 10);

        eqData.setEq("Sword",4);
        eqData.setEq("Apple",9);
        eqData.setEq("Stick",52);
        eqData.removeEq("Stick",2);
        eqData.setEq("Sword",6);
    }
}
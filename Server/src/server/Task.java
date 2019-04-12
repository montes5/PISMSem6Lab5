package server;

import Sem6Lab5.TaskablePOA;

import java.util.Random;
import java.util.TreeSet;

public class Task extends TaskablePOA {
    @Override
    public String getResult() {
        TreeSet<Double> ts = new TreeSet<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) ts.add(100 + r.nextDouble() * 100);
        String result = "";
        for (Double elem : ts) result += elem.intValue() + "\n";
        return result;
    }
}

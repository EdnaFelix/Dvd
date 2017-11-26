import java.util.Comparator;

public class ComparaGenero implements Comparator<Dvd>{
    
    @Override
    public int compare(Dvd t, Dvd t1) {
        int res = t.genero.compareTo(t1.genero);
        return res;
    }
    
}

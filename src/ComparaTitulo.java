import java.util.Comparator;

public class ComparaTitulo implements Comparator<Dvd>{
    
    @Override
    public int compare(Dvd t, Dvd t1) {
        int res = t.titulo.compareTo(t1.titulo);
        return res;
    }
    
}
package m03_uf5_practica2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InfoClasse<T> {

    private T t;

    public InfoClasse (T t){
        this.t=t;
    }
    
    public String nomSuperclasse(){
        return t.getClass().getSuperclass().getName();
    }
    
    public String nomSuperComplet(){
        return t.getClass().getCanonicalName();
    }
    
    public String nomClasse(){
        return t.getClass().getName();
    }
    
    public Field[] arrayAtributs() {
        return t.getClass().getDeclaredFields();
    }

    public Method[] arrayMetodes() {
        return t.getClass().getMethods();
    }
    
    public String[] arrayStringAtribus() {
        String[] atributString = new String[arrayAtributs().length];
        Field[] atributs = arrayAtributs();
        for (int i = 0; i < arrayAtributs().length; i++) {
            atributString[i] = atributs[i].getName();
        }
        return atributString;
    }

    public String[] arrayStringMetodes() {
        String[] metodeString = new String[arrayMetodes().length];
        Method[] metode = arrayMetodes();
        for (int i = 0; i < arrayMetodes().length; i++) {
            metodeString[i] = metode[i].getName();
        }
        return metodeString;
    }

    public int[] modificadorAtribut() {
        int[] arrayField = new int[arrayAtributs().length];
        Field[] field = arrayAtributs();
        for (int i = 0; i < arrayField.length; i++) {
            arrayField[i] = field[i].getModifiers();
        }

        return arrayField;
    }

    public int[] modificadorMetode() {
        int[] arrayMetodes = new int[arrayMetodes().length];
        Method[] method = arrayMetodes();
        for (int i = 0; i < arrayMetodes.length; i++) {
            arrayMetodes[i] = method[i].getModifiers();
        }
        return arrayMetodes;
    }
    
        public void modificadorValorAtribut(Field atribut, Object objecte) throws IllegalArgumentException, IllegalAccessException {
        atribut.set(t, objecte);
    }

    public void executarMetode(Method metode) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        metode.setAccessible(true);
        metode.invoke(t, null);
    }

    public <T> InfoClasse<T> instanciaGeneric(Class<T> type) {
        return new InfoClasse<T>((T) type);
    }
    
    public <T> clone() throws CloneNotSupportedException {
        return  (T) t.clone();
    }
}

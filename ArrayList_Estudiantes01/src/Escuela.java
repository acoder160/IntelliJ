import java.util.ArrayList;
import java.util.Iterator;

public class Escuela {
    private ArrayList<Estudiante> listaEstudiantes;

    public Escuela(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public void borrarMenoresDeEdad(){
        Iterator<Estudiante> it = listaEstudiantes.iterator();
        while (it.hasNext()){
            if(it.next().getEdad() < 18){
                it.remove();
            }
        }
    }


    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
}

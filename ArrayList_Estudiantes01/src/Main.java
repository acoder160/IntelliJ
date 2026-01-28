
public static void main(String[] args) {
    ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();

    for (int i = 0; i < 50; i++) {
        int edad = (int) (Math.random() * (25 - 10 + 1)) + 10;
        estudiantes.add(new Estudiante(edad));
    }

    Escuela maria = new Escuela(estudiantes);

    maria.borrarMenoresDeEdad();

    System.out.println("Estudiantes al final: ");
    for (Estudiante tio : maria.getListaEstudiantes()){
        System.out.println(tio.getEdad());
    }


}
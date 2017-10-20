package pessoa;

public class Aluno extends Pessoa{
    private String curso;
    private String turno;
    private int periodo;
    private String senha;

    public Aluno(){}

    public Aluno(String curso, String turno, int periodo, String senha){
        setCurso(curso);
        setPeriodo(periodo);
        setTurno(turno);
        setSenha(senha);
    }

    public String consultaAula(){

        return "fazer";
    }

    public Object consultarHorario(){
        Pessoa p = null;
        return p;
    }

    public Object laboratorioDisponivel(){
        Pessoa p = null;
        return p;
    }

    @Override
    public boolean cadastrar(String nome, String genero, int mes, int ano, int dia) {
        return false;
    }

    @Override
    public boolean deletar(int id) {
        return false;
    }

    @Override
    public boolean editar() {
        return false;
    }

    public boolean ehAdministrador(){return false;}

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

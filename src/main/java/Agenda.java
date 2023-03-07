import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Agenda {

    private List<Tarefa> tarefas;

    public Agenda() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
    }

    public void removerTarefa(Tarefa tarefa) {
        this.tarefas.remove(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        Collections.sort(this.tarefas);
        return this.tarefas;
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        Tarefa t1 = new Tarefa("Estudar para a prova", LocalDate.of(2023, 3, 10), LocalTime.of(14, 30));
        Tarefa t2 = new Tarefa("Ir ao supermercado", LocalDate.of(2023, 3, 11), LocalTime.of(10, 0));
        Tarefa t3 = new Tarefa("Fazer exercícios", LocalDate.of(2023, 3, 12), LocalTime.of(16, 0));

        agenda.adicionarTarefa(t1);
        agenda.adicionarTarefa(t2);
        agenda.adicionarTarefa(t3);

        List<Tarefa> tarefas = agenda.listarTarefas();

        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }
    }
}

class Tarefa implements Comparable<Tarefa> {

    private String descricao;
    private LocalDate data;
    private LocalTime hora;

    public Tarefa(String descricao, LocalDate data, LocalTime hora) {
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHora() {
        return hora;
    }

    @Override
    public int compareTo(Tarefa outra) {
        int dataComparacao = this.data.compareTo(outra.data);
        if (dataComparacao != 0) {
            return dataComparacao;
        }
        return this.hora.compareTo(outra.hora);
    }

    @Override
    public String toString() {
        return "Tarefa: " + descricao + " - Data: " + data + " - Hora: " + hora;
    }
}

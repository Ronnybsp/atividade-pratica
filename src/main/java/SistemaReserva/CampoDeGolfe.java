package SistemaReserva;

import java.util.ArrayList;
import java.util.List;

public class CampoDeGolfe extends Entidade {
    private List<TeeTime> teeTimes;

    public CampoDeGolfe(String id, String nome) {
        super(id, nome);
        this.teeTimes = new ArrayList<>();
    }

    public void adicionarTeeTime(TeeTime teeTime) {
        teeTimes.add(teeTime);
    }

    public List<TeeTime> getTeeTimes() { return teeTimes; }
}
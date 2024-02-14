package SistemaReserva;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeReservas {
    private List<CampoDeGolfe> camposDeGolfe = new ArrayList<>();
    private List<String> reservas = new ArrayList<>();

    public void adicionarCampoDeGolfe(CampoDeGolfe campo) {
        camposDeGolfe.add(campo);
    }

    public void fazerReserva(Scanner scanner) {
        if (camposDeGolfe.isEmpty()) {
            System.out.println("Não há campos disponíveis para reserva.");
            return;
        }
    
        System.out.println("Selecione um campo de golfe:");
        for (int i = 0; i < camposDeGolfe.size(); i++) {
            System.out.println((i + 1) + ". " + camposDeGolfe.get(i).getNome());
        }
    
        System.out.print("Campo (número): ");
        int campoEscolha = scanner.nextInt();
        scanner.nextLine();
        if (campoEscolha < 1 || campoEscolha > camposDeGolfe.size()) {
            System.out.println("Seleção inválida.");
            return;
        }
    
        CampoDeGolfe campo = camposDeGolfe.get(campoEscolha - 1);
    
        System.out.println("Tee Times disponíveis:");
        List<TeeTime> teeTimes = campo.getTeeTimes();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for (int i = 0; i < teeTimes.size(); i++) {
            TeeTime tt = teeTimes.get(i);
            System.out.println((i + 1) + ". " + sdf.format(tt.getDataHora()) + " - Preço: " + tt.getPreco() + " - Carrinho: " + (tt.isCarrinhoDisponivel() ? "Sim" : "Não"));
        }
    
        System.out.print("Tee Time (número): ");
        int teeTimeEscolha = scanner.nextInt();
        scanner.nextLine();
        if (teeTimeEscolha < 1 || teeTimeEscolha > teeTimes.size()) {
            System.out.println("Seleção inválida.");
            return;
        }
        System.out.print("Informe o número de jogadores para a reserva: ");
        int numeroDeJogadores = scanner.nextInt();
        scanner.nextLine();
    
        TeeTime teeTimeEscolhido = teeTimes.get(teeTimeEscolha - 1);
        
        if (numeroDeJogadores > teeTimeEscolhido.getCapacidadeMaximaJogadores()) {
            System.out.println("O número de jogadores excede a capacidade máxima para este tee time. Máximo permitido: " + teeTimeEscolhido.getCapacidadeMaximaJogadores() + " jogadores.");
            return;
        }
    
        TeeTime teeTime = teeTimes.get(teeTimeEscolha - 1);
        String reservaString = "Reserva para " + campo.getNome() + " em " + sdf.format(teeTime.getDataHora()) + teeTime.getCapacidadeMaximaJogadores();
    
        for (String reserva : reservas) {
            if (reserva.contains(reservaString)) {
                System.out.println("Este tee time já está reservado. Por favor, escolha outro.");
                return;
            }
        }
    
        reservas.add(reservaString  + " para " + numeroDeJogadores + " Jogadores" + " - Preço: " + teeTime.getPreco() + " - Carrinho: " + (teeTime.isCarrinhoDisponivel() ? "Sim" : "Não"));
        System.out.println("Reserva feita com sucesso.");
    }
    
    public void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Não há reservas feitas.");
            return;
        }
        System.out.println("Reservas:");
        reservas.forEach(System.out::println);
    };

    public void listarCamposDeGolfe() {
        if (camposDeGolfe.isEmpty()) {
            System.out.println("Não há campos de golfe cadastrados.");
            return;
        }
        camposDeGolfe.forEach(campo -> {
            System.out.println(campo.getNome() + ":");
            campo.getTeeTimes().forEach(teeTime -> {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                System.out.println("  Tee Time: " + sdf.format(teeTime.getDataHora()) + " - Preço: " + teeTime.getPreco() + " - Carrinho: " + (teeTime.isCarrinhoDisponivel() ? "Sim" : "Não"));
            });
        });
    }
}
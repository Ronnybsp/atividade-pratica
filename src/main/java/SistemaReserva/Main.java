package SistemaReserva;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    private static final GerenciadorDeReservas gerenciador = new GerenciadorDeReservas();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inicializarDados();

        while (true) {
            System.out.println("\n1. Fazer uma reserva");
            System.out.println("2. Verificar reservas");
            System.out.println("3. Listar Campos de Golfe");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    gerenciador.fazerReserva(scanner);
                    break;
                case 2:
                    gerenciador.listarReservas();
                    break;
                case 3:
                    gerenciador.listarCamposDeGolfe();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private static void inicializarDados() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            CampoDeGolfe campo1 = new CampoDeGolfe("1", "Clube de Golfe do IFBA");
            campo1.adicionarTeeTime(new TeeTime(sdf.parse("2023-10-15 08:00"), true, 100.0, 8));
            campo1.adicionarTeeTime(new TeeTime(sdf.parse("2023-10-15 10:00"), false, 90.0, 10));

            CampoDeGolfe campo2 = new CampoDeGolfe("2", "Clube de Golfe da UFRB");
            campo2.adicionarTeeTime(new TeeTime(sdf.parse("2023-10-16 09:00"), true, 120.0, 9));

            CampoDeGolfe campo3 = new CampoDeGolfe("2", "Clube de Golfe da UNIFACEMP");
            campo3.adicionarTeeTime(new TeeTime(sdf.parse("2023-10-17 09:30"), true, 115, 11));

            gerenciador.adicionarCampoDeGolfe(campo1);
            gerenciador.adicionarCampoDeGolfe(campo2);
            gerenciador.adicionarCampoDeGolfe(campo3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import java.util.Scanner;

public class RelatorioImpostoDeRenda {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe a renda anual com salário: ");
        double rendaAnualSalario = sc.nextDouble();

        System.out.print("Informe a renda anual com prestação de serviço: ");
        double rendaAnualServico = sc.nextDouble();

        System.out.print("Informe a renda anual com ganho de capital: ");
        double rendaAnualCapital = sc.nextDouble();

        System.out.print("Informe os gastos anuais com médicos: ");
        double gastosMedicos = sc.nextDouble();

        System.out.print("Informe os gastos anuais com educação: ");
        double gastosEducacionais = sc.nextDouble();

        double rendaMensalSalario = rendaAnualSalario / 12;
        double impostoSalario = calcularImpostoSalario(rendaMensalSalario) * 12;
        double impostoServico = rendaAnualServico * 0.15;
        double impostoCapital = rendaAnualCapital * 0.20;

        double impostoBruto = impostoSalario + impostoServico + impostoCapital;

        double gastosTotais = gastosMedicos + gastosEducacionais;

        double limiteDesconto = impostoBruto * 0.30;
        double descontoAplicado = Math.min(gastosTotais, limiteDesconto);

        double impostoFinal = impostoBruto - descontoAplicado;

        System.out.println("\n--- Relatório de Imposto de Renda ---");
        System.out.printf("Renda Anual com Salário: R$ %.2f\n", rendaAnualSalario);
        System.out.printf("Renda Mensal com Salário: R$ %.2f\n", rendaMensalSalario);
        System.out.printf("Imposto sobre Salário (Anual): R$ %.2f\n", impostoSalario);
        System.out.printf("Imposto sobre Prestação de Serviço: R$ %.2f\n", impostoServico);
        System.out.printf("Imposto sobre Ganho de Capital: R$ %.2f\n", impostoCapital);
        System.out.printf("Imposto Bruto Total: R$ %.2f\n", impostoBruto);
        System.out.printf("Gastos Médicos e Educacionais: R$ %.2f\n", gastosTotais);
        System.out.printf("Limite de Desconto (30%% do Imposto Bruto): R$ %.2f\n", limiteDesconto);
        System.out.printf("Desconto Aplicado: R$ %.2f\n", descontoAplicado);
        System.out.printf("Imposto Final a Pagar: R$ %.2f\n", impostoFinal);

        sc.close();
    }

    public static double calcularImpostoSalario(double rendaMensal) {
        if (rendaMensal < 3000) {
            return 0;
        } else if (rendaMensal < 5000) {
            return rendaMensal * 0.10;
        } else {
            return rendaMensal * 0.20;
        }
    }
}

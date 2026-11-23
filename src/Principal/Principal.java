package Principal;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

  

    public class Principal {

        static long[] documento = new long[100];
        //FIZ A TROCA DO DADO DO documento PARA long. ESTAVA DANDO ERRO NO SOFTWARE(GABRIEL)
        static String[] descricao = new String[100];
        static String[] beneficiario = new String[100];
        static double[] valordebito = new double[100];
        static double[] saldodevedor = new double[100];
        static LocalDate[] vencimento = new LocalDate[100];
        static DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        static int qtdContas = 0;

        public static void main(String[] args) {
            int opcao;

            do {
                opcao = Integer.parseInt(JOptionPane.showInputDialog("SISTEMAS DE CONTAS A PAGAR\n\n"
                        + "1 - Cadastro de contas\n"
                        + "2 - Baixa de contas\n"
                        + "3 - Relatórios\n"
                        + "0 - Sair\n"
                        + "Escolha uma opção :"));
                switch (opcao) {
                    case 1:
                        menudeCadastro();
                        break;
                    case 2:
                        baixaContas();
                        break;
                    case 3:
                        menuRelatorios();
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Sistema encerrado");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida !");
                }
            } while (opcao != 0);
        }

        static void menudeCadastro() {
            int opcao;
            do {
                opcao = Integer.parseInt(JOptionPane.showInputDialog("SISTEMAS DE CONTAS A PAGAR\n\n"
                        + "1 - Inclusão de contas\n"
                        + "2 - Alteração de contas\n"
                        + "3 - Consulta de contas\n"
                        + "4 - Exclusão de contas\n"
                        + "0 - Voltar ao menu anterior\n"
                        + "Escolha uma opção :"));
                switch (opcao) {
                    case 1:
                        incluirConta();
                        break;
                    case 2:
                        alterarConta();
                        break;
                    case 3:
                        consultarConta();
                        break;
                    case 4:
                        excluirConta();
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Voltar ao menu anterior  !");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida !");
                }
            } while (opcao != 0);

        }

        static void baixaContas() {
            long numeroDocumento;
            int posicao = -1;
            numeroDocumento = Long.parseLong(JOptionPane.showInputDialog("Digite o número do documento"));
            for (int i = 0; i < qtdContas; i++) {
                if (numeroDocumento == documento[i]) {
                    posicao = i;
                }
            }
            if (posicao == -1) {
                JOptionPane.showMessageDialog(null, "Não foi possível encontrar o Documento!");
            } else {
                JOptionPane.showMessageDialog(null, "Documento:" + documento[posicao] + "\nDescrição:" + descricao[posicao] + "\nBeneficiário:" + beneficiario[posicao] + "\nValor da Conta: R$" + valordebito[posicao] + "\nSaldo devedor: R$" + saldodevedor[posicao] + "\nVencimento:" + vencimento[posicao]);
                double valorpago;
                do {
                    valorpago = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor à pagar:"));
                    if (valorpago <= 0 || valorpago > saldodevedor[posicao]) {
                        JOptionPane.showMessageDialog(null, "Valor está inválido!");
                    }
                } while (valorpago <= 0 || valorpago > saldodevedor[posicao]);
                int confirmar;
                confirmar = JOptionPane.showConfirmDialog(null, "\nConfirmar a baixa de R$" + valorpago + "?", "\n Confirmar pagamento", JOptionPane.YES_NO_OPTION);
                if (confirmar == JOptionPane.YES_OPTION) {
                    saldodevedor[posicao] = saldodevedor[posicao] - valorpago;
                    JOptionPane.showMessageDialog(null, "A Baixa foi realizada!\nSaldo devedor atualizado: R$" + saldodevedor[posicao]);
                } else {
                    JOptionPane.showMessageDialog(null, "A baixa foi cancelada!");
                }
            }
        }

        static void incluirConta() {
            if (qtdContas >= 100) {
                JOptionPane.showMessageDialog(null, "Limite de contas atingido");
                return;
            }
            beneficiario[qtdContas] = JOptionPane.showInputDialog("Digite o nome do correntista");
            descricao[qtdContas] = JOptionPane.showInputDialog("Digite a descição do correntista");
            DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            documento[qtdContas] = Long.parseLong(JOptionPane.showInputDialog("Informe o documento"));
            valordebito[qtdContas] = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da conta:"));
            saldodevedor[qtdContas] = valordebito[qtdContas];
            String dataStr = JOptionPane.showInputDialog(
                    "Digite a data de vencimento (dd/MM/yyyy)");
            vencimento[qtdContas] = LocalDate.parse(dataStr, data);
            qtdContas++;
        }

        static void alterarConta() {

        }

        static void consultarConta() {
            long doc = Long.parseLong(JOptionPane.showInputDialog("Digite o documento"));
            boolean confere = false;

            for (int i = 0; i < qtdContas; i++) {

                if (documento[i] == doc) {

                    confere = true;

                    JOptionPane.showMessageDialog(
                            null,
                            "Beneficiário: " + beneficiario[i]
                            + "\nDescrição: " + descricao[i]
                            + "\nDocumento: " + documento[i]
                            + "\nValor da conta: R$ " + valordebito[i]
                            + "\nSaldo devedor: R$ " + saldodevedor[i]
                            + "\nVencimento: " + vencimento[i].format(data)
                    );

                    break;
                }
            }
            if (!confere) {
                JOptionPane.showMessageDialog(
                        null,
                        "Conta não encontrada!"
                );
            }
        }

        static void excluirConta() {

        }

        static void menuRelatorios() {
            int opcao;
            do {
                opcao = Integer.parseInt(JOptionPane.showInputDialog("SISTEMAS DE CONTAS A PAGAR\n\n"
                        + "1 - Relatório de contas a pagar\n"
                        + "2 - Relaório de contas atrasadas\n"
                        + "3 - Balanço de despesas\n"
                        + "0 - Retornar\n"
                        + "Escolha uma opção :"));
                switch (opcao) {
                    case 1:
                        relatorioContas();
                        break;
                    case 2:
                        relatorioAtrasados();
                        break;
                    case 3:
                        balancoDespesas();
                        break;
                    case 0:

                        JOptionPane.showMessageDialog(null, "Retornar ao menu de cadastro");

                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida !");
                }
            } while (opcao != 0);
        }

        static void relatorioContas() {
            String textoInicio = JOptionPane.showInputDialog("Data Inicial (dd/MM/yyyy):");
            String textoFinal = JOPtionPane.showInputDialog("Data Final (dd/MM/yyyy):");
            LocalDate dataInicio = LocalDate.parse(textoInicio, data);
            LocalDate dataFim = LocalDate.parse(textoFinal, data);
            int[] contasAtivas = new int[qtdContas];
            int totalEncontradas = 0;
            for (int i = 0; i < qtdContas; i++) {
                if (saldodevedor[i] > 0 && !vencimento[i].isBefore(dataInicio) && !vencimento[i].isAfter(dataFim)) {
                    contasAtivas[totalEncontradas] = i;
                    totalEncontradas++;
                }
            }

            for (int i = 0; i < totalEncontradas - 1; i++) {
                for (int j = i + 1; j < totalEncontradas; j++) {
                    if (vencimento[contasAtivas[i]].isAfter(vencimento[contasAtivas[j]])) {
                        int temporario = contasAtivas[i];
                        contasAtivas[i] = contasAtivas[j];
                        contasAtivas[j] = temporario;
                    }
                }
            }

            if (totalEncontradas == 0) {
                JOptionPane.showMessageDialog(null, "Nenhuma conta a pagar nesse período!");
            } else {
                String relatorio = "xyz comercio de produtos LTDA.\n"
                        + "contas a pagar por período\n\n"
                        + "vencimento | valor | documento | descrição | beneficiário\n";
                for (int a = 0; a < totalEncontradas; a++) {
                    int f = contasAtivas[a];
                    relatorio += vencimento[f].format(data) + " | R$"
                            + saldodevedor[f] + " | "
                            + documento[f] + " | "
                            + descricao[f] + " | "
                            + beneficiario[f] + "\n";
                }
                JOptionPane.showMessageDialog(null, relatorio);
            }
        }

        static void relatorioAtrasados() {
            LocalDate hoje = LocalDate.now();
            int[] contasvencidas = new int[qtdContas];
            int totalEncontradas = 0;
            for (int i = 0; i < qtdContas; i++) {
                if (saldodevedor[i] > 0 && vencimento[i].isBefore(hoje)) {
                    contasvencidas[totalEncontradas] = i;
                    totalEncontradas++;
                }
            }
            for (int i = 0; i < totalEncontradas - 1; i++) {
                for (int j = i + 1; j < totalEncontradas; j++) {
                    if (vencimento[contasvencidas[i]].isAfter(vencimento[contasvencidas[j]])) {
                        int temporario = contasvencidas[i];
                        contasvencidas[i] = contasvencidas[j];
                        contasvencidas[j] = temporario;
                    }
                }
            }
            if (totalEncontradas == 0) {
                JOptionPane.showMessageDialog(null, "Nenhuma conta atrasada!");
            } else {
                String relatorio = "xyz comercio de produtos LTDA.\n"
                        + "contas a pagar atrasadas\n\n"
                        + "vencimento | valor | documento | descrição | beneficiário\n";

                for (int m = 0; m < totalEncontradas; m++) {
                    int f = contasvencidas[m];
                    relatorio += vencimento[f].format(data) + " | R$"
                            + saldodevedor[f] + " | "
                            + documento[f] + " | "
                            + descricao[f] + " | "
                            + beneficiario[f] + "\n";
                }
                JOptionPane.showMessageDialog(null, relatorio);
            }
        }
    }

    static void balancoDespesas() {
        int ano;
        int mes;
        double despesatotaldobeneficiario;
        double[] Despesatotal = new double[12];
        double[] Despesatotalbeneficiario = new double[12];
        String[] Beneficiariodespesamaior = new String[12];
        String relatorio = "BALANÇO DAS DESPESAS\n\n" + "MÊS, TOTAL DAS DESPESAS, BENEFICIÁRIO\n";
        ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano :"));
        String[] meses = {
            "JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL", "MAIO", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO",};

        for (int i = 0; i < qtdContas; i++) {
            if (vencimento[i].getYear() == ano) {
                mes = vencimento[i].getMonthValue() - 1;
                Despesatotal[mes] += valordebito[i];
                despesatotaldobeneficiario = 0;
                for (int j = 0; j < qtdContas; j++) {
                    if (vencimento[j].getYear() == ano && vencimento[j].getMonthValue() == mes + 1 && beneficiario[j].equals(beneficiario[i])) {
                        despesatotaldobeneficiario += valordebito[j];
                    }
                }
                if (despesatotaldobeneficiario > Despesatotalbeneficiario[mes]) {
                    Despesatotalbeneficiario[mes] = despesatotaldobeneficiario;
                    Beneficiariodespesamaior[mes] = beneficiario[i];
                }
            }
        }
        for (int k = 0; k < 12; k++) {
            if (Beneficiariodespesamaior[k] == null) {
                relatorio += meses[k] + " R$" + Despesatotal[k] + "-\n";
            } else {
                relatorio += meses[k] + " R$" + Despesatotal[k] + "" + Beneficiariodespesamaior[k] + "\n";
            }

        }
        JOptionPane.showMessageDialog(null, relatorio);
    }

}

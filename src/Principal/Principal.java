package Principal;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Principal {

     static int [] documento = new int[100];
     static String [] descricao = new String[100];
     static String[] beneficiario = new String[100];
     static double [] valordebito = new double[100];
     static double [] saldodevedor = new double[100];
     static LocalDate [] vencimento = new LocalDate[100];
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

                    + "4 - Exclusaõ de contas\n"
                    + "0 - Voltar ao menu anterior\n"

                    + "4 - Exclusão de contas\n"
                    + "0 - Sair\n"

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
        int numeroDocumento;
        int posicao = -1;
        numeroDocumento = Integer.parseInt(JOptionPane.showInputDialog("Digite o número do documento"));
        for (int i = 0; i < 100; i++) {
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
            confirmar = JOptionPane.showConfirmDialog(null,"\nConfirmar a baixa de R$"+ valorpago +"?","\n Confirmar pagamento",JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION){
                saldodevedor[posicao]= saldodevedor[posicao]-valorpago;
                JOptionPane.showMessageDialog(null,"A Baixa foi realizada!\nSaldo devedor atualizado: R$"+saldodevedor[posicao]);
            }else{
                JOptionPane.showMessageDialog(null,"A baixa foi cancelada!");
            }
        }
    }

    static void incluirConta() {
     if(qtdContas > 100){
        JOptionPane.showMessageDialog(null,"LImite de contas atingido"); 
        return;
     }
       beneficiario[qtdContas] = JOptionPane.showInputDialog("Digite o nome do correntista");
       descricao[qtdContas] = JOptionPane.showInputDialog("Digote a descição do correntista");
        DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        valordebito[qtdContas] = saldodevedor[qtdContas];
        qtdContas++; 
    }

    static void alterarConta() {

    }

    static void consultarConta() {

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

    }

    static void relatorioAtrasados() {

    }

    static void balancoDespesas() {

    }
}

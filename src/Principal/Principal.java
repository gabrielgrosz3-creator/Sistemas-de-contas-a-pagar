package Principal;

import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
         int [] documento = new int[100];
         String [] descricao = new String[100];
         String[] beneficiario = new String[100];
         double [] valordebito = new double[100];
         double [] saldodevedor = new double[100];
         String [] vencimento = new String[100];
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
                    menedeBaixa();
                    break;
                case 3:
                    menudeRelatorios();
                case 0:
                    JOptionPane.showMessageDialog(null, "Sistema encerrado");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida !");
            }
        } while (opcao != 0);
    }
      public static void menudeCadastro(){
       int opcao;
       do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("SISTEMAS DE CONTAS A PAGAR\n\n"
                    + "1 - Inclusão de contas\n"
                    + "2 - Alteração de contas\n"
                    + "3 - Consulta de contas\n"
                    + "4 - Exclusaõ de contas"
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
                    JOptionPane.showMessageDialog(null, "Sistema encerrado");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Retornar ao menu anterior !");
            }
        } while (opcao != 0);
      

}

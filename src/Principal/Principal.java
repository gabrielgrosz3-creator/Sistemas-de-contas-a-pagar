package Principal;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Principal {

    public static void main(String[] args) {
         int [] documento = new int[100];
         String [] descricao = new String[100];
         String[] beneficiario = new String[100];
         double [] valordebito = new double[100];
         double [] saldodevedor = new double[100];
         LocalDate [] vencimento = new LocalDate[100];
         DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
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
      public static void menudeCadastro(){
       int opcao;
       do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("SISTEMAS DE CONTAS A PAGAR\n\n"
                    + "1 - Inclusão de contas\n"
                    + "2 - Alteração de contas\n"
                    + "3 - Consulta de contas\n"
                    + "4 - Exclusaõ de contas\n"
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
                    JOptionPane.showMessageDialog(null, "Opção inválida !");
            }
        } while (opcao != 0);
      
      }
      public static void baixaContas(){
          
      }
     public static void incluirConta(){
     
     }
     public static void alterarConta(){
     
     }
     public static void consultarConta(){
     
     }
     public static void excluirConta(){
     
     }
     
     public static void menuRelatorios(){
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
                    JOptionPane.showMessageDialog(null, "RErornar ao menu de cadastro");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida !");
            }
        } while (opcao != 0);
     }
     
     public static void relatorioContas(){
   
   }
    public static void relatorioAtrasados(){
    
    }
    public static void balancoDespesas(){
    
    }
   
}



 

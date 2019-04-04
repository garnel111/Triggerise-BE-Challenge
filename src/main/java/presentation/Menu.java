package presentation;


import java.io.FileNotFoundException;
import java.text.ParseException;

public class Menu {

    public static void mainLoop() throws FileNotFoundException, ParseException {
        int opcao = 0;
        int opcao2 = 0;
        ProductRegisterUI productRegisterUI= new ProductRegisterUI();
        do {
            opcao = menu();

            switch (opcao) {
                case 0:
                    System.out.println("fim ...");
                    break;

                case 1:
                    productRegisterUI.createProductsList();
                    break;

                case 2:
                    do{
                        opcao2 = menu2();
                        switch (opcao2) {
                            case 1:
                                productRegisterUI.showRulesList();
                                break;
                            case 2:
                                System.out.println("Calcular custo total");
                                 productRegisterUI.calTotalValue();
                                break;
                            case 3:
                                System.out.println("Listar produtos");
                                productRegisterUI.presentProductList();
                                break;
                        }

                    }while (opcao2!=9);
                    break;

                case 3:

                    productRegisterUI.calTotalValue();

                    break;


                default:
                    System.out.println("opcao não reconhecida.");
                    break;
            }
        } while (opcao != 0);

    }

    private static int menu() {
        int option = -1;
        System.out.println("");
        System.out.println("=============================");
        System.out.println(" Loja");
        System.out.println("=============================");
        System.out.println("1.Introduzir a lista de produtos");
        System.out.println("2.SubMenu");
        System.out.println("3.Calcular custo total");

        System.out.println("=============================");
        System.out.println("0. Sair\n\n");
        option = console.Console.readInteger("Por favor escolha opção");
        return option;
    }

    private static int menu2() {
        int option = -1;
        System.out.println("");
        System.out.println("=============================");
        System.out.println("Sub Menu");
        System.out.println("=============================");
        System.out.println("1.Listar as regras");
        System.out.println("2.Calcular custo total");
        System.out.println("3.Listar produtos");
        System.out.println("=============================");
        System.out.println("9. Voltar menu anterior\n");
        option = console.Console.readInteger("Por favor escolha opção");
        return (option);
    }
}

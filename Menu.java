import java.util.Scanner;

class Menu{
    public static User loggedUser = null;
    Scanner scan = new Scanner(System.in);

    public static void main(String args[]){
        Menu menu = new Menu();
        menu.showMenu();
    }

    public void showMenu(){
        System.out.println("------ BANCO JAVA ------");

        while(true){
            if(loggedUser == null){
                int opt = 0;
                System.out.println("Voce não está logado, deseja criar uma conta ou fazer o Login");
                System.out.println("[1] Fazer login.");
                System.out.println("[2] Criar conta.");
                System.out.println("[3] Sair.");
                opt = scan.nextInt();
                scan.nextLine();

                switch (opt) {
                    case 1:
                        this.login();    
                    break;
                    case 2:
                        this.register();
                    break;
                    case 3:
                        System.out.println("Saindo....");
                        System.exit(0);
                    break;
                
                    default:
                        System.out.println("Opção inválida");
                    break;
                }
            }

            // User is logged
            int opt = 0;
            System.out.printf("Olá %s seja bem vindo ao banco java!", loggedUser.getName());
            System.out.println("[1] Teste.");
            System.out.println("[2] Teste.");
            System.out.println("[3] Sair.");
            opt = scan.nextInt();
            scan.nextLine();

            switch (opt) {
                case 1:
                    this.login();    
                break;
                case 2:
                    this.register();
                break;
                case 3:
                    System.out.println("Saindo....");
                    System.exit(0);
                break;
            
                default:
                    System.out.println("Opção inválida");
                break;
            }
        }
    }

    public void login(){
        String cpf;
        String password;

        System.out.println("Faça o Login!");
        System.out.println("Digite seu cpf: ");
        cpf = scan.nextLine();
        System.out.println("Digite sua senha: ");
        password = scan.nextLine();
        
        User user = User.login(cpf, password);

        if(user == null){
            System.out.println("CPF ou Senha errados!");
            return;
        }

        loggedUser = user;

        return;
    }

    public void register(){
        String name, email, cpf, password;
        
        System.out.println("Crie uma conta!");
        System.out.println("Digite seu nome: ");
        name = scan.nextLine();
        System.out.println("Digite seu email: ");
        email = scan.nextLine();
        System.out.println("Digite seu cpf: ");
        cpf = scan.nextLine();
        System.out.println("Digite uma senha forte: ");
        password = scan.nextLine();

        boolean createUser = User.register(name, email, cpf, password);
        if (createUser) {
            System.out.println("Registro bem-sucedido!");
        } else {
            System.out.println("Falha no registro: CPF já existe.");
        }
    }
}
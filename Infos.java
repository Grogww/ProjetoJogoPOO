package game;

public class Infos {
    // evitar instanciamento
    private Infos() {}

    // Contexto
    public static void ShowStory() {
        System.out.println("HISTÓRIA DO JOGO\n");
        System.out.println("\nSeja Bem-Vindo a Valderis!!\r\n" + //
                        "\r\n" + //
                        "Valderis é um reino de cavaleiros, mercadores e agricultores, onde a honra e a prosperidade caminham lado a lado. Conhecido por seus torneios, Valderis celebra a bravura e a habilidade tanto em batalha quanto em debates. Sua rica herança cultural é marcada por contos de reis heroicos e exploradores audazes.\r\n" + //
                        "\r\n" + //
                        "Entretanto é natural que um reino enfrente alguns problemas, e a nação de Valderis era perturbada por um grupo rebelde que assolava a região.\r\n" + //
                        "\r\n" + //
                        "Para acabar com o problema o Rei Aldarion junto com a Rainha Lysandra decidiram convocar alguém para invadir o covil dos rebeldes e derrotar seu líder, com intuito de trazer paz aos habitantes e a todo o reino de Valderis.\n");
    }

    // Guia de Funcionamento
    public static void ShowGuide() {
        System.out.println("GUIA DO JOGO\n");
        System.out.println("\nO jogo funciona como um RPG de turnos, e o jogador possui liberdade para fazer a ação que bem entender, como atacar, defender, ou usar o especial.\\n" + //
                        "\r\n" + //
                        "Cada classe tem seu estilo de combate, o guerreiro ataca com sua espada, o arqueiro que dispara flechas em seus inimigos e o mago que conjura magias. os inimigos também tem uma ação na rodada e irão fazer o que puderem para que o jogador falhe em sua missão.\\n" + //
                        "\r\n" + //
                        "Após cada fase o personagem sobe de nível, no nível 4 ele desbloqueia seu especial que causa mais dano ao inimigo.\\n" + //
                        "\r\n" + //
                        "O jogador terá de passar por 5 fases com inimigos pré-definidos, e só podera prosseguir para a próxima fase quando derrotar todos os inimigos do local.\n");
    }

    // fim de jogo (vitória)
    public static void ShowGameWin(String name, int turns) {
        System.out.println(String.format("Com muita bravura %s consegue por fim derrotar o líder dos Rebeldes e sobreviver ao covil infestado de adversários.\r\n" + //
                        "Após alguns dias de caminhada, %s retorna ao reino trazendo boas notícias a todos os habitantes, sendo assim aclamado como um herói por toda a História de Valderis.\r\n" + //
                        "\r\n" + //
                        "Parabéns! Você conclui o desafio em %d turnos.", name, name, turns));
    }

    // fim de jogo (derrota)
    public static void ShowGameOver(String name) {
        System.out.println(String.format("%s lutou bravamente durante toda a caminhada, porém algo havia dado errado no caminho.\r\n" + //
                        "Teria sido prepotência ter lutado sozinho? \r\n" + //
                        "Deveria ter treinado mais durante a vida?\r\n" + //
                        "Ele era mesmo capaz para concluir essa missão?\r\n" + //
                        "\r\n" + //
                        "Enquanto os pensamentos inundavam sua cabeça, seu corpo desabava ao chão. Nenhuma dúvida poderia dar as forças que precisava no momento, enquanto o suspiro da vida esvaia de seus olhos, a única certeza estava na sua frente... A Morte.\r\n" + //
                        "\r\n" + //
                        "Você Morreu! tente novamente e conclua a missão.", name));
    }

    
    // Surgimento dos Inimigos
    public static void ShowEnemiesAppear(int phase, String name) {
        switch (phase) {
            case 1:
                System.out.println(String.format("%s entra em uma sala meio escura, da escuridão sai um capanga tentando te atacar.", name));
                break;
            case 2:
                System.out.println(String.format("Após a derrota do primeiro capanga %s continua sua jornada a dentro do covil, quando aparece mais 2 capangas para tentar te parar", name));
                break;
            case 3:
                System.out.println(String.format("%s após o combate se encontra em frente a um portão que se abre revelando-se 1 combatente e um capanga", name));
                break;
            case 4:
                System.out.println(String.format("Após a morte dos inimigos %s ouve um grito ao fundo e passos de corrida se aproximando ao longe ele vê mais 2 combatentes chegando para enfrentá-lo", name));
                break;
            case 5:
                System.out.println(String.format("Depois dessa luta intensa %s escuta aplausos vindo do fundo do covil, é o chefe chegando e dizendo 'parabéns por chegar tão longe, mas aqui será seu túmulo', junto com ele tem um combatente como guarda-costas.", name));
                break;
            default:
                break;
        }
    }

    //Mostrar Informações basicas
    public static void showBasicInfos(int op, String name){
        switch (op) {
            case 1:
                //info Guerreiro
                System.out.println(String.format("%s é um guerreiro que treinou por anos para se tornar um Cavaleiro de Eldral ( O acampamento da cavalaria de Valderis), alguém que fará de tudo para proteger o reino." + //
                                        "\r\n" + //
                                        "%s foi mandado nessa missão para provar o seu valor, ou então, morrer tentando.", name, name));
                break;
            case 2:
                //info Mago
                System.out.println(String.format("%s é um jovem mago aprendiz, por anos tem treinado a arte da magia, e quer provar para seu mestre que não é mais um principiante e que consegue fazer as coisas por si só. \r\n" + //
                                        "Com isso, %s foi convocado pela Rainha para cumprir esta missão.", name, name));
                break;
            case 3:
                //info Arqueiro
                System.out.println(String.format("%s é um arqueiro talentoso mas por conta da sua origem meio élfica é menosprezado pelos outros arqueiros e muitas vezes dão os créditos de suas habilidades a sua origem meio élfica.\r\n" + //
                                        "Convocado pela Rainha, %s ficou entusiasmado para provar que suas habilidades estão além da sua genética, e usará todas as técnicas aprendidas para comprovar isso.", name, name));
                break;
            default:
                break;
        }
    }

    //Mostrar informações do mob - OK
    public static String getMobHp(Personagem mob){
        return String.format("%s - HP: %d/%d", mob.getName(), mob.getHp(), mob.getHpBase());
    }
}


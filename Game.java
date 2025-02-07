package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private int phase;
    private int turn;
    private boolean bossHealed;
    private boolean specialUsed;
    private Personagem player;
    private List<Personagem> enemies;
    private Scanner scanner; // Declarar o Scanner como atributo da classe

    public Game() {
        this.turn = 1;
        this.phase = 1;
        this.bossHealed = false;
        this.specialUsed = false;
        this.enemies = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        //Contexto e Funcionamento
        Infos.ShowGuide();
        waitForKeyPress();
        clearConsole();

        Infos.ShowStory();
        waitForKeyPress();
        clearConsole();

        //Definir player
        setupPlayer();
        waitForKeyPress();
        waitForKeyPress();

        //Sistema de fases e turnos
        while (this.phase <= 5 && !this.player.isDead()){
            clearConsole();
            setupEnemies();
            this.specialUsed = false;
            System.out.println("\n===============================");
            System.out.println(String.format("Inicia-se a fase %d!!!", this.phase));

            //INFOS SOBRE INIMIGOS

            while (!this.player.isDead() && !allEnemiesDefeated()) {
                //infos.startPhase();
                playTurn();
                this.turn++;
                waitForKeyPress();
            }

            if (!this.player.isDead() && phase < 5) {
                this.player.levelUp();
            };

            System.out.println(String.format("A fase %d se encerrou!", this.phase));
            System.out.println("===============================\n");
            //Escrita sobre a nova fase - Infos
            this.phase++;
            waitForKeyPress();
        }
        endGame();
    }

    private void setupPlayer() {
        System.out.print("Digite o nome do seu personagem: ");
        String playerName = this.scanner.nextLine();

        System.out.println("Escolha uma classe: ");
        System.out.println("1 - Guerreiro (Alta vida, dano médio)");
        System.out.println("2 - Mago (Baixa vida, alto dano)");
        System.out.println("3 - Arqueiro (Equilibrado)");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                this.player = new Guerreiro(playerName);
                Infos.showBasicInfos(choice, playerName);
                break;
            case 2:
                this.player = new Mago(playerName);
                Infos.showBasicInfos(choice, playerName);
                break;
            case 3:
                this.player = new Arqueiro(playerName);
                Infos.showBasicInfos(choice, playerName);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private void setupEnemies() {
        Infos.ShowEnemiesAppear(this.phase, this.player.getName());
        this.enemies.clear();
        switch (this.phase) {
            case 1:
                //1 capanga
                this.enemies.add(new Capanga("Capanga"));
                break;
            case 2:
                //2 capanga
                this.enemies.add(new Capanga("Capanga 1"));
                this.enemies.add(new Capanga("Capanga 2"));
                break;
            case 3:
                //1 combatente + 1 capanga
                this.enemies.add(new Combatente("Combatente"));
                this.enemies.add(new Capanga("Capanga"));
                break;
            case 4:
                //2 combatente
                this.enemies.add(new Combatente("Combatente 1"));
                this.enemies.add(new Combatente("Combatente 2"));
                break;
            case 5:
                //1 boss + 1 combatente
                this.enemies.add(new Boss("Chefe"));
                this.enemies.add(new Combatente("Combatente"));
                break;
            default:
                break;
        }
    }

    private void playTurn() {
        System.out.println(String.format("\nTurno %d começa!", this.turn));
        System.out.println(Infos.getMobHp(player));
        this.player.resetDef();

        System.out.println("Escolha uma ação: ");
        System.out.println("1 - Atacar");
        System.out.println("2 - Defender");
        if (this.player.isSpecialUnlocked() && !this.specialUsed) {
            System.out.println("3 - Usar Habilidade Especial");
        }
        int action = scanner.nextInt();

        int i = 0;
        int targetIndex = 0;
        Personagem target = enemies.get(targetIndex);
        switch (action) {
            case 1:
                System.out.println("Escolha um inimigo para atacar: ");
                i = 1;
                for (Personagem enemie : this.enemies){
                    System.out.println(String.format("%d -> %s", i, Infos.getMobHp(enemie)));
                    i++;
                }
                targetIndex = scanner.nextInt();
                target = enemies.get(targetIndex-1);
                this.player.attack(target);
                break;
            case 2:
                this.player.defend();
                break;
            case 3:
                if (this.player.isSpecialUnlocked() && !this.specialUsed) {
                    System.out.println("Escolha um inimigo para atacar: ");
                    i = 1;
                    for (Personagem enemie : this.enemies){
                        System.out.println(String.format("%d -> %s", i, Infos.getMobHp(enemie)));
                        i++;
                    }
                    targetIndex = scanner.nextInt();
                    target = enemies.get(targetIndex-1);
                    this.player.useSpecial(target);
                    this.specialUsed = true;
                } else {
                    System.out.println("Habilidade especial não está disponível!");
                }
                break;
            default:
                System.out.println("Ação inválida!");
                break;
        }

        // Verifica se o inimigo ainda está vivo
        if (target.isDead()) {
            enemies.remove(target);
            System.out.println(target.getName() + " foi derrotado!");
        }

        for (Personagem enemie : this.enemies){
            if(!enemie.isDead()){
                if(enemie.getName().equals("Chefe") && enemie.getHp()<10 && !this.bossHealed){
                    enemie.heal();
                    this.bossHealed = true;
                }else{
                    enemie.attack(this.player);
                }
            }
        }
        
        if (this.player.isDead()){
            System.out.println(String.format("%s morreu na luta.", this.player.getName()));
        }

        System.out.println(String.format("Fim do turno %d.\n", this.turn));
    }

    private void endGame() {
        if (this.player.isDead()) {
            Infos.ShowGameOver(this.player.getName());
        } else if (allEnemiesDefeated()) {
            Infos.ShowGameWin(this.player.getName(), this.turn);
        } else {
            System.out.println("JOGO FINALIZADO!");
        }
    }

    private boolean allEnemiesDefeated() {
        return this.enemies.isEmpty();
    }

    public static void clearConsole() {
        // Para Windows
        if (System.getProperty("os.name").contains("Windows")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        // Para Unix/Linux/Mac
        else {
            try {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void waitForKeyPress() {
        this.scanner.nextLine(); // Aguarda o usuário pressionar Enter
    }
}


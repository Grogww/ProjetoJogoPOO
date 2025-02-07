package game;

public class Guerreiro extends Personagem{

    public Guerreiro(String name){
        this.name = name;
        this.level = 1;
        specialUnlocked = false;
        hpBase = 32;
        powBase = 6;
        defBase = 5;
        resetStatus();
    }

    @Override
    public void attack(Personagem target) {
        System.out.println(name + " levanta sua espada e golpeia " + target.name + "!");
        target.receiveDamage(pow);
    }

    @Override
    public void defend() {
        System.out.println(name + " ergue seu escudo para se proteger!");
        def += defBase;
    }

    @Override
    public void useSpecial(Personagem target) {
        System.out.println(name + " balança sua espada no ar que começa a brilhar incessantemente, desferindo um corte vertical poderoso em seu adversário!!!");
        target.receiveDamage(pow*2);
    }


    @Override
    public void levelUp(){
        level++;
        System.out.println(String.format("%s subiu para o nível %d.", name, level));;

        hpBase += 4;
        powBase += 2;
        defBase += 2;
        if(level  == 4){
            System.out.println("O poder especial da classe foi desbloqueado!");
            specialUnlocked = true;
        }

        resetStatus();
    }
}

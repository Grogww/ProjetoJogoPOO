package game;

public class Mago extends Personagem{

    public Mago(String name){
        this.name = name;
        this.level = 1;
        specialUnlocked = false;
        hpBase = 22;
        powBase = 14;
        defBase = 4;
        resetStatus();
    }

    @Override
    public void attack(Personagem target) {
        System.out.println(name + " libera magia de seu cajado e atinge " + target.name + "!");
        target.receiveDamage(pow);
    }

    @Override
    public void defend() {
        System.out.println(name + " se protege com uma barreira de magia!");
        def += defBase;
    }

    @Override
    public void useSpecial(Personagem target) {
        System.out.println(name + " canaliza magia ao seu redor, e dispara um raio poderoso cortando o campo de batalha!!!");
        target.receiveDamage(pow+10);
    }

    @Override
    public void levelUp(){
        level++;
        System.out.println(String.format("%s subiu para o nível %d.", name, level));;

        hpBase += 2;
        powBase += 3;
        defBase += 2;
        if(level  == 4){
            System.out.println("O poder especial da classe foi desbloqueado!");
            specialUnlocked = true;
        }

        resetStatus();
    }

}